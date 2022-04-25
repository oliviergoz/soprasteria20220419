package formationJpa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import formationJpa.dao.DaoFormateur;
import formationJpa.dao.DaoFormation;
import formationJpa.dao.DaoStagiaire;
import formationJpa.entity.Formateur;
import formationJpa.entity.Formation;
import formationJpa.entity.Stagiaire;
import formationJpa.util.Context;

public class PersistenceTest {
	public static void main(String[] args) {

		Formateur olivier = new Formateur();
		olivier.setPrenom("olivier");

		DaoFormateur daoFormateur = Context.getDaoFormateur();
		daoFormateur.insert(olivier);

		Formation formation = new Formation();
		formation.setNom("java");
		formation.setReferent(olivier);

		DaoFormation daoFormation = Context.getDaoFormation();
		daoFormation.insert(formation);

		Stagiaire hamza = new Stagiaire("hamza", "M");
		Stagiaire fabien = new Stagiaire("fabien", null);
		DaoStagiaire daoStagiaire = Context.getDaoStagiaire();
		daoStagiaire.insert(fabien);
		daoStagiaire.insert(hamza);

//		Set<Stagiaire> participants = new HashSet<Stagiaire>();
//		participants.add(fabien);
//		participants.add(hamza);

		Set<Stagiaire> participants = Arrays.asList(fabien, hamza).stream().collect(Collectors.toSet());

		formation.setParticipants(participants);
		daoFormation.update(formation);

		formation = daoFormation.findByIdWithModulesAndParticipants(formation.getId());
		// dead depuis java 8
//		for (Stagiaire s : formation.getParticipants()) {
//			System.out.println(s);
//		}

		// formation.getParticipants().stream().forEach(System.out::println);
		formation.getParticipants().forEach(participant -> {
			System.out.println(participant.getPrenom() + " " + participant.getNom());
		});

//		participants.remove(fabien);
//		daoFormation.update(formation);
//
//		formationJpa.entity.Module java = new Module("java");
//		Module jpa = new Module("jpa");
//
//		DaoModule daoModule = Context.getDaoModule();
//		daoModule.insert(jpa);
//		daoModule.insert(java);
//
//		ModuleFormationId id = new ModuleFormationId(formation, jpa);
//		ModuleFormation mf = new ModuleFormation();
//		mf.setKey(id);
//		mf.setAnimateur(olivier);
//		mf.setDate(LocalDate.now());
//
//		DaoModuleFormation daoModuleFormation = Context.getDaoModuleFormation();
//		daoModuleFormation.insert(mf);
//
//		id = new ModuleFormationId(formation, java);
//		mf = new ModuleFormation();
//		mf.setKey(id);
//		mf.setAnimateur(olivier);
//		mf.setDate(LocalDate.of(2022, Month.APRIL, 26));
//		daoModuleFormation.insert(mf);

		// en dernier
		Context.destroyEntityManagerFactory();
	}
}
