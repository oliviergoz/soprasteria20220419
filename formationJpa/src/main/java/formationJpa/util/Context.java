package formationJpa.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import formationJpa.dao.DaoFormateur;
import formationJpa.dao.DaoFormateurJpaImplementation;
import formationJpa.dao.DaoOrdinateur;
import formationJpa.dao.DaoOrdinateurJpaImplementation;
import formationJpa.dao.DaoPersonne;
import formationJpa.dao.DaoPersonneJpaImplementation;
import formationJpa.dao.DaoStagiaire;
import formationJpa.dao.DaoStagiaireJpaImplementation;

public class Context {

	private static EntityManagerFactory emf = null;

	private static DaoPersonne daoPersonne = new DaoPersonneJpaImplementation();
	private static DaoOrdinateur daoOrdinateur = new DaoOrdinateurJpaImplementation();
	private static DaoFormateur daoFormateur = new DaoFormateurJpaImplementation();
	private static DaoStagiaire daoStagiaire = new DaoStagiaireJpaImplementation();

	public static DaoStagiaire getDaoStagiaire() {
		return daoStagiaire;
	}

	public static DaoFormateur getDaoFormateur() {
		return daoFormateur;
	}

	public static DaoOrdinateur getDaoOrdinateur() {
		return daoOrdinateur;
	}

	public static DaoPersonne getDaoPersonne() {
		return daoPersonne;
	}

	private Context() {

	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("formation");
		}
		return emf;
	}

	public static void destroyEntityManagerFactory() {
		if (emf != null) {
			emf.close();
			emf = null;
		}
	}
}
