package formationJpaSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import formationJpaSpring.entity.Formateur;
import formationJpaSpring.entity.Formation;

@Repository
public class DaoFormationJpaImplementation implements DaoFormation {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Formation findById(Long id) {
		return em.find(Formation.class, id);
	}

	public List<Formation> findByNom(String nom) {
		TypedQuery<Formation> query = em.createQuery("select f from Formation f where f.nom=:nomParametre",
				Formation.class);
		query.setParameter("nomParametre", nom);
		List<Formation> formations = query.getResultList();
		return formations;
	}

	public List<Formation> findByReferent(Formateur referent) {
		TypedQuery<Formation> query = em.createQuery("select f from Formation f where f.referent=:referent",
				Formation.class);
		query.setParameter("referent", referent);
		List<Formation> formations = query.getResultList();
		return formations;
	}

	public Formation findByIdWithParticipants(Long id) {
		TypedQuery<Formation> query = em.createQuery("select f from Formation f " + " left join fetch f.participants"
				+ " left join fetch f.referent" + " where f.id=:id", Formation.class);
		query.setParameter("id", id);
		Formation formations = query.getSingleResult();
		return formations;
	}

	public Formation findByIdWithModules(Long id) {
		TypedQuery<Formation> query = em.createQuery("select f from Formation f "
				+ " left join fetch f.modulesFormations" + " left join fetch f.referent" + " where f.id=:id",
				Formation.class);
		query.setParameter("id", id);
		Formation formations = query.getSingleResult();
		return formations;
	}

	public Formation findByIdWithModulesAndParticipants(Long id) {
		TypedQuery<Formation> query = em.createQuery(
				"select f from Formation f " + " left join fetch f.modulesFormations"
						+ " left join fetch f.participants" + " left join fetch f.referent" + " where f.id=:id",
				Formation.class);
		query.setParameter("id", id);
		Formation formations = query.getSingleResult();
		return formations;
	}

	@Override
	public List<Formation> findAll() {
		TypedQuery<Formation> query = em.createQuery("select p from Formation p", Formation.class);
		List<Formation> formations = query.getResultList();
		return formations;
	}

	@Override
	@Transactional
	public void insert(Formation obj) {
		em.persist(obj);
	}

	@Override
	@Transactional
	public Formation update(Formation obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		em.remove(em.find(Formation.class, id));
	}

	@Override
	@Transactional
	public void delete(Formation obj) {
		em.remove(em.merge(obj));
	}

}
