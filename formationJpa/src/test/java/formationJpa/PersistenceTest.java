package formationJpa;

import formationJpa.dao.DaoPersonne;
import formationJpa.entity.Adresse;
import formationJpa.entity.Civilite;
import formationJpa.entity.Formateur;
import formationJpa.entity.Personne;
import formationJpa.entity.Stagiaire;
import formationJpa.util.Context;

public class PersistenceTest {
	public static void main(String[] args) {
		DaoPersonne daoPersonne = Context.getDaoPersonne();

		Personne olivier = new Formateur();
		olivier.setPrenom("olivier");
		olivier.setCivilite(Civilite.M);
		olivier.setAdresse(new Adresse("1", "rue du soleil", "11111", "ma ville"));
		System.out.println(olivier.getId());
		daoPersonne.insert(olivier);

		System.out.println(olivier.getId());
		// System.out.println(daoPersonne.findById(olivier.getId()).getClass());
		Stagiaire s=new Stagiaire();
		s.setPrenom("ooo");
		daoPersonne.insert(s);
		System.out.println(s.getId());
		// en dernier
		Context.destroyEntityManagerFactory();
	}
}
