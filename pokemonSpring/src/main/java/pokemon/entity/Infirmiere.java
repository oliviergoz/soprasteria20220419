package pokemon.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "infirmiere")
public class Infirmiere extends Personne {

	public Infirmiere() {
		super();
		this.nom = "Joelle";
		this.genre = Genre.FEMME;
	}

}
