package ca.pokebattle.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;

import ca.pokebattle.entity.PokemonChoices;
import ca.pokebattle.validator.PokemonChoicesValidator;

@SessionAttributes("pokeChoices")
@Controller
public class ChoosePokemonController {

	private Logger log = LoggerFactory.getLogger(ChoosePokemonController.class);

	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@Autowired
	private PokemonChoices pokeChoices;
	
	@Autowired
	PokemonChoicesValidator pokeValidator;

	@GetMapping("/choosePokemon")
	public String welcome(Model model) {
		model.addAttribute("pokeChoices", new PokemonChoices());
		return "choosePokemon";
	}
	/**
	 * Injects model into JSP to grab Pokemon choices
	 * Runs validation
	 * @param model
	 * @param pokeChoices
	 * @param result
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "/choosePokemon", method = RequestMethod.POST)
	public String choosePokemon(Model model, @ModelAttribute("pokeChoices") @Validated PokemonChoices pokeChoices, BindingResult result,
			SessionStatus status) {
		
		pokeValidator.validate(pokeChoices, result);
		if (result.hasErrors()) {
			model.addAttribute("errors", result);
			model.addAttribute("pokeChoices", pokeChoices);
			return "choosePokemon";
		} else {
			return "redirect:/chooseMoves";
		}
	}
}
