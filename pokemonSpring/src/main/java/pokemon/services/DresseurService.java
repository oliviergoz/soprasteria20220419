package pokemon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pokemon.entity.Dresseur;
import pokemon.exceptions.DresseurException;
import pokemon.repositories.AreneRepository;
import pokemon.repositories.DresseurRepository;

@Service
public class DresseurService {

	@Autowired
	private DresseurRepository dresseurRepository;
	@Autowired
	private AreneRepository areneRepository;
	@Autowired
	private AreneService areneService;

	public List<Dresseur> getAll() {
		return dresseurRepository.findAll();
	}

	public Dresseur getById(Integer id) {
		return dresseurRepository.findById(id).orElseThrow(DresseurException::new);
	}

	public void create(Dresseur dresseur) {
		if (dresseur.getNom() == null || dresseur.getNom().isEmpty()) {
			throw new DresseurException();
		}
		// encoder le mot de passe
		// dresseur.setPassword(encodage(dresseur.getPassword()));
		dresseurRepository.save(dresseur);
	}

	public Dresseur update(Dresseur dresseur) {
		Dresseur dresseurEnBase = getById(dresseur.getId());
		dresseurEnBase.setNom(dresseur.getNom());
		dresseurEnBase.setBadge(dresseur.getBadge());
		dresseurEnBase.setPokedollars(dresseur.getPokedollars());
		return dresseurRepository.save(dresseurEnBase);
	}

//	public Dresseur updatePassword(Dresseur dresseur) {
//		// encodage du mot de passe
//		// update
//
//	}

	public void delete(Dresseur dresseur) {
		areneRepository.deleteByMaitre(dresseur);
//		areneRepository.findAllContainingSbire(dresseur).forEach(arene -> {
//			areneService.removeSbire(arene, dresseur);
//		});
		areneRepository.deleteSbireBySbireId(dresseur.getId());
		dresseurRepository.delete(dresseur);
	}

	public void deleteById(Integer id) {
		Dresseur dresseur = new Dresseur();
		dresseur.setId(id);
		delete(dresseur);
	}
}
