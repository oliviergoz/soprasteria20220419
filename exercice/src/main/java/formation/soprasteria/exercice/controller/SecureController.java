package formation.soprasteria.exercice.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import formation.soprasteria.exercice.entities.User;

@Controller
@RequestMapping("/secure")
public class SecureController {

	@GetMapping("/home")
	public String home(Model model,@AuthenticationPrincipal User user) {
		model.addAttribute("user", user);
		return "secure/home";
	}
}
