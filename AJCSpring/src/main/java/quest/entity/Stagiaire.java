package quest.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("stagiaire")
public class Stagiaire extends Compte{
	
	@ManyToOne
	private Session session;
	
	public Stagiaire() {
		super();
	}
	
	public Stagiaire(String login, String password, String nom, String prenom, Session session) {
		super(login, password, nom, prenom);
		this.session = session;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	

}

