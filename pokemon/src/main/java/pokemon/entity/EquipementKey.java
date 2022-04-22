package pokemon.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class EquipementKey implements Serializable {
	@ManyToOne
	@JoinColumn(name = "dresseur_id", foreignKey = @ForeignKey(name = "equipement_dresseur_id_fk"))
	private Dresseur dresseur;
	@ManyToOne
	@JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "equipement_item_id_fk"))
	private Item item;

	public EquipementKey() {

	}

	public EquipementKey(Dresseur dresseur, Item item) {
		super();
		this.dresseur = dresseur;
		this.item = item;
	}

	public Dresseur getDresseur() {
		return dresseur;
	}

	public void setDresseur(Dresseur dresseur) {
		this.dresseur = dresseur;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dresseur, item);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipementKey other = (EquipementKey) obj;
		return Objects.equals(dresseur, other.dresseur) && Objects.equals(item, other.item);
	}

}
