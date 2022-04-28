package pokemon.entity;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "arene")
@SequenceGenerator(name = "seqArene", sequenceName = "seq_arene", initialValue = 10, allocationSize = 1)
public class Arene {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqArene")
	private Long id;
	private String nom;
	private int ordre;
	@Enumerated(EnumType.STRING)
	private Type type;
	@OneToOne
	@JoinColumn(name = "maitre_id", foreignKey = @ForeignKey(name = "arene_maitre_id_fk"))
	private Dresseur maitre;

//	// version on est sbires d'une seule arene
//	@OneToMany(mappedBy = "arene")
//	private Set<Dresseur> sbires;

	// on est sbires dans plusieurs arenes
	@ManyToMany
	@JoinTable(name = "sbires", joinColumns = @JoinColumn(name = "arene_id", foreignKey = @ForeignKey(name = "sbire_arene_id_fk")), inverseJoinColumns = @JoinColumn(name = "sbire_id", foreignKey = @ForeignKey(name = "sbire_sbire_id_fk")))
	private Set<Dresseur> sbires;

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

	public Dresseur getMaitre() {
		return maitre;
	}

	public void setMaitre(Dresseur maitre) {
		this.maitre = maitre;
	}

	public Set<Dresseur> getSbires() {
		return sbires;
	}

	public void setSbires(Set<Dresseur> sbires) {
		this.sbires = sbires;
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
