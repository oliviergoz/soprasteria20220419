package pokemon.entity;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "equipement")
public class Equipement {
	@EmbeddedId
	private EquipementKey key;
	private int quantite;

	public Equipement() {

	}

	public Equipement(EquipementKey key, int quantite) {
		super();
		this.key = key;
		this.quantite = quantite;
	}

	public EquipementKey getKey() {
		return key;
	}

	public void setKey(EquipementKey key) {
		this.key = key;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public int hashCode() {
		return Objects.hash(key);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipement other = (Equipement) obj;
		return Objects.equals(key, other.key);
	}

}
