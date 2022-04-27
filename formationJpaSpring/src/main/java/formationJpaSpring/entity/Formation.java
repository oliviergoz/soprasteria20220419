package formationJpaSpring.entity;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "formation")
@SequenceGenerator(name = "seqFormation", sequenceName = "seq_formation", initialValue = 10, allocationSize = 1)
public class Formation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFormation")
	private Long id;
	private String nom;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "referent_id", foreignKey = @ForeignKey(name = "FORMATION_REFERENT_ID_FK"))
	private Formateur referent;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "participant", joinColumns = @JoinColumn(name = "formation_id", foreignKey = @ForeignKey(name = "PARTICIPANT_FORMATION_ID_FK")), inverseJoinColumns = @JoinColumn(name = "participant_id", foreignKey = @ForeignKey(name = "PARTICIPANT_PARTICIPANT_ID_FK")))
	private Set<Stagiaire> participants;
	@OneToMany(mappedBy = "key.formation")
	private Set<ModuleFormation> modulesFormations;

	public Formation() {

	}

	public Formation(String nom) {
		super();
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Formateur getReferent() {
		return referent;
	}

	public void setReferent(Formateur referent) {
		this.referent = referent;
	}

	public Set<Stagiaire> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Stagiaire> participants) {
		this.participants = participants;
	}

	public Set<ModuleFormation> getModulesFormations() {
		return modulesFormations;
	}

	public void setModulesFormations(Set<ModuleFormation> modulesFormations) {
		this.modulesFormations = modulesFormations;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formation other = (Formation) obj;
		return Objects.equals(id, other.id);
	}

}
