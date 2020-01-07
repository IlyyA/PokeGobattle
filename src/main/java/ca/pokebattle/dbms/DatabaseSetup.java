package ca.pokebattle.dbms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ca.pokebattle.entity.APIResourceList;
import ca.pokebattle.entity.Move;
import ca.pokebattle.entity.Pokemon;
import ca.pokebattle.entity.PokemonMove;
import ca.pokebattle.entity.Type;
import ca.pokebattle.repository.MoveRepository;
import ca.pokebattle.repository.PokemonRepository;
import ca.pokebattle.repository.TypeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import ca.pokebattle.entity.NamedAPIResource;

@Configuration
public class DatabaseSetup {


	private static int TOTAL_POKEMON = 151;
	private static String BASE_URL = "http://www.pokeapi.co/api/v2";

	private Logger log = LoggerFactory.getLogger(DatabaseSetup.class);

	private PokemonRepository pokemonRepository;

	private TypeRepository typeRepository;

	private MoveRepository moveRepository;

	final String RESOURCE_DIR = "C:/CHANGE/TO/PATH/TO/RESOURCE/FOLDER";

	private boolean restartApplication = false;

	@Autowired
	public void setPokemonRepository(PokemonRepository pokemonRepository) {
		this.pokemonRepository = pokemonRepository;
	}

	@Autowired
	public void setTypeRepository(TypeRepository typeRepository) {
		this.typeRepository = typeRepository;
	}

	@Autowired
	public void setMoveRepoiory(MoveRepository moveRepository) {
		this.moveRepository = moveRepository;
	}

	public boolean populateDB() throws IOException, URISyntaxException {

		
		/**
		 * Populating Pokemon
		 */
		
		CloseableHttpClient client = HttpClientBuilder.create().build();
		APIResourceList pokeUrls = getPokeUrls(client);
		downloadPokeJson(pokeUrls);
		if (restartApplication) {
			log.info(
					"Data missing from pokemon resource folder has been downloaded successfully. Refresh working directory and restart application.");
			return restartApplication;
		}
		List<Pokemon> allPokemon = getPokemon(pokeUrls);
		for (Pokemon pokemon : allPokemon) {
			List<Pokemon> results = pokemonRepository.findById(pokemon.getId());
			if (results.isEmpty())
				pokemonRepository.save(pokemon);
		}

		/**
		 * Populating Types
		 */
		
		APIResourceList typeUrls = getTypeUrls(client);
		downloadTypeJson(typeUrls);
		if (restartApplication) {
			log.info("Data missing from types resource folder has been downloaded successfully. Refresh working directory and restart application.");
			return restartApplication;
		}
		List<Type> allTypes = getTypes(typeUrls);
		for (Type type : allTypes) {
			List<Type> results = typeRepository.findById(type.getId());
			if (results.isEmpty())
				typeRepository.save(type);
		}

		/**
		 * Populating Moves
		 */
		
		for (Pokemon pokemon : allPokemon) {
			for (PokemonMove pokeMove : pokemon.getMoves()) {
				String[] urlParse = pokeMove.getMove().getUrl().split("/");
				if (Integer.parseInt(urlParse[6]) > 165) {
					continue;
				}
				Move move = getMove(pokeMove.getMove().getName(), pokeMove.getMove().getUrl(), client);
				if (move == null) {
					continue;
				}
				move.setTypeName(move.getType().getName());
				move.setPokemon(pokemon.getName());
				List<Move> results = moveRepository.findByNameAndTypeNameAndPokemon(move.getName(), move.getTypeName(),
						move.getPokemon());
				// Over 4000 combinations
				if (results.isEmpty())
					moveRepository.save(move);
			}
		}
		log.info("Completed setup of database.");
		return restartApplication;
	}

