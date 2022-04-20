package formationJpa.dao;

import java.util.List;

public interface DaoGeneric<T,K> {
	T findById(K id);
	List<T> findAll();
	void insert(T obj);
	T update(T obj);
	void deleteById(K id);
	void delete(T obj);
}
