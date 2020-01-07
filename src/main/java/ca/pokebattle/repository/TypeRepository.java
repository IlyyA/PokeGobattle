package ca.pokebattle.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;

import ca.pokebattle.entity.Type;

/**
 * Type Repository using Spring Data
 * @author Ily
 *
 */
public interface TypeRepository extends Repository<Type, Long> {
	
	List<Type> findById(Integer id);
	List<Type> findByName(String name);
	List<Type> findAll();
	Type save(Type type);

}
