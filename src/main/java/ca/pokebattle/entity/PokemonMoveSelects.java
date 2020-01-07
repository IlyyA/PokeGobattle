package ca.pokebattle.entity;

import org.springframework.stereotype.Component;
/**
 * Stores information for model injection
 * @author Ily
 *
 */
@Component
public class PokemonMoveSelects {
	
	private String poke1Move;
	
	private String poke2Move;
	
	private String poke3Move;
	
	private String poke4Move;
	
	private String poke5Move;
	
	private String poke6Move;
	
	
	
	public final String getPoke1Move() {
		return poke1Move;
	}



	public final void setPoke1Move(String poke1Move) {
		this.poke1Move = poke1Move;
	}



	public final String getPoke2Move() {
		return poke2Move;
	}



	public final void setPoke2Move(String poke2Move) {
		this.poke2Move = poke2Move;
	}



	public final String getPoke3Move() {
		return poke3Move;
	}



	public final void setPoke3Move(String poke3Move) {
		this.poke3Move = poke3Move;
	}



	public final String getPoke4Move() {
		return poke4Move;
	}



	public final void setPoke4Move(String poke4Move) {
		this.poke4Move = poke4Move;
	}



	public final String getPoke5Move() {
		return poke5Move;
	}



	public final void setPoke5Move(String poke5Move) {
		this.poke5Move = poke5Move;
	}



	public final String getPoke6Move() {
		return poke6Move;
	}



	public final void setPoke6Move(String poke6Move) {
		this.poke6Move = poke6Move;
	}



	public PokemonMoveSelects() {
		
	}
	
	@Override
	public final String toString() {
		return "Pokemon 1 Move: " + poke1Move; 
	}

}