	/**
	 * Uses JSON of Pokemon URLs to look for each Pokemon in resource folder
	 * If it cannot find the resource, downloads the resource into folder from public API and sets restartApplication to true
	 * If it can find the resource, continues
	 * @param pokeUrls
	 */
	private void downloadPokeJson(APIResourceList pokeUrls) {
		final int BUFFER_SIZE = 4096;
		final String saveDir = "/src/main/resources/pokemon";
		try {
			for (NamedAPIResource pokeInfo : pokeUrls.getResults()) {
				if (DatabaseSetup.class.getClass().getResource("/pokemon/" + pokeInfo.getName() + ".json") == null) {
					log.info("Could not find {} - downloading JSON...", pokeInfo.getName());
					restartApplication = true;
					URL url = new URL(pokeInfo.getUrl());
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestProperty("User-agent", "pokegobattle");
					if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
						InputStream inputStream = conn.getInputStream();

						String saveFilePath = RESOURCE_DIR + "pokemon/" + pokeInfo.getName() + ".json";

						// opens an output stream to save into file
						FileOutputStream outputStream = new FileOutputStream(saveFilePath);

						int bytesRead = -1;
						byte[] buffer = new byte[BUFFER_SIZE];
						while ((bytesRead = inputStream.read(buffer)) != -1) {
							outputStream.write(buffer, 0, bytesRead);
						}

						outputStream.close();
						inputStream.close();
						log.info("{} successfully saved.", pokeInfo.getName());
					}
				} else {
				}
			}
		} catch (IOException e) {
			log.error("Failed: " + e.getMessage());

		}
	}

	/**
	 * Uses JSON of Type URLs to look for each Type in resource folder
	 * If it cannot find the resource, downloads the resource into folder from public API and sets restartApplication to true
	 * If it can find the resource, continues
	 * @param typeUrls
	 */
	private void downloadTypeJson(APIResourceList typeUrls) {
		final int BUFFER_SIZE = 4096;
		try {
			for (NamedAPIResource typeInfo : typeUrls.getResults()) {
				if (DatabaseSetup.class.getClass().getResource("/type/" + typeInfo.getName() + ".json") == null) {
					log.info("Could not find {} - downloading JSON...", typeInfo.getName());
					restartApplication = true;
					URL url = new URL(typeInfo.getUrl());
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestProperty("User-agent", "pokegobattle");
					if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
						InputStream inputStream = conn.getInputStream();
						String saveFilePath = RESOURCE_DIR + "type/" + typeInfo.getName() + ".json";

						// opens an output stream to save into file
						FileOutputStream outputStream = new FileOutputStream(saveFilePath);

						int bytesRead = -1;
						byte[] buffer = new byte[BUFFER_SIZE];
						while ((bytesRead = inputStream.read(buffer)) != -1) {
							outputStream.write(buffer, 0, bytesRead);
						}

						outputStream.close();
						inputStream.close();
						log.info("{} successfully saved.", typeInfo.getName());
					}
				} else {
				}
			}
		} catch (IOException e) {
			log.error("Failed: " + e.getMessage());

		}
	}
	
	
	/**
	 * Uses JSON of Move URLs to look for each Move in resource folder
	 * If it cannot find the resource, downloads the resource into folder from public API
	 * If it can find the resource, continues
	 * @param moveURL
	 * @param moveName
	 * @return
	 */
	private boolean downloadMove(String moveURL, String moveName) {
		final int BUFFER_SIZE = 4096;
		try {
			if (DatabaseSetup.class.getClass().getResource("/move/" + moveName + ".json") == null) {
				log.info("Could not find {} - downloading JSON...", moveName);
				restartApplication = true;
				URL url = new URL(moveURL);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestProperty("User-agent", "pokegobattle");
				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					InputStream inputStream = conn.getInputStream();
					String saveFilePath = RESOURCE_DIR + "move/" + moveName + ".json";

					// opens an output stream to save into file
					FileOutputStream outputStream = new FileOutputStream(saveFilePath);

					int bytesRead = -1;
					byte[] buffer = new byte[BUFFER_SIZE];
					while ((bytesRead = inputStream.read(buffer)) != -1) {
						outputStream.write(buffer, 0, bytesRead);
					}

					outputStream.close();
					inputStream.close();
					log.info("{} successfully saved.", moveName);
					return true;
				}
			} else {
				return true;
			}
		} catch (IOException e) {
			log.error("Failed: " + e.getMessage());
			return false;
		}
		return false;
	}

	//Gets JSON of all Pokemon URLs to load into resource folder
	private APIResourceList getPokeUrls(CloseableHttpClient client) {
		if (DatabaseSetup.class.getClass().getResource("/pokemon/151pokemon.json") != null) {
			String content;
			try {
				content = new String(Files.readAllBytes(
						Paths.get(DatabaseSetup.class.getClass().getResource("/pokemon/151pokemon.json").toURI())));
				Gson gson = new Gson();
				APIResourceList pokeUrls = gson.fromJson(content, APIResourceList.class);
				return pokeUrls;
			} catch (IOException | URISyntaxException e) {
				log.error(e.getMessage());
			}

		}
		Gson g = new GsonBuilder().create();
		APIResourceList rl = new APIResourceList();
		HttpGet request = new HttpGet(BASE_URL + "/pokemon/?limit=151");
		try {
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			rl = g.fromJson(rd, APIResourceList.class);
		} catch (Exception e) {
			log.error("Failed: " + e.getMessage());
		}
		return rl;
	}

	//Gets JSON of all Type URLs to load into resource folder
	private APIResourceList getTypeUrls(CloseableHttpClient client) {
		if (DatabaseSetup.class.getClass().getResource("/type/types.json") != null) {
			String content;
			try {
				content = new String(Files.readAllBytes(
						Paths.get(DatabaseSetup.class.getClass().getResource("/type/types.json").toURI())));
				Gson gson = new Gson();
				APIResourceList typeUrls = gson.fromJson(content, APIResourceList.class);
				return typeUrls;
			} catch (IOException | URISyntaxException e) {
				log.error(e.getMessage());
			}

		}
		Gson g = new GsonBuilder().create();
		APIResourceList rl = new APIResourceList();
		HttpGet request = new HttpGet(BASE_URL + "/type/");
		try {
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			rl = g.fromJson(rd, APIResourceList.class);
		} catch (Exception e) {
			log.error("Failed: " + e.getMessage());
		}
		return rl;
	}

	/**
	 * Deserializes JSON into Pokemon objects using GSON
	 * @param pokeUrls
	 * @return list of deserialized Pokemon objects
	 */
	private List<Pokemon> getPokemon(APIResourceList pokeUrls) {
		List<String> pokemonJSON = new ArrayList<>();
		List<Pokemon> allPokemon = new ArrayList<Pokemon>();
		for (NamedAPIResource pokeInfo : pokeUrls.getResults()) {
			pokemonJSON.add("/pokemon/" + pokeInfo.getName() + ".json");
		}
		for (String pokeName : pokemonJSON) {
			try {
				if (DatabaseSetup.class.getClass().getResource(pokeName) == null)
					continue;
				URI uri = DatabaseSetup.class.getClass().getResource(pokeName).toURI();
				String content = new String(Files.readAllBytes(Paths.get(uri)));
				Gson gson = new Gson();
				Pokemon pokemon = gson.fromJson(content, Pokemon.class);
				pokemon.setType();
				allPokemon.add(pokemon);
			} catch (IOException | URISyntaxException e) {
				log.error(e.getMessage());
			}
		}
		return allPokemon;

	}
	
	/**
	 * Deserializes JSON into Type objects using GSON
	 * @param typeUrls
	 * @return list of deserialized Type objects
	 */
	private List<Type> getTypes(APIResourceList typeUrls) {
		List<String> typeJSON = new ArrayList<>();
		List<Type> allTypes = new ArrayList<Type>();
		for (NamedAPIResource typeInfo : typeUrls.getResults()) {
			typeJSON.add("/type/" + typeInfo.getName() + ".json");
		}
		for (String typeName : typeJSON) {
			try {
				if (DatabaseSetup.class.getClass().getResource(typeName) == null)
					continue;
				String content = new String(
						Files.readAllBytes(Paths.get(DatabaseSetup.class.getClass().getResource(typeName).toURI())));
				Gson gson = new Gson();
				Type type = gson.fromJson(content, Type.class);
				allTypes.add(type);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		return allTypes;

	}

	/**
	 * Deserialzes Move JSONs into Move objects using GSON
	 * @param moveName
	 * @param moveURL
	 * @param client
	 * @return Move object
	 */
	private Move getMove(String moveName, String moveURL, CloseableHttpClient client) {
		Gson g = new GsonBuilder().create();
		Move move = null;
		if (downloadMove(moveURL, moveName)) {
			String moveJSON = "/move/" + moveName + ".json";
			try {
				if (DatabaseSetup.class.getClass().getResource(moveJSON) == null)
					return move;
				String content = new String(
						Files.readAllBytes(Paths.get(DatabaseSetup.class.getClass().getResource(moveJSON).toURI())));
				Gson gson = new Gson();
				move = gson.fromJson(content, Move.class);
				return move;
			} catch (Exception e) {
				return move;
			}
		} else {
			HttpGet request = new HttpGet(moveURL);
			log.info("Sending request to " + moveURL);
			BufferedReader rd = null;
			HttpResponse response;
			try {
				response = client.execute(request);
				log.info("Response code: " + response.getStatusLine().getStatusCode());
				rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			} catch (Exception e) {
				log.error("Failed: " + e.getMessage());
			}
			move = g.fromJson(rd, Move.class);
			return move;
		}
	}

}
