package quest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.entity.Matiere;
import quest.exception.MatiereException;
import quest.repositories.MatiereRepository;

@Service
public class MatiereService {
	@Autowired
	private MatiereRepository matiereRepository;

	public List<Matiere> getAll() {
		return matiereRepository.findAll();
	}

	public Matiere getById(Long id) {
		return matiereRepository.findById(id).orElseThrow(MatiereException::new);
	}

	public Matiere create(Matiere matiere) {
		return matiereRepository.save(matiere);
	}

	public Matiere update(Matiere matiere) {
		return matiereRepository.save(matiere);
	}

	public void delete(Matiere matiere) {
		matiereRepository.delete(matiere);
	}

	public void deleteById(Long id) {
		Matiere matiere = new Matiere();
		matiere.setId(id);
		delete(matiere);
	}
}
