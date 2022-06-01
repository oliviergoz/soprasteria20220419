package formation.soprasteria.formationSpringBoot.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@SequenceGenerator(sequenceName = "seq_evaluation",name = "seqEvaluationJPA",initialValue = 300,allocationSize = 1)
public class Evaluation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator= "seqEvaluationJPA")
	private Long id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	@Min(0)
	@Max(20)
	private double note;
	private String commentaire;
	
	@ManyToOne
	private Module module;
	@ManyToOne
	private Stagiaire stagiaire;
	
	public Evaluation() {
	}

	public Evaluation(double note, String commentaire, Module module, Stagiaire stagiaire) {
		this.note = note;
		this.commentaire = commentaire;
		this.module = module;
		this.stagiaire = stagiaire;
		this.date=LocalDate.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}
	
	
	
	
	
	
}
