package formation.soprasteria.formationSpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.soprasteria.formationSpringBoot.repositories.ModuleRepository;
import formation.soprasteria.formationSpringBoot.entity.Module;

@Service
public class ModuleService {
@Autowired 
private ModuleRepository moduleRepository;
	
	
	public List<Module> getAll() {
		return moduleRepository.findAll();
	}
	
	public List<Module> getAllBySession(Long session) {
		return moduleRepository.findAllBySessionId(session);
	}

	public Module getById(Long id) {
		return moduleRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	public Module create(Module module) {
		return moduleRepository.save(module);
	}

	public Module update(Module module) {
		return moduleRepository.save(module);
	}

	public void delete(Module module) {
		moduleRepository.delete(module);
	}

	public void deleteById(Long id) {
		Module module = new Module();
		module.setId(id);
		delete(module);
	}
}
