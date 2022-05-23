package formation.soprasteria.formationSpringBoot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.soprasteria.formationSpringBoot.entity.Session;

public interface SessionRepository extends JpaRepository<Session, Long>{
	
	@Query("Select s from Session s left join fetch s.stagiaires left join fetch s.modules where s.id =:id")
	Optional<Session> findSessionByIdWithDetails(@Param("id") Long id);
}
