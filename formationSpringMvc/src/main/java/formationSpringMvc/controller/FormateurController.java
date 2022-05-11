package formationSpringMvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import quest.entity.Formateur;
import quest.services.CompteService;

@Controller
@RequestMapping("/formateur")
public class FormateurController {

	@Autowired
	private CompteService compteService;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("formateurs", compteService.getAllFormateurs());
		return "formateur/list";
	}

	@GetMapping("/edit")
	public String edit(Long id, Model model) {
		return goForm((Formateur) compteService.getById(id), model);
	}

	@GetMapping("add")
	public String add(Model model) {
		return goForm(new Formateur(), model);
	}

	private String goForm(Formateur formateur, Model model) {
		model.addAttribute("formateur", formateur);
		return "formateur/edit";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute Formateur formateur, BindingResult br, Model model) {
		if (br.hasErrors()) {
			if (!(br.getErrorCount() == 1 && br.getFieldError("password") != null && formateur.getId() != null)) {
				return goForm(formateur, model);
			}
		}
		if (formateur.getId() != null) {
			compteService.update(formateur);
		} else {
			compteService.create(formateur);
		}
		return "redirect:/formateur";
	}
}
