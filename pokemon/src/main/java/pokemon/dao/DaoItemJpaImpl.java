package pokemon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import pokemon.entity.Item;
import pokemon.util.Context;

public class DaoItemJpaImpl implements DaoItem {

	@Override
	public Item findById(Integer id) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Item item = em.find(Item.class, id);
		em.close();
		return item;
	}

	@Override
	public List<Item> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Item> query = em.createQuery("select p from Item p", Item.class);
		List<Item> items = query.getResultList();
		em.close();
		return items;
	}

	@Override
	public void insert(Item obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Item update(Item obj) {
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
		em.remove(em.find(Item.class, id));
		tx.commit();
		em.close();
	}

	@Override
	public void delete(Item obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

}
