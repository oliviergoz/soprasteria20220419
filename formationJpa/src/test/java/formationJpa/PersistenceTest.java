package formationJpa;

import formationJpa.dao.DaoPersonne;
import formationJpa.entity.Personne;
import formationJpa.util.Context;

public class PersistenceTest {
	public static void main(String[] args) {
		DaoPersonne daoPersonne=Context.getDaoPersonne();
		
		Personne olivier=new Personne();
		olivier.setId(1L);
		daoPersonne.insert(olivier);
		olivier.setPrenom("olivier");
		daoPersonne.update(olivier);
		
		System.out.println(daoPersonne.findById(1L));
		System.out.println(daoPersonne.findById(10L));
		
		daoPersonne.delete(olivier);
		
		//en dernier
		Context.destroyEntityManagerFactory();
	}
}
