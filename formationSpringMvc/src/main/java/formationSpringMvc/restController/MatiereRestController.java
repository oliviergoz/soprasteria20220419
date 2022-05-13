package formationSpringMvc.restController;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import quest.entity.Matiere;
import quest.services.MatiereService;

@RestController
@RequestMapping("/api/matiere")
public class MatiereRestController {

	@Autowired
	private MatiereService matiereService;

	@GetMapping("")
	public List<Matiere> getAll() {
		return matiereService.getAll();
	}

	@GetMapping("/{id}")
	public Matiere getById(@PathVariable Long id) {
		return matiereService.getById(id);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Matiere create(@Valid @RequestBody Matiere matiere, BindingResult br) {
		return matiereService.create(matiere);
	}

	// update

	// replacement
	@PutMapping("/{id}")
	public Matiere update(@RequestBody Matiere matiere, @PathVariable Long id) {
		matiere.setId(id);
		return matiereService.update(matiere);
	}

	// mise à jour partiel
	@PatchMapping("/{id}")
	public Matiere partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
		Matiere matiere = matiereService.getById(id);
		// matiere.setLibelle(fields.get("libelle").toString());

		fields.forEach((k, v) -> {
			if (k.equals("attributQuiPoseProbleme")) {
				;
			}else {
				Field field = ReflectionUtils.findField(Matiere.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, matiere, v);
			}
		});

		return matiereService.update(matiere);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Matiere matiere = matiereService.getById(id);
		matiereService.delete(matiere);
	}
}
