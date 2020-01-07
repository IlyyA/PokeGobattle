package ca.pokebattle.entity;
/**
 * Used to get data from PokeAPI site using GSON
 * @author Ilyas
 *
 */
public class NamedAPIResource {
	private String name;
	private String url;
	
	NamedAPIResource(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public final String getName() {
		return name;
	}

	public final void setName(final String name) {
		this.name = name;
	}

	public final String getUrl() {
		return url;
	}

	public final void setUrl(final String url) {
		this.url = url;
	}
	
	
}
