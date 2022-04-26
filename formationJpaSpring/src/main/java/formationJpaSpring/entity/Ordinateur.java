package formationJpaSpring.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordinateur")
public class Ordinateur {
	@Id
	private String serie;
	private String libelle;
	@OneToOne(mappedBy = "ordinateur")
	private Stagiaire stagiaire;
	


	public Ordinateur() {

	}

	public Ordinateur(String serie, String libelle) {
		super();
		this.serie = serie;
		this.libelle = libelle;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	@Override
	public int hashCode() {
		return Objects.hash(serie);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordinateur other = (Ordinateur) obj;
		return Objects.equals(serie, other.serie);
	}

}
