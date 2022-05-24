package formation.soprasteria.formationSpringBoot.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import formation.soprasteria.formationSpringBoot.entity.Module;

import com.fasterxml.jackson.annotation.JsonView;

import formation.soprasteria.formationSpringBoot.entity.JsonViews;
import formation.soprasteria.formationSpringBoot.services.ModuleService;

@RestController
@RequestMapping("/api/module")
@CrossOrigin(origins = "*")
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
