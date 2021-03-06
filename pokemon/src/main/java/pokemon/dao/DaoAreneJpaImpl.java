package pokemon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import pokemon.entity.Arene;
import pokemon.entity.Personne;
import pokemon.util.Context;

public class DaoAreneJpaImpl implements DaoArene {

	@Override
	public Arene findById(Long id) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Arene arene = em.find(Arene.class, id);
		em.close();
		return arene;
	}

	@Override
	public List<Arene> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Arene> query = em.createQuery("select a from Arene a", Arene.class);
		List<Arene> arenes = query.getResultList();
		em.close();
		return arenes;
	}

	@Override
	public void insert(Arene obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Arene update(Arene obj) {
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
		em.remove(em.find(Arene.class, id));
		tx.commit();
		em.close();
	}

	@Override
	public void delete(Arene obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

}
