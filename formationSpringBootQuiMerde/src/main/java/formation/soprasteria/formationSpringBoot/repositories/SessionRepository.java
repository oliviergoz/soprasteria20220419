package formation.soprasteria.formationSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.soprasteria.formationSpringBoot.entity.Session;

public interface SessionRepository extends JpaRepository<Session, Long>{
	
	
}
