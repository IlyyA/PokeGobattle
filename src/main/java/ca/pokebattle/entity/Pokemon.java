package ca.pokebattle.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;
/**
 * Pokemon Entity
 * @author Ilyas
 *
 */
@Entity
@Table(name = "POKEMON")

public class Pokemon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCEID")
	@SequenceGenerator(name = "SEQUENCEID", sequenceName = "ID_SEQUENCE")
	@Column(name = "ID")
	private Long genId;

	@Column(name = "POKEMON_ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "TYPE")
	private String type;
	
	@Transient
	private List<PokemonType> types;
	
	@Transient
	private List<PokemonMove> moves;

	Pokemon(Integer id, String name, List<PokemonType> types, List<PokemonMove> moves) {
		this.id = id;
		this.name = name;
		this.types = types;
		this.moves = moves;
	}

	public Pokemon() {

	}

	
	public final List<PokemonMove> getMoves() {
		return moves;
	}

	public final void setMoves(List<PokemonMove> moves) {
		this.moves = moves;
	}

	public List<PokemonType> getTypes() {
		return this.types;
	}

	public void setTypes(List<PokemonType> types) {
		this.types = types;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = this.type;
	}
	
	public void setType() {
		this.type = this.types.get(0).getType().getName();
	}
	
	public Long getgenId() {
		return this.genId;
	}

	public void setgenId(final Long genId) {
		this.genId = genId;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + "\nPokemon ID: " + this.id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((genId == null) ? 0 : genId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Pokemon))
			return false;
		Pokemon other = (Pokemon) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!genId.equals(other.genId))
			return false;
		return true;
	}

}
