package quest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import quest.entity.Evaluation;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long>{
	
	
}
