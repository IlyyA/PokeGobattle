package ca.pokebattle.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
/**
 * Move Entity
 * @author Ilyas
 *
 */
@Entity
@Table(name = "MOVE")
public class Move implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCEID")
	@SequenceGenerator(name = "SEQUENCEID", sequenceName = "ID_SEQUENCE")
	@Column(name = "ID")
	private Long genId;
	
	
	@Column(name = "NAME")
	private String name;

	@Column(name = "TYPE")
	private String typeName;
	
	@Column(name = "POKEMON")
	private String pokemon;
	
	@Transient
	private NamedAPIResource type;
	
	Move(NamedAPIResource type, String name) {
		this.name = name;
		this.type = type;
	}
	
	Move(String name, String typeName, String pokemon) {
		this.name = name;
		this.typeName = typeName;
		this.pokemon = pokemon;
	}
	
	Move() {
		
	}

	public final String getName() {
		return name;
	}

	
	public final NamedAPIResource getType() {
		return type;
	}

	public final void setType(NamedAPIResource type) {
		this.type = type;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getTypeName() {
		return typeName;
	}

	public final void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public final String getPokemon() {
		return pokemon;
	}

	public final void setPokemon(String pokemon) {
		this.pokemon = pokemon;
	}
	
	
}
