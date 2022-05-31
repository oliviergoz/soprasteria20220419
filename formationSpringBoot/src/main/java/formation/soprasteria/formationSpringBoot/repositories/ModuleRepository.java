package formation.soprasteria.formationSpringBoot.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.soprasteria.formationSpringBoot.entity.Session;
import formation.soprasteria.formationSpringBoot.entity.Matiere;
import formation.soprasteria.formationSpringBoot.entity.Module;

public interface ModuleRepository extends JpaRepository<Module, Long>{
	
	
	public List<Module> findAllBySessionId(Long id);
	
	public List<Module> findBySession(Session session);
	
	@Modifying
	@Transactional
	@Query("update Module m set m.matiere=null where m.matiere=:matiere")
	public void setMatiereToNull(@Param("matiere") Matiere matiere);
	
}
