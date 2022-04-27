package formationJpaSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import formationJpaSpring.entity.Formateur;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {

}
