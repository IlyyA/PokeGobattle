package ca.pokebattle.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.text.WordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ca.pokebattle.entity.Move;
import ca.pokebattle.entity.PokemonChoices;
import ca.pokebattle.entity.PokemonMoveSelects;
import ca.pokebattle.repository.MoveRepository;

@SessionAttributes(value = {"pokeChoices", "moveForm"})
@Controller
public class ChooseMovesController {
	
	private Logger log = LoggerFactory.getLogger(ChooseMovesController.class);


	private MoveRepository moveRepository;
	
	
	@Autowired
	public void setMoveRepository(MoveRepository moveRepository) {
		this.moveRepository = moveRepository;
	}

	
	/**
	 * Fixes incorrect capitalization for better display and injects into model
	 * Injects move list into model
	 * @param model
	 * @param pokeChoices
	 * @param status
	 * @return
	 */
	@RequestMapping(value="/chooseMoves", method = RequestMethod.GET)
	public String welcome(Model model, @ModelAttribute("pokeChoices") PokemonChoices pokeChoices, SessionStatus status) {
		String p1 = pokeChoices.getPoke1().toLowerCase();
		String p2 = pokeChoices.getPoke2().toLowerCase();
		String p3 = pokeChoices.getPoke3().toLowerCase();
		String p4 = pokeChoices.getPoke4().toLowerCase();
		String p5 = pokeChoices.getPoke5().toLowerCase();
		String p6 = pokeChoices.getPoke6().toLowerCase();
		String e1 = WordUtils.capitalize(pokeChoices.getPokeEnemy());
		
		pokeChoices.setPoke1(WordUtils.capitalize(p1));
		pokeChoices.setPoke2(WordUtils.capitalize(p2));
		pokeChoices.setPoke3(WordUtils.capitalize(p3));
		pokeChoices.setPoke4(WordUtils.capitalize(p4));
		pokeChoices.setPoke5(WordUtils.capitalize(p5));
		pokeChoices.setPoke6(WordUtils.capitalize(p6));
		pokeChoices.setPokeEnemy(WordUtils.capitalize(e1));

		
		model.addAttribute("p1Moves", getMap(p1));
		model.addAttribute("p2Moves", getMap(p2));
		model.addAttribute("p3Moves", getMap(p3));
		model.addAttribute("p4Moves", getMap(p4));
		model.addAttribute("p5Moves", getMap(p5));
		model.addAttribute("p6Moves", getMap(p6));
		model.addAttribute("enemyName", e1);
		model.addAttribute("moveForm", new PokemonMoveSelects());
		return "chooseMoves";
	}
	
	
	//Gets move list from repository
	Map<String, String> getMap(String pokemonName) {
		Map<String, String> pokeMap = new LinkedHashMap<String, String>();
		List<String> pMoves = moveRepository.findMoveNames(pokemonName);
		
		for (String move : pMoves) {
			pokeMap.put(move, move);
		}
		return pokeMap;
	}
	
	
	@RequestMapping(value="/chooseMoves", method = RequestMethod.POST)
	public String onSubmit(Model model, @ModelAttribute("moveForm") PokemonMoveSelects moveForm,  BindingResult result) {
		
		return "redirect:/displayBattle";
	}

}
