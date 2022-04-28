package pokemon.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import pokemon.entity.Arene;
import pokemon.entity.Dresseur;

public interface AreneRepository extends JpaRepository<Arene, Long> {
	@Query("select a from Arene a left join fetch a.sbires left join fetch a.maitre where a.id=:id")
	Optional<Arene> findByIdWithMaitreAndSbires(@Param("id") Long id);

	@Modifying
	@Transactional
	@Query("update Arene a set a.maitre=null where a.maitre=:maitre")
	void deleteByMaitre(@Param("maitre") Dresseur maitre);

	@Query("select a from Arene a left join fetch a.sbires s where s=:sbire")
	List<Arene> findAllContainingSbire(@Param("sbire") Dresseur sbire);

	// nativeQuery pour utiliser requete SQL pure
	@Modifying
	@Transactional
	@Query(value = "delete from sbires s where s.sbire_id=:id", nativeQuery = true)
	void deleteSbireBySbireId(@Param("id") Integer id);
}
