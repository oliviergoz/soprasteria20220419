package pokemon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import pokemon.entity.Infirmiere;
import pokemon.util.Context;

public class DaoInfirmiereJpaImpl implements DaoInfirmiere {

	@Override
	public Infirmiere findById(Integer id) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Infirmiere infirmiere = em.find(Infirmiere.class, id);
		em.close();
		return infirmiere;
	}

	@Override
	public List<Infirmiere> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Infirmiere> query = em.createQuery("select p from Infirmiere p", Infirmiere.class);
		List<Infirmiere> infirmieres = query.getResultList();
		em.close();
		return infirmieres;
	}

	@Override
	public void insert(Infirmiere obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Infirmiere update(Infirmiere obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Infirmiere.class, id));
		tx.commit();
		em.close();
	}

	@Override
	public void delete(Infirmiere obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

}
