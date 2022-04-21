package pokemon.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "arene")
@SequenceGenerator(name="seqArene",sequenceName = "seq_arene",initialValue = 10,allocationSize = 1)
public class Arene {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqArene")
	private Long id;
	private String nom;
	private int ordre;
	@Enumerated(EnumType.STRING)
	private Type type;

	public Arene() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
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
		Arene other = (Arene) obj;
		return Objects.equals(id, other.id);
	}

}
