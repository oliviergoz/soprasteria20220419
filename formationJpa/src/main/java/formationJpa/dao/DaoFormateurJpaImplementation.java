package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entity.Formateur;
import formationJpa.util.Context;

public class DaoFormateurJpaImplementation implements DaoFormateur {

	@Override
	public Formateur findById(Long id) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Formateur p = em.find(Formateur.class, id);
		em.close();
		return p;
	}

	@Override
	public List<Formateur> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Formateur> query = em.createQuery("select p from Formateur p", Formateur.class);
		List<Formateur> formateurs = query.getResultList();
		em.close();
		return formateurs;
	}

	@Override
	public void insert(Formateur obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Formateur update(Formateur obj) {
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
		em.remove(em.find(Formateur.class, id));
		tx.commit();
		em.close();
	}

	@Override
	public void delete(Formateur obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();

	}

}
