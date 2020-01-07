package ca.pokebattle.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ca.pokebattle.entity.Move;
import ca.pokebattle.entity.Pokemon;
import ca.pokebattle.entity.PokemonChoices;
import ca.pokebattle.entity.PokemonMoveSelects;
import ca.pokebattle.entity.Type;
import ca.pokebattle.model.DamageModifierModel;
import ca.pokebattle.repository.MoveRepository;
import ca.pokebattle.repository.PokemonRepository;
import ca.pokebattle.repository.TypeRepository;

@SessionAttributes(value = {"pokeChoices", "moveForm"})
@Controller
public class DisplayBattleController {
	
	private Logger log = LoggerFactory.getLogger(DisplayBattleController.class);
	
	@Autowired
	private DamageModifierModel damageAlgo;
	
	private MoveRepository moveRepository;
	
	private PokemonRepository pokemonRepository;
	
	private TypeRepository typeRepository;
	
	@Autowired
	public void setMoveRepository(MoveRepository moveRepository) {
		this.moveRepository = moveRepository;
	}
	
	@Autowired
	public void setPokemonRepository(PokemonRepository pokemonRepository) {
		this.pokemonRepository = pokemonRepository;
	}
	
	@Autowired
	public void setTypeRepository(TypeRepository typeRepository) {
		this.typeRepository = typeRepository;
	}
	
	
	/**
	 * Runs damage calculations and injects into model
	 * Clean up Pokemon names for better presentation
	 * @param model
	 * @param pokeChoices
	 * @param moveForm
	 * @param status
	 * @return
	 */
	@RequestMapping(value="/displayBattle", method = RequestMethod.GET)
	public String welcome(Model model, @ModelAttribute("pokeChoices") PokemonChoices pokeChoices, @ModelAttribute("moveForm") PokemonMoveSelects moveForm, SessionStatus status) {
		
		List<Pokemon> enemyPokemon = pokemonRepository.findByName(pokeChoices.getPokeEnemy().toLowerCase());
		String enemyType = enemyPokemon.get(0).getType();
		
		String poke1Damage = getAttack(moveForm.getPoke1Move(), enemyType);
		String poke1STAB = getSTAB(pokeChoices.getPoke1().toLowerCase(), moveForm.getPoke1Move());
		model.addAttribute("poke1Damage", poke1Damage);
		model.addAttribute("poke1STAB", poke1STAB);
		
		String poke2Damage = getAttack(moveForm.getPoke2Move(), enemyType);
		String poke2STAB = getSTAB(pokeChoices.getPoke2().toLowerCase(), moveForm.getPoke2Move());
		model.addAttribute("poke2Damage", poke2Damage);
		model.addAttribute("poke2STAB", poke2STAB);
		
		String poke3Damage = getAttack(moveForm.getPoke3Move(), enemyType);
		String poke3STAB = getSTAB(pokeChoices.getPoke3().toLowerCase(), moveForm.getPoke3Move());
		model.addAttribute("poke3Damage", poke3Damage);
		model.addAttribute("poke3STAB", poke3STAB);
		
		String poke4Damage = getAttack(moveForm.getPoke4Move(), enemyType);
		String poke4STAB = getSTAB(pokeChoices.getPoke4().toLowerCase(), moveForm.getPoke4Move());
		model.addAttribute("poke4Damage", poke4Damage);
		model.addAttribute("poke4STAB", poke4STAB);
		
		String poke5Damage = getAttack(moveForm.getPoke5Move(), enemyType);
		String poke5STAB = getSTAB(pokeChoices.getPoke5().toLowerCase(), moveForm.getPoke5Move());
		model.addAttribute("poke5Damage", poke5Damage);
		model.addAttribute("poke5STAB", poke5STAB);
		
		String poke6Damage = getAttack(moveForm.getPoke6Move(), enemyType);
		String poke6STAB = getSTAB(pokeChoices.getPoke6().toLowerCase(), moveForm.getPoke6Move());
		model.addAttribute("poke6Damage", poke6Damage);
		model.addAttribute("poke6STAB", poke6STAB);
		
		model.addAttribute("pokeChoices", pokeChoices);
		model.addAttribute("moveForm", moveForm);
		
		return "displayBattle";
		
	}
	
	
	//Damage calculations
	
	
	private String getAttack(String move, String enemyType) {
		List<Move> moveList = moveRepository.findByName(move);
		String moveType = moveList.get(0).getTypeName();
		
		String result = damageAlgo.getDamageModifier(moveType, enemyType);
		
		return result;
	}
	
	private String getSTAB(String pokemonName, String moveString) {
		List<Pokemon> pokeList = pokemonRepository.findByName(pokemonName);
		String pokeTypeString = pokeList.get(0).getType();
		List<Type> pokeTypeList = typeRepository.findByName(pokeTypeString);
		Type pokeType = pokeTypeList.get(0);
		
		List<Move> moveList = moveRepository.findByName(moveString);
		String moveTypeString = moveList.get(0).getTypeName();
		
		List<Type> moveTypeList = typeRepository.findByName(moveTypeString);
		Type moveType = moveTypeList.get(0);
		
		return damageAlgo.isSTAB(pokeType, moveType);
	}

}
