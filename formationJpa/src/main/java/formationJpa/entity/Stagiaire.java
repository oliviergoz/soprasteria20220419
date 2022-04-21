package formationJpa.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("S")
@Table(name = "stagiaire")
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_stagaire", initialValue = 800, allocationSize = 1)
public class Stagiaire extends Personne {
	private String formation;

	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
	}
}
