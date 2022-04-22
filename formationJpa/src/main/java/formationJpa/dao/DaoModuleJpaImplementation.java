package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entity.Module;
import formationJpa.util.Context;

public class DaoModuleJpaImplementation implements DaoModule {

	@Override
	public Module findById(Long id) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Module p = em.find(Module.class, id);
		em.close();
		return p;
	}

	@Override
	public List<Module> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Module> query = em.createQuery("select p from Module p", Module.class);
		List<Module> modules = query.getResultList();
		em.close();
		return modules;
	}

	@Override
	public void insert(Module obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Module update(Module obj) {
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
		em.remove(em.find(Module.class, id));
		tx.commit();
		em.close();
	}

	@Override
	public void delete(Module obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();

	}

}
