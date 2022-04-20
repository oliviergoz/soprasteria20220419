package formationJpa.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import formationJpa.dao.DaoPersonne;
import formationJpa.dao.DaoPersonneJpaImplementation;

public class Context {

	private static EntityManagerFactory emf = null;

	private static DaoPersonne daoPersonne = new DaoPersonneJpaImplementation();

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
		if(emf!=null) {
			emf.close();
			emf=null;
		}
	}
}
