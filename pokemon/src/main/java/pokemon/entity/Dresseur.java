package pokemon.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dresseur")
public class Dresseur extends Personne {

	private int pokedollars;

	private int badge;

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

}
