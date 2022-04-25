package pokemon.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pokedex")
@SequenceGenerator(name = "seqPokedex", sequenceName = "seq_pokedex", initialValue = 10, allocationSize = 1)
public class Pokedex implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPokedex")
	private Integer id;
	private String nom;
	private int pvBase;
	private int attaqueBase;
	private int vitesseBase;
	private int defenseBase;
	private int tauxCapture;
	@ElementCollection(targetClass = Type.class, fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "type_pokedex")
	private Set<Type> type;
	@Enumerated(EnumType.STRING)
	private Evolution typeEvolution;
	@ManyToOne
	@JoinColumn(name = "pre_evolution", foreignKey = @ForeignKey(name = "pokedex_pre_evolution_fk"))
	private Pokedex preEvolution;
	@ManyToOne
	@JoinColumn(name = "pierre_evolution", foreignKey = @ForeignKey(name = "pokedex_pierre_evolution_fk"))
	private Rare pierreEvolution;
	private Integer niveauEvolution;

	public Set<Type> getType() {
		return type;
	}

	public void setType(Set<Type> type) {
		this.type = type;
	}

	public Pokedex getPreEvolution() {
		return preEvolution;
	}

	public void setPreEvolution(Pokedex preEvolution) {
		this.preEvolution = preEvolution;
	}

	public void setPierreEvolution(Rare pierreEvolution) {
		this.pierreEvolution = pierreEvolution;
	}

	public Pokedex() {

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPvBase() {
		return pvBase;
	}

	public void setPvBase(int pvBase) {
		this.pvBase = pvBase;
	}

	public int getTauxCapture() {
		return tauxCapture;
	}

	public void setTauxCapture(int tauxCapture) {
		this.tauxCapture = tauxCapture;
	}

	public int getAttaqueBase() {
		return attaqueBase;
	}

	public void setAttaqueBase(int attaqueBase) {
		this.attaqueBase = attaqueBase;
	}

	public int getVitesseBase() {
		return vitesseBase;
	}

	public void setVitesseBase(int vitesseBase) {
		this.vitesseBase = vitesseBase;
	}

	public int getDefenseBase() {
		return defenseBase;
	}

	public void setDefenseBase(int defenseBase) {
		this.defenseBase = defenseBase;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Evolution getTypeEvolution() {
		return typeEvolution;
	}

	public void setTypeEvolution(Evolution typeEvolution) {
		this.typeEvolution = typeEvolution;
	}

	public Item getPierreEvolution() {
		return pierreEvolution;
	}

	public Integer getNiveauEvolution() {
		return niveauEvolution;
	}

	public void setNiveauEvolution(Integer niveauEvolution) {
		this.niveauEvolution = niveauEvolution;
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
		Pokedex other = (Pokedex) obj;
		return Objects.equals(id, other.id);
	}

}
