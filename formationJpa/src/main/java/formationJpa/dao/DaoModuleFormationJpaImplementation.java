package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entity.ModuleFormation;
import formationJpa.entity.ModuleFormationId;
import formationJpa.entity.Ordinateur;
import formationJpa.util.Context;

public class DaoModuleFormationJpaImplementation implements DaoModuleFormation {

	@Override
	public ModuleFormation findById(ModuleFormationId id) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		ModuleFormation p = em.find(ModuleFormation.class, id);
		em.close();
		return p;
	}

	@Override
	public List<ModuleFormation> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<ModuleFormation> query = em.createQuery("select p from ModuleFormation p", ModuleFormation.class);
		List<ModuleFormation> moduleFormation = query.getResultList();
		em.close();
		return moduleFormation;
	}

	@Override
	public void insert(ModuleFormation obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public ModuleFormation update(ModuleFormation obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void deleteById(ModuleFormationId id) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(ModuleFormation.class, id));
		tx.commit();
		em.close();
	}

	@Override
	public void delete(ModuleFormation obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();

	}

}
