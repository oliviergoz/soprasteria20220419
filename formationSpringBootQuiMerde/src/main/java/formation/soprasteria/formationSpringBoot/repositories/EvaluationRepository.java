package formation.soprasteria.formationSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.soprasteria.formationSpringBoot.entity.Evaluation;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long>{
	
	
}
