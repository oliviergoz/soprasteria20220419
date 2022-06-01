package formation.soprasteria.formationSpringBoot.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(sequenceName = "seq_session",name = "seqSessionJPA",initialValue = 300,allocationSize = 1)
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator= "seqSessionJPA")
	private Long id;
	private String libelle;
	@OneToMany(mappedBy = "session")
	private Set<Stagiaire> stagiaires;
	@OneToMany(mappedBy = "session")
	private Set<Module> modules;
	
	public Session() {
	}
	
	

	public Session(String libelle) {
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

	public Set<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(Set<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
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
		Session other = (Session) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
}
