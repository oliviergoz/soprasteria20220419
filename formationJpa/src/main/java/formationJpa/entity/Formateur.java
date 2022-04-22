package formationJpa.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "formateur")
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_formateur", initialValue = 800, allocationSize = 1)
//@DiscriminatorValue("T")
public class Formateur extends Personne {
	private int experience;

	@OneToMany(mappedBy = "referent")
	private Set<Formation> formations;

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

}
