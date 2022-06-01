package formation.soprasteria.formationSpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import formation.soprasteria.formationSpringBoot.entity.Compte;
import formation.soprasteria.formationSpringBoot.entity.Formateur;
import formation.soprasteria.formationSpringBoot.entity.Session;
import formation.soprasteria.formationSpringBoot.entity.Stagiaire;
import formation.soprasteria.formationSpringBoot.exception.CompteException;
import formation.soprasteria.formationSpringBoot.repositories.CompteRepository;

@Service
public class CompteService {
	
	@Autowired
	PasswordEncoder passwordEncoder;

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

	public Formateur getByIdWithModules(Long id) {
		return compteRepository.findByIdWithModules(id).orElseThrow(RuntimeException::new);
	}

	public Compte seConnecter(String login, String password) {
		return compteRepository.seConnecter(login, password).orElseThrow(RuntimeException::new);
	}

	public Compte create(Compte compte) {
		// encodage du mot de passe quand on saura faire
		compte.setPassword(passwordEncoder.encode(compte.getPassword()));
		return compteRepository.save(compte);
	}

	// public Compte updatePassword() {

	// }

	public Compte update(Compte compte) {
		Compte compteEnBase = getById(compte.getId());
		compteEnBase.setLogin(compte.getLogin());
		compteEnBase.setNom(compte.getNom());
		compteEnBase.setPrenom(compte.getPrenom());

		if (compte instanceof Stagiaire) {
			Session session = ((Stagiaire) compte).getSession();
			((Stagiaire) compteEnBase).setSession(session);
		}

		return compteRepository.save(compteEnBase);
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

	public Compte getByLogin(String login) {
		return compteRepository.findByLogin(login).orElseThrow(CompteException::new);
	}
	
	public boolean checkLoginExist(String login) {
		return compteRepository.findByLogin(login).isPresent();
	}

}
