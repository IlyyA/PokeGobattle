package ca.pokebattle.entity;

/**
 * NOTE: NOT USED IN APPLICATION
 * @author Ily
 *
 */
public class TypeRelation {
	private NamedAPIResource no_damage_to;
	private NamedAPIResource half_damage_to;
	private NamedAPIResource double_damage_to;
	private NamedAPIResource no_damage_from;
	private NamedAPIResource half_damage_from;
	private NamedAPIResource double_damage_from;
	

	TypeRelation(NamedAPIResource no_damage_to, NamedAPIResource no_damage_from, NamedAPIResource half_damage_to, NamedAPIResource half_damage_from, NamedAPIResource double_damage_from, NamedAPIResource 
			double_damage_to) {
		this.no_damage_to = no_damage_to;
		this.no_damage_from = no_damage_from;
		this.half_damage_to = half_damage_to;
		this.half_damage_from = half_damage_from;
		this.double_damage_to = double_damage_to;
		this.double_damage_from = double_damage_from;
	}
	
	public final NamedAPIResource getNo_damage_to() {
		return no_damage_to;
	}

	public final void setNo_damage_to(NamedAPIResource no_damage_to) {
		this.no_damage_to = no_damage_to;
	}

	public final NamedAPIResource getHalf_damage_to() {
		return half_damage_to;
	}

	public final void setHalf_damage_to(NamedAPIResource half_damage_to) {
		this.half_damage_to = half_damage_to;
	}

	public final NamedAPIResource getDouble_damage_to() {
		return double_damage_to;
	}

	public final void setDouble_damage_to(NamedAPIResource double_damage_to) {
		this.double_damage_to = double_damage_to;
	}

	public final NamedAPIResource getNo_damage_from() {
		return no_damage_from;
	}

	public final void setNo_damage_from(NamedAPIResource no_damage_from) {
		this.no_damage_from = no_damage_from;
	}

	public final NamedAPIResource getHalf_damage_from() {
		return half_damage_from;
	}

	public final void setHalf_damage_from(NamedAPIResource half_damage_from) {
		this.half_damage_from = half_damage_from;
	}

	public final NamedAPIResource getDouble_damage_from() {
		return double_damage_from;
	}

	public final void setDouble_damage_from(NamedAPIResource double_damage_from) {
		this.double_damage_from = double_damage_from;
	}

}
