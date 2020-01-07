package ca.pokebattle.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ca.pokebattle.entity.Pokemon;
import ca.pokebattle.entity.PokemonChoices;
import ca.pokebattle.repository.PokemonRepository;

@Component
public class PokemonChoicesValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return PokemonChoices.class.equals(clazz);
	}
	
	
	private PokemonRepository pokemonRepository;
	
	@Autowired
	public void setPokemonRepository(PokemonRepository pokemonRepository) {
		this.pokemonRepository = pokemonRepository;
	}
/**
 * Validates Pokemon entries
 */
	@Override
	public void validate(Object target, Errors errors) {
		PokemonChoices pokeChoices = (PokemonChoices) target;
		if (isNotInDB(pokeChoices.getPoke1())) {
			errors.rejectValue("poke1", "validator.pokemon", "Cannot find Pokémon.");
		}
		if (isNotInDB(pokeChoices.getPoke2())) {
			errors.rejectValue("poke2", "validator.pokemon", "Cannot find Pokémon.");
		}
		if (isNotInDB(pokeChoices.getPoke3())) {
			errors.rejectValue("poke3", "validator.pokemon", "Cannot find Pokémon.");
		}
		if (isNotInDB(pokeChoices.getPoke4())) {
			errors.rejectValue("poke4", "validator.pokemon", "Cannot find Pokémon.");
		}
		if (isNotInDB(pokeChoices.getPoke5())) {
			errors.rejectValue("poke5", "validator.pokemon","Cannot find Pokémon.");
		}
		if (isNotInDB(pokeChoices.getPoke6())) {
			errors.rejectValue("poke6", "validator.pokemon", "Cannot find Pokémon.");
		}
		if (isNotInDB(pokeChoices.getPokeEnemy())) {
			errors.rejectValue("pokeEnemy", "validator.pokemon", "Cannot find Pokémon.");
		}
		
	}
	
	private boolean isNotInDB(String pokeName) {
		List<Pokemon> poke = pokemonRepository.findByName(pokeName.toLowerCase());
		return poke == null | poke.isEmpty();
	}

}
