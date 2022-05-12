package formationSpringMvc.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import quest.entity.JsonViews;
import quest.entity.Module;
import quest.services.ModuleService;

@RestController
@RequestMapping("/api/module")
public class ModuleRestController {

	@Autowired
	private ModuleService moduleService;

	@GetMapping("/{id}")
	@JsonView(JsonViews.ModuleWithMatiere.class)
	public Module getByIdWithMatiere(@PathVariable Long id) {
		return getById(id);
	}

	@GetMapping("/{id}/formateur")
	@JsonView(JsonViews.ModuleWithFormateur.class)
	public Module getByIdWithMatiereAndFormateur(@PathVariable Long id) {
		return getById(id);
	}

	public Module getById(Long id) {
		return moduleService.getById(id);
	}
}
