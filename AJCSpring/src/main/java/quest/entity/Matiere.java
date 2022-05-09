package quest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(sequenceName = "seqMatiere",name = "seqMatiereJPA")
public class Matiere {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator= "seqMatiereJPA")
	private Long id;
	private String libelle;
	
	public Matiere() {
	}

	public Matiere(String libelle) {
		this.libelle = libelle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
}
