package pokemon.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pokemon.dao.DaoArene;
import pokemon.dao.DaoAreneJpaImpl;
import pokemon.dao.DaoDresseur;
import pokemon.dao.DaoDresseurJpaImpl;
import pokemon.dao.DaoInfirmiere;
import pokemon.dao.DaoInfirmiereJpaImpl;
import pokemon.dao.DaoItem;
import pokemon.dao.DaoItemJpaImpl;

public class Context {

	private static EntityManagerFactory emf = null;

	private static DaoArene daoArene = new DaoAreneJpaImpl();
	private static DaoDresseur daoDresseur = new DaoDresseurJpaImpl();
	private static DaoInfirmiere daoInfirmire = new DaoInfirmiereJpaImpl();
	private static DaoItem daoItem = new DaoItemJpaImpl();

	public static DaoItem getDaoItem() {
		return daoItem;
	}

	public static DaoInfirmiere getDaoInfirmire() {
		return daoInfirmire;
	}

	public static DaoDresseur getDaoDresseur() {
		return daoDresseur;
	}

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
