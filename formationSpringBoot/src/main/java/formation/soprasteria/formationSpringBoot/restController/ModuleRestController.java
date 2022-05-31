package formation.soprasteria.formationSpringBoot.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	
	@GetMapping("")
	@JsonView(JsonViews.ModuleWithMatiere.class)
	public List<Module> getAll(){
		return moduleService.getAll();
	}

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
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		moduleService.deleteById(id);
	}
	
	@PostMapping("")
	public Module create (@Valid @RequestBody Module module,BindingResult br) {
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return moduleService.create(module);
	}
	
	@PutMapping("/{id}")
	public Module update(@Valid @RequestBody Module module,BindingResult br,@PathVariable Long id) {
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return moduleService.update(module);
	}
}
