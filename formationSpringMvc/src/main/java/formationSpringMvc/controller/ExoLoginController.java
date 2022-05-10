package formationSpringMvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/exo/login")
public class ExoLoginController {

	@GetMapping("")
	public String goLoginForm() {
		return "exo/login";
	}

	@PostMapping("")
	public String checkLogin(@RequestParam(name = "login", required = false) String login,
			@RequestParam(name = "password", required = false) String password, Model model, HttpSession session) {
		boolean error = false;
		if (password == null || password.isEmpty() || login == null || login.isEmpty()) {
			error = true;
		} else if (!password.equals("toto") || !login.equals("toto")) {
			error = true;
		}
		if (error) {
			model.addAttribute("erreur", "informations incorrecres");
			return "exo/login";
		}
		model.addAttribute("prenom", login);
		session.setAttribute("login", login);
		return "hello";
	}
}
