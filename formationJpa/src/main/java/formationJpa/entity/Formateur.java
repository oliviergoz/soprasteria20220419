package formationJpa.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="formateur")
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_formateur", initialValue = 800, allocationSize = 1)
//@DiscriminatorValue("T")
public class Formateur extends Personne {
	private int experience;

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

}
