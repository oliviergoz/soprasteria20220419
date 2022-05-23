package formation.soprasteria.formationSpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.soprasteria.formationSpringBoot.entity.Session;
import formation.soprasteria.formationSpringBoot.repositories.SessionRepository;
import formation.soprasteria.formationSpringBoot.entity.Module;

@Service
public class SessionService {
	@Autowired
	private SessionRepository sessionRepository;
	@Autowired
	ModuleService mds;

	public List<Session> getAll() {
		return sessionRepository.findAll();
	}

	public Session getById(Long id) {
		return sessionRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	public void create(Session session) {
		sessionRepository.save(session);
	}

	public Session update(Session session) {
		return sessionRepository.save(session);
	}

	public void delete(Session session) {

		List<Module> ms = mds.getAllBySession(session.getId());

		for (Module m : ms) {
			mds.delete(m);
		}
		sessionRepository.delete(session);
	}

	public void deleteById(Long id) {
		Session session = new Session();
		session.setId(id);
		delete(session);
	}
}
