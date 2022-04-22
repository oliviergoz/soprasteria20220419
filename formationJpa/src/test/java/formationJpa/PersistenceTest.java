package formationJpa;

import formationJpa.dao.DaoOrdinateur;
import formationJpa.dao.DaoPersonne;
import formationJpa.dao.DaoStagiaire;
import formationJpa.entity.Adresse;
import formationJpa.entity.Civilite;
import formationJpa.entity.Formateur;
import formationJpa.entity.Ordinateur;
import formationJpa.entity.Personne;
import formationJpa.entity.Stagiaire;
import formationJpa.util.Context;

public class PersistenceTest {
	public static void main(String[] args) {

		Ordinateur o = new Ordinateur("A1", "un beau pc");

		DaoOrdinateur daoOrdinateur = Context.getDaoOrdinateur();
		daoOrdinateur.insert(o);

		Stagiaire s = new Stagiaire("olivier", "gozlan");

		Ordinateur partialPc = new Ordinateur();
		partialPc.setSerie("A1");

		s.setOrdinateur(partialPc);
		DaoStagiaire daoStagiaire = Context.getDaoStagiaire();

		daoStagiaire.insert(s);

		Ordinateur ordiDeLaBase = daoOrdinateur.findById("A1");
		System.out.println(ordiDeLaBase.getStagiaire());

		// en dernier
		Context.destroyEntityManagerFactory();
	}
}
