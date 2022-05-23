package formation.soprasteria.formationSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formation.soprasteria.formationSpringBoot.entity.Compte;
import formation.soprasteria.formationSpringBoot.entity.Matiere;
import formation.soprasteria.formationSpringBoot.services.MatiereService;

@Controller
@RequestMapping("/matiere")
public class MatiereController {

	@Autowired
	private MatiereService matiereService;

	@GetMapping("")
	public String list(Model model, @AuthenticationPrincipal Compte compte) {
		model.addAttribute("matieres", matiereService.getAll());
		return "matiere/list";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Long id, Model model) {
		return goEdit(matiereService.getById(id), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Matiere(), model);
	}

	private String goEdit(Matiere matiere, Model model) {
		model.addAttribute("matiere", matiere);
		return "matiere/edit";
	}

	@PostMapping("")
	public String save(@ModelAttribute Matiere matiere) {
		if (matiere.getId() == null) {
			matiereService.create(matiere);
		} else {
			matiereService.update(matiere);
		}
		return "redirect:/matiere";
	}
}
