package formationJpaSpring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import formationJpaSpring.entity.Formateur;
import formationJpaSpring.entity.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long> {

	// definir une methode avec un nommage precis
	// findByAttribut(typeAttribut attribut);
	List<Formation> findByNom(String nom);

	List<Formation> findByNomContaining(String nom);

	List<Formation> findByReferent(Formateur referent);

	@Query("select f from Formation f left join fetch f.participants left join fetch f.referent where f.id=:id")
	Optional<Formation> findByIdWithParticipants(@Param("id") Long id);

	@Query("select f from Formation f left join fetch f.modulesFormations left join fetch f.referent where f.id=:id")
	Optional<Formation> findByIdWithModulesFormations(@Param("id") Long id);

	@Query("select f from Formation f left join fetch f.participants left join fetch f.modulesFormations left join fetch f.referent where f.id=:id")
	Optional<Formation> findByIdWithParticipantsAndModulesFormations(@Param("id") Long id);

	@Modifying
	@Transactional
	@Query("update Formation f set f.referent=null where f.referent=:referent")
	void setReferentToNull(@Param("referent") Formateur referent);

	@Modifying
	@Transactional
	@Query("delete from Formation f where f.referent=:referent")
	void deleteByReferent(@Param("referent") Formateur referent);
}
