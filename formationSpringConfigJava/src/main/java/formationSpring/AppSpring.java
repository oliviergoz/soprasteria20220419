package formationSpring;

import org.springframework.beans.factory.annotation.Autowired;

import formationSpring.beans.IPersonne;

public class AppSpring {

	@Autowired
	private IPersonne personne;

	public void run(String... args) {
		try {
			System.out.println(personne.methodePourAspect());
		} catch (Exception e) {
			System.out.println("attention erreur");
		}
	}
}
