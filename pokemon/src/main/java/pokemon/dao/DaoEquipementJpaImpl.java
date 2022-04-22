package pokemon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import pokemon.entity.Equipement;
import pokemon.entity.EquipementKey;
import pokemon.entity.Personne;
import pokemon.util.Context;

public class DaoEquipementJpaImpl implements DaoEquipement {

	@Override
	public Equipement findById(EquipementKey id) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Equipement equipement = em.find(Equipement.class, id);
		em.close();
		return equipement;
	}

	@Override
	public List<Equipement> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Equipement> query = em.createQuery("select a from Equipement a", Equipement.class);
		List<Equipement> equipements = query.getResultList();
		em.close();
		return equipements;
	}

	@Override
	public void insert(Equipement obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Equipement update(Equipement obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void deleteById(EquipementKey id) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Equipement.class, id));
		tx.commit();
		em.close();
	}

	@Override
	public void delete(Equipement obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

}
