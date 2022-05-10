package formationSpringMvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import quest.services.MatiereService;

@Controller
@RequestMapping("/matiere")
public class MatiereController {

	@Autowired
	private MatiereService matiereService;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("matieres", matiereService.getAll());
		return "matiere/list";
	}
}
