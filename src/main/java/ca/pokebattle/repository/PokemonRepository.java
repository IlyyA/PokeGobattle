package ca.pokebattle.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;

import ca.pokebattle.entity.Pokemon;

/**
 * Pokemon Repository using Spring Data
 * @author Ily
 *
 */
public interface PokemonRepository extends Repository<Pokemon, Long> {
	
	List<Pokemon> findById(Integer id);
	List<Pokemon> findByName(String name);
	List<Pokemon> findAll();
	
	@Query("SELECT name FROM Pokemon p WHERE p.name=:pokemon")
	List<String> findPokemonNames(@Param("pokemon") String pokeName);
	Pokemon save(Pokemon pokemon);

}
