package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entity.Formation;
import formationJpa.util.Context;

public class DaoFormationJpaImplementation implements DaoFormation {

	@Override
	public Formation findById(Long id) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Formation p = em.find(Formation.class, id);
		em.close();
		return p;
	}

	@Override
	public List<Formation> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Formation> query = em.createQuery("select p from Formation p", Formation.class);
		List<Formation> formations = query.getResultList();
		em.close();
		return formations;
	}

	@Override
	public void insert(Formation obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Formation update(Formation obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void deleteById(Long id) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Formation.class, id));
		tx.commit();
		em.close();
	}

	@Override
	public void delete(Formation obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();

	}

}
