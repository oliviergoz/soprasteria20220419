package formationJpa.dao;

import java.util.List;

import formationJpa.entity.Formateur;
import formationJpa.entity.Formation;

public interface DaoFormation extends DaoGeneric<Formation, Long> {
	public List<Formation> findByReferent(Formateur referent);

	public List<Formation> findByNom(String nom);

	public Formation findByIdWithParticipants(Long id);

	public Formation findByIdWithModules(Long id);

	public Formation findByIdWithModulesAndParticipants(Long id);
}
