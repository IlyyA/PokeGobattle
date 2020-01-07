package ca.pokebattle;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ca.pokebattle.dbms.DatabaseSetup;
import ca.pokebattle.entity.Pokemon;
import ca.pokebattle.repository.PokemonRepository;
import ca.pokebattle.repository.TypeRepository;

/**
 * Main file
 * Runs application
 * Ends application if given signal
 * @author Ilyas
 *
 */

@SpringBootApplication
public class PokeGoBattleApplication {
	

	private static DatabaseSetup databaseSetup;

	private static PokemonRepository pokemonRepository;
	
	private static TypeRepository typeRepository;
	
	private static final Logger log = LoggerFactory.getLogger(PokeGoBattleApplication.class);
	
	@Autowired
	public void setPokemonRepository(PokemonRepository pokemonRepository) {
		this.pokemonRepository = pokemonRepository;
	}
	
	@Autowired
	public void setTypeRepository(TypeRepository typeRepository) {
		this.typeRepository = typeRepository;
	}
	
	@Autowired
	public void setDatabaseSetup(DatabaseSetup databaseSetup) {
		this.databaseSetup = databaseSetup;
	}

	public static void main(String[] args) throws IOException, URISyntaxException {


		
		ApplicationContext appC = SpringApplication.run(PokeGoBattleApplication.class, args);

		if (databaseSetup.populateDB())
			SpringApplication.exit(appC);

	}

}

