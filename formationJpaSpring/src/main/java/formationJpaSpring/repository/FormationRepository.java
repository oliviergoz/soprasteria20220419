package formationJpaSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import formationJpaSpring.entity.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long>{

}
