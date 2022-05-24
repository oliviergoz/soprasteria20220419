package formation.soprasteria.formationSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

	@GetMapping("/formlogin")
	public String login() {
		return "login";
	}

	@GetMapping("/secure/home")
	public String home() {
		return "secure/home";
	}
}
