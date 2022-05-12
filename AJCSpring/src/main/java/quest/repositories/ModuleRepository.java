package quest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import quest.entity.Module;
import quest.entity.Session;

public interface ModuleRepository extends JpaRepository<Module, Long> {

	public List<Module> findAllBySessionId(Long id);

	public List<Module> findBySession(Session session);

}
