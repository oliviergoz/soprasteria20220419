package pokemon.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pokemon.dao.DaoArene;
import pokemon.dao.DaoAreneJpaImpl;

public class Context {

	private static EntityManagerFactory emf = null;

	private static DaoArene daoArene = new DaoAreneJpaImpl();

	public static DaoArene getDaoArene() {
		return daoArene;
	}

	private Context() {

	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("pokemon");
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
