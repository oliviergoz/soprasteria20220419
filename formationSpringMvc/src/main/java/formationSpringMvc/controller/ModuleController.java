package formationSpringMvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import quest.entity.Module;
import quest.services.CompteService;
import quest.services.MatiereService;
import quest.services.ModuleService;

@Controller
@RequestMapping("/module")
public class ModuleController {

	@Autowired
	private ModuleService moduleService;
	@Autowired
	private MatiereService matiereService;
	@Autowired
	private CompteService compteService;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("modules", moduleService.getAll());
		return "module/list";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Long id, Model model) {
		return goForm(moduleService.getById(id), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goForm(new Module(), model);
	}

	private String goForm(Module module, Model model) {
		model.addAttribute("module", module);
		model.addAttribute("matieres", matiereService.getAll());
		model.addAttribute("formateurs", compteService.getAllFormateurs());
		return "module/edit";
	}

	@GetMapping("/save")
	public String save(@ModelAttribute Module module, Model model) {
		if (module.getFormateur().getId() == null) {
			module.setFormateur(null);
		}

		if (module.getId() != null) {
			moduleService.update(module);
		} else {
			moduleService.create(module);
		}
		return "redirect:/module";
	}
}
