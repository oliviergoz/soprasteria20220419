package pokemon.dao;

import java.util.List;

import pokemon.entity.Dresseur;
import pokemon.entity.Personne;

public interface DaoDresseur extends DaoGeneric<Dresseur, Integer> {
	public Dresseur findByIdWithPokemon(Integer id);

	public Dresseur findByIdWithSac(Integer id);

	public Dresseur findByIdWithPokemonAndSac(Integer id);

	public List<Dresseur> findAllWithPokemonHaving3pp();
}
