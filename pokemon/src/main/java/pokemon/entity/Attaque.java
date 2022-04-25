package pokemon.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seqAttaque", sequenceName = "seq_attaque", allocationSize = 1, initialValue = 10)
public class Attaque {
	private String nom;
	private int degats;
	private int ppBase;
	private int precision;
	@Enumerated(EnumType.STRING)
	private Type type;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAttaque")
	private Integer id;

	public Attaque() {

	}

	public Attaque(Type type, String nom, int degats, int ppBase, int precision) {
		this.nom = nom;
		this.degats = degats;
		this.ppBase = ppBase;
		this.precision = precision;
		this.type = type;
	}

	public Attaque(Integer id, String nom, int degats, int ppBase, int precision, Type type) {
		this.id = id;
		this.nom = nom;
		this.degats = degats;
		this.ppBase = ppBase;
		this.precision = precision;
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDegats() {
		return degats;
	}

	public void setDegats(int degats) {
		this.degats = degats;
	}

	public int getPpBase() {
		return ppBase;
	}

	public void setPpBase(int ppBase) {
		this.ppBase = ppBase;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		Attaque other = (Attaque) obj;
		return Objects.equals(id, other.id);
	}

}
