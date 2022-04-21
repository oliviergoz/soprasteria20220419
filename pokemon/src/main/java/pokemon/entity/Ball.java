package pokemon.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("b")
public class Ball extends Item {

	private double taux;

	public Ball() {

	}

	public Ball(Integer id, String libelle, double taux) {
		super(libelle, id);
		this.taux = taux;
	}

	public Ball(String libelle, double taux) {
		super(libelle);
		this.taux = taux;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}
