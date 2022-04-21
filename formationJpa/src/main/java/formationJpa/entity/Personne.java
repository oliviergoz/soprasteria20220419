package formationJpa.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "person")
public class Personne {
	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "first_name", nullable = false, length = 200)
	private String prenom;
	@Column(name = "last_name")
	private String nom;
	@Column(name = "mail", unique = true)
	private String email;
	@Column(name = "birthday")
	private LocalDate dtNaiss;
	@Enumerated(EnumType.STRING)
	@Column(name = "civility", length = 4)
	private Civilite civilite;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "person_number")),
			@AttributeOverride(name = "rue", column = @Column(name = "person_street")),
			@AttributeOverride(name = "codePostal", column = @Column(name = "person_zip_code")),
			@AttributeOverride(name = "ville", column = @Column(name = "person_city")) })
	private Adresse adresse;

	public Personne() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDtNaiss() {
		return dtNaiss;
	}

	public void setDtNaiss(LocalDate dtNaiss) {
		this.dtNaiss = dtNaiss;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
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
		Personne other = (Personne) obj;
		return Objects.equals(id, other.id);
	}

}