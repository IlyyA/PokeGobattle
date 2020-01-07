package ca.pokebattle.entity;
/**
 * Used to get data from PokeAPI site using GSON
 * @author Ily
 *
 */
public class PokemonMove {
	
	NamedAPIResource move;

	public final NamedAPIResource getMove() {
		return move;
	}

	public final void setMove(NamedAPIResource move) {
		this.move = move;
	}
	
	PokemonMove(NamedAPIResource move) {
		this.move = move;
	}

}
