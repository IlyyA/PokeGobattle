package ca.pokebattle.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * Type Entity
 * @author Ily
 *
 */
@Entity
@Table(name="TYPE")
public class Type implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQUENCEID")
	@SequenceGenerator(name = "SEQUENCEID", sequenceName="ID_SEQUENCE")
	@Column(name="ID")
	private Long genTypeId;
	
	@Column(name="TYPE_ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	public final Long getGenTypeId() {
		return genTypeId;
	}

	public final void setGenTypeId(Long genTypeId) {
		this.genTypeId = genTypeId;
	}

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	Type(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	Type() {
		
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((genTypeId == null) ? 0 : genTypeId.hashCode());
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
		Type other = (Type) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Name: " + this.name + "\nType ID: " + this.genTypeId;
	}
}
