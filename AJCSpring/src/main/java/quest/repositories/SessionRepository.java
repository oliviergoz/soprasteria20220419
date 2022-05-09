package quest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import quest.entity.Session;

public interface SessionRepository extends JpaRepository<Session, Long>{
	
	
}
