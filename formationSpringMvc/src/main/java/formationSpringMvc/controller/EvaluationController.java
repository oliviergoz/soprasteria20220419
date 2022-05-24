package formationSpringMvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import quest.entity.Evaluation;
import quest.services.CompteService;
import quest.services.EvaluationService;
import quest.services.ModuleService;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {

	@Autowired
	CompteService compteService;
	
	@Autowired
	ModuleService moduleService;
		
	@Autowired
	EvaluationService evaluationService;
	
	
	
	@GetMapping("")
	public String Eval(Model model) {	
		model.addAttribute("evaluation", new Evaluation());
		model.addAttribute("stagiaires", compteService.getAllStagiaires());
		model.addAttribute("modules", moduleService.getAll());
		return "evaluation/formEvaluation";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Evaluation evaluation,Model model){
			
		
		if (evaluation.getId() != null) {
			evaluationService.update(evaluation);
		} else {
			evaluationService.create(evaluation);
		}
		
		return "redirect:/evaluation";
	}
	
	
	
	
}
