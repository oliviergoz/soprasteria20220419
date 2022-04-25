package formationJpa;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

import formationJpa.dao.DaoFormateur;
import formationJpa.dao.DaoFormation;
import formationJpa.dao.DaoModule;
import formationJpa.dao.DaoModuleFormation;
import formationJpa.dao.DaoOrdinateur;
import formationJpa.dao.DaoPersonne;
import formationJpa.dao.DaoStagiaire;
import formationJpa.entity.Adresse;
import formationJpa.entity.Civilite;
import formationJpa.entity.Formateur;
import formationJpa.entity.Formation;
import formationJpa.entity.Module;
import formationJpa.entity.ModuleFormation;
import formationJpa.entity.ModuleFormationId;
import formationJpa.entity.Ordinateur;
import formationJpa.entity.Personne;
import formationJpa.entity.Stagiaire;
import formationJpa.util.Context;

public class PersistenceTest {
	public static void main(String[] args) {

		Formateur olivier = new Formateur();
		olivier.setPrenom("olivier");

		DaoFormateur daoFormateur = Context.getDaoFormateur();
		daoFormateur.insert(olivier);
		olivier.setNom("gozlan");
		olivier=daoFormateur.update(olivier);
		olivier.setCivilite(Civilite.M);
		olivier=daoFormateur.update(olivier);
		olivier.setExperience(10);
		olivier=daoFormateur.update(olivier);

//
//		Formation formation = new Formation();
//		formation.setNom("java");
//		formation.setReferent(olivier);
//
//		DaoFormation daoFormation = Context.getDaoFormation();
//		daoFormation.insert(formation);
//
//		Stagiaire hamza = new Stagiaire("hamza", "M");
//		Stagiaire fabien = new Stagiaire("fabien", null);
//		DaoStagiaire daoStagiaire = Context.getDaoStagiaire();
//		daoStagiaire.insert(fabien);
//		daoStagiaire.insert(hamza);
//
//		Set<Stagiaire> participants = new HashSet<Stagiaire>();
//		participants.add(fabien);
//		participants.add(hamza);
//
//		formation.setParticipants(participants);
//		daoFormation.update(formation);
//
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
