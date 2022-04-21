package pokemon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import pokemon.entity.Dresseur;
import pokemon.util.Context;

public class DaoDresseurJpaImpl implements DaoDresseur {

	@Override
	public Dresseur findById(Integer id) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Dresseur dresseur = em.find(Dresseur.class, id);
		em.close();
		return dresseur;
	}

	@Override
	public List<Dresseur> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Dresseur> query = em.createQuery("select p from Dresseur p", Dresseur.class);
		List<Dresseur> dresseurs = query.getResultList();
		em.close();
		return dresseurs;
	}

	@Override
	public void insert(Dresseur obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Dresseur update(Dresseur obj) {
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
		em.remove(em.find(Dresseur.class, id));
		tx.commit();
		em.close();
	}

	@Override
	public void delete(Dresseur obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

}
