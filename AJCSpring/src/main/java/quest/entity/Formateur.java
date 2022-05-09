package quest.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("formateur")
public class Formateur extends Compte{

	@OneToMany(mappedBy = "formateur")
	private List<Module> modules;
	
	public Formateur() {
		super();
	}

	public Formateur(String login, String password, String nom, String prenom) {
		super(login, password, nom, prenom);
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	
	
	
}

