package quest.entity;

import java.time.LocalDate;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@SequenceGenerator(sequenceName = "seqModule",name = "seqModuleJPA")
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator= "seqModuleJPA")
	private Long id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate debut;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fin;
	private int code;
	@ManyToOne
	private Matiere matiere;
	@ManyToOne
	private Formateur formateur;
	@ManyToOne
	private Session session;
	
	
	private transient static Random rand = new Random();
	
	
	public Module() {
	}


	public Module(LocalDate debut, LocalDate fin,Matiere matiere,Formateur formateur,Session session) {
		this.debut = debut;
		this.fin = fin;
		this.code = rand.nextInt(9000)+1000;
		this.matiere=matiere;
		this.formateur=formateur;
		this.session=session;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDate getDebut() {
		return debut;
	}


	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}


	public LocalDate getFin() {
		return fin;
	}


	public void setFin(LocalDate fin) {
		this.fin = fin;
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public Matiere getMatiere() {
		return matiere;
	}


	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}


	public Formateur getFormateur() {
		return formateur;
	}


	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}


	public Session getSession() {
		return session;
	}


	public void setSession(Session session) {
		this.session = session;
	}

	
	
}
