package formation.soprasteria.formationSpringBoot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.soprasteria.formationSpringBoot.entity.Session;
import formation.soprasteria.formationSpringBoot.entity.Module;

public interface ModuleRepository extends JpaRepository<Module, Long> {

	public List<formation.soprasteria.formationSpringBoot.entity.Module> findAllBySessionId(Long id);

	public List<Module> findBySession(Session session);

}
