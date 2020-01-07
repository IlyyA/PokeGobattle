package ca.pokebattle.controller;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PokeGoBattleController {
	
	//Returns homepage
	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		return "index";
	}
	


}
