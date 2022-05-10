package formationSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/demo")
public class HelloController {

	//@METHODMapping
	//@GetMapping
	//@PostMapping
	//@PutMapping
	//@RequestMapping(path = "",method = RequestMethod.GET)
	@GetMapping("")
	public String hello(@RequestParam String prenom,Model model) {
		model.addAttribute("prenom", prenom);
		return "hello";
	}

	@GetMapping("/bye")
	public String bye() {
		return "bye";
	}
}
