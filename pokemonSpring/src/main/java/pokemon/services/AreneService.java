package pokemon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pokemon.entity.Arene;
import pokemon.entity.Dresseur;
import pokemon.exceptions.AreneException;
import pokemon.repositories.AreneRepository;

@Service
public class AreneService {

	@Autowired
	private AreneRepository areneRepository;

	public List<Arene> getAll() {
		return areneRepository.findAll();
	}

	public Arene getById(Long id) {
		return areneRepository.findById(id).orElseThrow(AreneException::new);
	}

	public Arene getByIdDetails(Long id) {
		return areneRepository.findByIdWithMaitreAndSbires(id).orElseThrow(AreneException::new);
	}

	public void create(Arene arene) {
		// controle des attributs
		areneRepository.save(arene);
	}

	public void create(String nom) {
		Arene arene = new Arene();
		arene.setNom(nom);
		areneRepository.save(arene);
	}

	public void create(String nom, Dresseur maitre) {
		Arene arene = new Arene();
		arene.setNom(nom);
		arene.setMaitre(maitre);
		areneRepository.save(arene);
	}

	public Arene update(Arene arene) {
		// si version dans arene
		// Arene areneEnBase = getById(arene.getId());
		// arene.setVersion(areneEnBase.getVersion());
		return areneRepository.save(arene);
	}

	public void delete(Arene arene) {
		areneRepository.delete(arene);
	}

	public void deleteById(Long id) {
		areneRepository.deleteById(id);
	}

	public Arene addSbire(Arene arene, Dresseur sbire) {
		Arene areneEnBase = getByIdDetails(arene.getId());
		if (sbire.getId() == null) {
			throw new AreneException();
		}
		areneEnBase.getSbires().add(sbire);
		return update(areneEnBase);
	}

	public Arene removeSbire(Arene arene, Dresseur sbire) {
		Arene areneEnBase = getByIdDetails(arene.getId());
		if (sbire.getId() == null) {
			throw new AreneException();
		}
		areneEnBase.getSbires().remove(sbire);
		return update(areneEnBase);
	}

	public Arene removeSbire(Arene arene, Integer sbireId) {
		Dresseur sbire = new Dresseur();
		sbire.setId(sbireId);
		return removeSbire(arene, sbire);
	}

}
