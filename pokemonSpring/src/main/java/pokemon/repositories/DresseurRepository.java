package pokemon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pokemon.entity.Dresseur;

public interface DresseurRepository extends JpaRepository<Dresseur, Integer>{

}
