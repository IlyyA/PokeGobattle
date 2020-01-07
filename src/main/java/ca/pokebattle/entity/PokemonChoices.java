package ca.pokebattle.entity;

import org.springframework.stereotype.Component;
/**
 * Pokemon Choices entity
 * @author Ilyas
 *
 */
@Component
public class PokemonChoices {
	
	private String poke1;
	
	private String poke2;
	
	private String poke3;

	private String poke4;
	
	private String poke5;
	
	private String poke6;
	
	private String pokeEnemy;

	public final String getPoke1() {
		return poke1;
	}

	public final void setPoke1(String poke1) {
		this.poke1 = poke1;
	}

	public final String getPoke2() {
		return poke2;
	}

	public final void setPoke2(String poke2) {
		this.poke2 = poke2;
	}

	public final String getPoke3() {
		return poke3;
	}

	public final void setPoke3(String poke3) {
		this.poke3 = poke3;
	}

	public final String getPoke4() {
		return poke4;
	}

	public final void setPoke4(String poke4) {
		this.poke4 = poke4;
	}

	public final String getPoke5() {
		return poke5;
	}

	public final void setPoke5(String poke5) {
		this.poke5 = poke5;
	}

	public final String getPoke6() {
		return poke6;
	}

	public final void setPoke6(String poke6) {
		this.poke6 = poke6;
	}

	public final String getPokeEnemy() {
		return pokeEnemy;
	}

	public final void setPokeEnemy(String pokeEnemy) {
		this.pokeEnemy = pokeEnemy;
	}
	
	public PokemonChoices() {
		
	}
	
	@Override
	public String toString() {
		return "Pokemon 1: " + poke1 + " | Pokemon 2: " + poke2 + " | Pokemon 3: " + poke3 + " | Enemy Pokemon: " + pokeEnemy;
	}

}
