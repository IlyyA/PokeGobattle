package ca.pokebattle.entity;
/**
 * Used to gather data from PokeAPI site using GSON
 * @author Ily
 *
 */
public class PokemonType {
	private int slot;
	private NamedAPIResource type;
	
	public final int getSlot() {
		return slot;
	}

	public final void setSlot(int slot) {
		this.slot = slot;
	}

	public final NamedAPIResource getType() {
		return type;
	}

	public final void setType(NamedAPIResource type) {
		this.type = type;
	}

	PokemonType(int slot, NamedAPIResource type) {
		this.slot = slot;
		this.type = type;
	}
}
