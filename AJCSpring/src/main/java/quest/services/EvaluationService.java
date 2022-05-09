package quest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.entity.Evaluation;
import quest.repositories.EvaluationRepository;

@Service
public class EvaluationService {
@Autowired 
private EvaluationRepository evaluationRepository;
	
	
	public List<Evaluation> getAll() {
		return evaluationRepository.findAll();
	}

	public Evaluation getById(Long id) {
		return evaluationRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	public void create(Evaluation evaluation) {
		evaluationRepository.save(evaluation);
	}

	public Evaluation update(Evaluation evaluation) {
		return evaluationRepository.save(evaluation);
	}

	public void delete(Evaluation evaluation) {
		evaluationRepository.delete(evaluation);
	}

	public void deleteById(Long id) {
		Evaluation evaluation = new Evaluation();
		evaluation.setId(id);
		delete(evaluation);
	}
}
