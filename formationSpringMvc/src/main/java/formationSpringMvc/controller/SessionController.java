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
import quest.services.ModuleService;
import quest.services.SessionService;

@Controller
@RequestMapping("/session")
public class SessionController {

	@Autowired
	private SessionService sessionService;
	@Autowired
	private ModuleService moduleService;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("sessions", sessionService.getAll());
		return "session/list";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Long id, Model model) {
		return goForm(sessionService.getById(id), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goForm(new Session(), model);
	}

	private String goForm(Session session, Model model) {
		model.addAttribute("session", session);
		// model.addAttribute("matieres", matiereService.getAll());
		// model.addAttribute("formateurs", compteService.getAllFormateurs());
		return "session/edit";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Session session, Model model) {
//			if (module.getFormateur().getId() == null) {
//				module.setFormateur(null);
//			}

		if (session.getId() != null) {
			sessionService.update(session);
		} else {
			sessionService.create(session);
		}
		return "redirect:/session";
	}



	@GetMapping("/gestionStagiaire")
	public String gestionStagaire(@ModelAttribute Session session, Model model) {
		return "stagiaire/list";
	}

}
