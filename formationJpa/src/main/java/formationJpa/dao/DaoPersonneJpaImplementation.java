package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import formationJpa.entity.Personne;
import formationJpa.util.Context;

public class DaoPersonneJpaImplementation implements DaoPersonne{

	@Override
	public Personne findById(Long id) {
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		Personne p=em.find(Personne.class, id);
		em.close();
		return p;
	}

	@Override
	public List<Personne> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Personne obj) {
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Personne update(Personne obj) {
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		obj=em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void deleteById(Long id) {
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.remove(em.find(Personne.class, id));
		tx.commit();
		em.close();
	}

	@Override
	public void delete(Personne obj) {
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
		
	}

}
