package formation.soprasteria.exercice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import formation.soprasteria.exercice.entities.User;
import formation.soprasteria.exercice.repository.UserRepository;

@Controller
public class PublicController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping({ "", "/home" })
	public String home() {
		return "public/home";
	}

	@GetMapping("/inscription")
	public String inscription(Model model) {
		return formInscription(model, new User());
	}

	private String formInscription(Model model, User user) {
		model.addAttribute("user", user);
		return "public/inscription";
	}

	@PostMapping("/inscription")
	public String save(@Valid @ModelAttribute User user, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return formInscription(model, user);
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepo.save(user);
		return "public/home";
	}
}
