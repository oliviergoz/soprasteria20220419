package formationJpaSpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formationJpaSpring.entity.Formateur;
import formationJpaSpring.exception.FormateurException;
import formationJpaSpring.repository.FormateurRepository;
import formationJpaSpring.repository.FormationRepository;

@Service
public class FormateurService {

	@Autowired
	private FormateurRepository formateurRepo;
	@Autowired
	private FormationRepository formationRepo;

	public List<Formateur> getAll() {
		return formateurRepo.findAll();
	}

	public Formateur getById(Long id) {
		return formateurRepo.findById(id).orElseThrow(() -> {
			throw new FormateurException("id inconnu");
		});
	}

	public Formateur update(Formateur formateur) {
		if (formateur.getId() == null) {
			throw new FormateurException("id obligatoire");
		}
		Formateur formateurEnBase = getById(formateur.getId());
		formateur.setVersion(formateurEnBase.getVersion());
		return formateurRepo.save(formateur);
	}

	public Formateur create(Formateur formateur) {
		if (formateur.getId() != null) {
			throw new FormateurException("id auto");
		}
		return formateurRepo.save(formateur);
	}

	public void delete(Formateur formateur) {
		delete(formateur.getId());
	}

	public void delete(Long id) {
		Formateur formateur = getById(id);
		formationRepo.setReferentToNull(formateur);
		formateurRepo.delete(formateur);
	}
}
