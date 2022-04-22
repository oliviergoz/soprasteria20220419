package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entity.Ordinateur;
import formationJpa.util.Context;

public class DaoOrdinateurJpaImplementation implements DaoOrdinateur {

	@Override
	public Ordinateur findById(String id) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Ordinateur p = em.find(Ordinateur.class, id);
		em.close();
		return p;
	}

	@Override
	public List<Ordinateur> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Ordinateur> query = em.createQuery("select p from Ordinateur p", Ordinateur.class);
		List<Ordinateur> ordinateurs = query.getResultList();
		em.close();
		return ordinateurs;
	}

	@Override
	public void insert(Ordinateur obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Ordinateur update(Ordinateur obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void deleteById(String id) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Ordinateur.class, id));
		tx.commit();
		em.close();
	}

	@Override
	public void delete(Ordinateur obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();

	}

}
