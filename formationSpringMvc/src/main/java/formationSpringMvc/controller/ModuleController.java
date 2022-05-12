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
import quest.entity.Session;
import quest.services.CompteService;
import quest.services.MatiereService;
import quest.services.ModuleService;
import quest.services.SessionService;

@Controller
@RequestMapping("/module")
public class ModuleController {

	@Autowired
	private ModuleService moduleService;
	@Autowired
	private MatiereService matiereService;
	@Autowired
	private CompteService compteService;
	@Autowired
	private SessionService sessionService;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("modules", moduleService.getAll());
		return "module/list";
	}

	@GetMapping("/modulesSession")
	public String listsession(Long id, Model model) {
		model.addAttribute("session", sessionService.getById(id));
		model.addAttribute("modules", moduleService.getAllBySession(id));
		
		return "module/list";
	}
	
	
	@GetMapping("/suprimer")
	public String delete(@RequestParam Long id,Model model){
		Module module = moduleService.getById(id);
		Long idSession = module.getSession().getId();
		moduleService.deleteById(id);
		return "redirect:/module/modulesSession?id="+idSession;
	}
	
	
	@GetMapping("/edit")
	public String edit(@RequestParam Long id, Model model) {
		Module moduleMaj = moduleService.getById(id);
		Long idSession = moduleMaj.getSession().getId();
		return goForm(idSession,moduleMaj, model);
	}

	@GetMapping("/add")
	public String add(Long id, Model model) {
		return goForm(id,new Module(), model);
	}

	private String goForm(Long id,Module module, Model model) {
		module.setSession(sessionService.getById(id));
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

		if (module.getSession().getId() == null) {
			module.setSession(null);
		}
		
		
		if (module.getId() != null) {
			moduleService.update(module);
		} else {
			moduleService.create(module);
		}
		return "redirect:/module/modulesSession?id="+ module.getSession().getId();
	}
}
