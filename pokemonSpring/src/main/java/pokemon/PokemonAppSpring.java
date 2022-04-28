package pokemon;

import org.springframework.beans.factory.annotation.Autowired;

import pokemon.entity.Arene;
import pokemon.entity.Dresseur;
import pokemon.services.AreneService;
import pokemon.services.DresseurService;

public class PokemonAppSpring {

	@Autowired
	private DresseurService dresseurService;

	@Autowired
	private AreneService areneService;

	public void run(String... args) {
		Dresseur m1 = new Dresseur();
		m1.setNom("maitre1");

		dresseurService.create(m1);

		Dresseur s1 = new Dresseur();
		s1.setNom("sbire1");
		Dresseur s2 = new Dresseur();
		s2.setNom("sbire2");

		dresseurService.create(s2);
		dresseurService.create(s1);

		Arene arene = new Arene();

		arene.setNom("arene");
		arene.setMaitre(m1);

		areneService.create(arene);
		areneService.addSbire(arene, s2);
		areneService.addSbire(arene, s1);

		arene = areneService.getByIdDetails(arene.getId());

		System.out.println(arene.getMaitre());
		System.err.println(arene.getSbires());

		// areneService.delete(arene);

		dresseurService.delete(m1);
		
		dresseurService.delete(s2);

	}
}
