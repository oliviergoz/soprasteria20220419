package quest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.entity.Compte;
import quest.entity.Formateur;
import quest.entity.Stagiaire;
import quest.repositories.CompteRepository;

@Service
public class CompteService {
	
@Autowired 
private CompteRepository compteRepository;
	
	
	public List<Compte> getAll() {
		return compteRepository.findAll();
	}
	
	public List<Stagiaire> getAllStagiaires() {
		return compteRepository.findAllStagiaires();
	}
	
	public List<Formateur> getAllFormateurs() {
		return compteRepository.findAllFormateurs();
	}

	public Compte getById(Long id) {
		return compteRepository.findById(id).orElseThrow(RuntimeException::new);
	}
	
	public Compte seConnecter(String login,String password) {
		return compteRepository.seConnecter(login,password).orElseThrow(RuntimeException::new);
	}

	public void create(Compte compte) {
		compteRepository.save(compte);
	}

	public Compte update(Compte compte) {
		return compteRepository.save(compte);
	}

	public void delete(Compte compte) {
		compteRepository.delete(compte);
	}

	public void deleteByIdStagiaire(Long id) {
		Compte compte = new Stagiaire();
		compte.setId(id);
		delete(compte);
	}
	
	public void deleteByIdFormateur(Long id) {
		Compte compte = new Formateur();
		compte.setId(id);
		delete(compte);
	}
}
