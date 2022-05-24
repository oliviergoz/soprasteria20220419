package formation.soprasteria.exercice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.soprasteria.exercice.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByLogin(String login);
}
