package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entity.Formateur;
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

	public List<Formation> findByNom(String nom) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Formation> query = em.createQuery("select f from Formation f where f.nom=:nomParametre",
				Formation.class);
		query.setParameter("nomParametre", nom);
		List<Formation> formations = query.getResultList();
		em.close();
		return formations;
	}

	public List<Formation> findByReferent(Formateur referent) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Formation> query = em.createQuery("select f from Formation f where f.referent=:referent",
				Formation.class);
		query.setParameter("referent", referent);
		List<Formation> formations = query.getResultList();
		em.close();
		return formations;
	}

	public Formation findByIdWithParticipants(Long id) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Formation> query = em
				.createQuery("select f from Formation f "
						+ " left join fetch f.participants"
						+ " left join fetch f.referent"
						+ " where f.id=:id", Formation.class);
		query.setParameter("id", id);
		Formation formations = query.getSingleResult();
		em.close();
		return formations;
	}
	
	public Formation findByIdWithModules(Long id) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Formation> query = em
				.createQuery("select f from Formation f "
						+ " left join fetch f.modulesFormations"
						+ " left join fetch f.referent"
						+ " where f.id=:id", Formation.class);
		query.setParameter("id", id);
		Formation formations = query.getSingleResult();
		em.close();
		return formations;
	}
	
	public Formation findByIdWithModulesAndParticipants(Long id) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Formation> query = em
				.createQuery("select f from Formation f "
						+ " left join fetch f.modulesFormations"
						+ " left join fetch f.participants"
						+ " left join fetch f.referent"
						+ " where f.id=:id", Formation.class);
		query.setParameter("id", id);
		Formation formations = query.getSingleResult();
		em.close();
		return formations;
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
