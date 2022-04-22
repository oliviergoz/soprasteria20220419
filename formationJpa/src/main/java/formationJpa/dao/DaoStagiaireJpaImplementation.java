package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entity.Stagiaire;
import formationJpa.util.Context;

public class DaoStagiaireJpaImplementation implements DaoStagiaire {

	@Override
	public Stagiaire findById(Long id) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Stagiaire p = em.find(Stagiaire.class, id);
		em.close();
		return p;
	}

	@Override
	public List<Stagiaire> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Stagiaire> query = em.createQuery("select p from Stagiaire p", Stagiaire.class);
		List<Stagiaire> stagiaires = query.getResultList();
		em.close();
		return stagiaires;
	}

	@Override
	public void insert(Stagiaire obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Stagiaire update(Stagiaire obj) {
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
		em.remove(em.find(Stagiaire.class, id));
		tx.commit();
		em.close();
	}

	@Override
	public void delete(Stagiaire obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();

	}

}
