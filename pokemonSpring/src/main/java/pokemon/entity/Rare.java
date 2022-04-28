package pokemon.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("r")
public class Rare extends Item {
	private String description;

	public Rare() {

	}

	public Rare(Integer id, String libelle, String description) {
		super(libelle, id);
		this.description = description;
	}

	public Rare(String libelle, String description) {
		super(libelle);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
