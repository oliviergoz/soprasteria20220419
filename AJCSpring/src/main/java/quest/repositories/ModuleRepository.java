package quest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import quest.entity.Module;
public interface ModuleRepository extends JpaRepository<Module, Long>{
	
	
}
