package formationJpa.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("S")
@Table(name = "stagiaire")
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_stagaire", initialValue = 800, allocationSize = 1)
public class Stagiaire extends Personne {

	public Stagiaire() {

	}

	public Stagiaire(String prenom, String nom) {
		super(prenom, nom);
	}

	@OneToOne
	@JoinColumn(name = "pc_serial", foreignKey = @ForeignKey(name = "STAGIAIRE_PC_SERIAL_FK"))
	private Ordinateur ordinateur;

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

}
