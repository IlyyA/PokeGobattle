package ca.pokebattle.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;

import ca.pokebattle.entity.Move;

/**
 * Move Repository using Spring Data
 * @author Ily
 *
 */
public interface MoveRepository extends Repository<Move, Long> {

	List<Move> findByName(String name);
	List<Move> findAll();
	List<Move> findByNameAndTypeNameAndPokemon(String name, String typeName, String pokemon);
	List<Move> findByPokemon(String pokemon);
	
	//Custom Query
	@Query("SELECT name FROM Move m WHERE m.pokemon=:pokemon")
	List<String> findMoveNames(@Param("pokemon") String pokeName);
	Move save(Move move);
}
