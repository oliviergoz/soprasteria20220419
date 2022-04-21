package formationJpa;

import formationJpa.dao.DaoPersonne;
import formationJpa.entity.Adresse;
import formationJpa.entity.Civilite;
import formationJpa.entity.Personne;
import formationJpa.util.Context;

public class PersistenceTest {
	public static void main(String[] args) {
		DaoPersonne daoPersonne = Context.getDaoPersonne();

		Personne olivier = new Personne();
		olivier.setId(1L);
		olivier.setPrenom("olivier");
		olivier.setCivilite(Civilite.M);
		olivier.setAdresse(new Adresse("1","rue du soleil","11111","ma ville"));
		daoPersonne.insert(olivier);

		Personne recherche = daoPersonne.findById(1L);
		System.out.println(olivier == recherche);
		System.out.println(olivier.equals(recherche));
		System.out.println(recherche.getAdresse());
		// en dernier
		Context.destroyEntityManagerFactory();
	}
}
