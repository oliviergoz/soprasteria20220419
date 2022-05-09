package quest.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import quest.entity.Compte;
import quest.entity.Formateur;
import quest.entity.Stagiaire;

public interface CompteRepository extends JpaRepository<Compte, Long>{
	
	@Query("Select c from Compte c where c.login=:login and c.password=:password")
	Optional<Compte> seConnecter(@Param("login") String login,@Param("password") String password);

	@Query("Select s from Stagiaire s")
	List<Stagiaire> findAllStagiaires();
	
	@Query("Select f from Formateur f")
	List<Formateur> findAllFormateurs();
}
