package pokemon.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dresseur")
public class Dresseur extends Personne {

	private int pokedollars;

	private int badge;

	@OneToOne(mappedBy = "maitre")
	private Arene arene;
	@OneToMany(mappedBy = "key.dresseur")
	private Set<Equipement> sac;
	@OneToMany(mappedBy = "dresseur")
	private Set<Pokemon> pokemons;

//	//version on est sbire que d'une arene
//	@ManyToOne
//	@JoinColumn(name = "arene_id", foreignKey = @ForeignKey(name = "dresseur_arene_id_fk"))
//	private Arene arene;

	public Dresseur() {

	}

	public int getPokedollars() {
		return pokedollars;
	}

	public void setPokedollars(int pokedollars) {
		this.pokedollars = pokedollars;
	}

	public int getBadge() {
		return badge;
	}

	public void setBadge(int badge) {
		this.badge = badge;
	}

	public Arene getArene() {
		return arene;
	}

	public void setArene(Arene arene) {
		this.arene = arene;
	}

	public Set<Equipement> getSac() {
		return sac;
	}

	public void setSac(Set<Equipement> sac) {
		this.sac = sac;
	}

	public Set<Pokemon> getPokemons() {
		return pokemons;
	}

	public void setPokemons(Set<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

}
