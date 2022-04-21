package pokemon.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("s")
public class Soin extends Item {

	private int soin;

	public Soin() {

	}

	public Soin(Integer id, String libelle, int soin) {
		super(libelle, id);
		this.soin = soin;
	}

	public Soin(String libelle, int soin) {
		super(libelle);
		this.soin = soin;
	}

	public Integer getSoin() {
		return soin;
	}

	public void setSoin(int soin) {
		this.soin = soin;
	}

}
