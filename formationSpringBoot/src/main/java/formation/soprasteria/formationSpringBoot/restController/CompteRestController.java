package formation.soprasteria.formationSpringBoot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.soprasteria.formationSpringBoot.entity.Compte;
import formation.soprasteria.formationSpringBoot.entity.JsonViews;
import formation.soprasteria.formationSpringBoot.services.CompteService;

@RestController
@RequestMapping("/api/compte")
@CrossOrigin(origins = "*")
public class CompteRestController {

	@Autowired
	private CompteService compteService;

	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Compte> getAll() {
		return compteService.getAll();
	}

	@JsonView(JsonViews.Common.class)
	@PreAuthorize("isAnonymous()")
	@PostMapping("/inscription")
	public Compte create(@RequestBody Compte compte) {
		return compteService.create(compte);
	}

}
