package formationSpringMvc.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import formationSpringMvc.model.Adresse;
import formationSpringMvc.model.Personne;

@RestController
public class DemoRestController {

	@GetMapping("/api/hello")
	public String sayHello() {
		return "hello world";
	}

	@GetMapping("/api/hello/olivier")
	public Personne getOlivier() {
		Personne olivier = new Personne();
		olivier.setNom("gozlan");
		olivier.setPrenom("olivier");
		Adresse adresse = new Adresse();
		adresse.setRue("chez olivier");
		olivier.setAdresse(adresse);
		return olivier;
	}

	@PostMapping("/api/hello")
	public Personne recuperationPersonneDepuisWebService(@RequestBody Personne personne) {
		System.out.println(personne.getPrenom());
		System.out.println(personne.getNom());
		return personne;
	}
}
