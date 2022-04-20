package formationJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersistenceTest {
	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("formation");
		
		Personne olivier=new Personne();
		olivier.setId(1L);
		olivier.setPrenom("olivier");
		olivier.setNom("gozlan");
		
		EntityManager em=emf.createEntityManager();
		//crud
		//insert,update,delete,select key
		
		
		//pour toute les modifications => transtaction
		//insert
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(olivier);
		tx.commit();
		
		emf.close();
	}
}
