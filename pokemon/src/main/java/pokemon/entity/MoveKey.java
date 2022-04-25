package pokemon.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class MoveKey implements Serializable {
	@ManyToOne
	@JoinColumn(name = "attaque_id", foreignKey = @ForeignKey(name = "move_attaque_id_fk"))
	private Attaque attaque;
	@ManyToOne
	@JoinColumn(name = "pokemmon_id", foreignKey = @ForeignKey(name = "move_pokemon_id_fk"))
	private Pokemon pokemon;

	public MoveKey() {

	}

	public MoveKey(Attaque attaque, Pokemon pokemon) {
		super();
		this.attaque = attaque;
		this.pokemon = pokemon;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attaque, pokemon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoveKey other = (MoveKey) obj;
		return Objects.equals(attaque, other.attaque) && Objects.equals(pokemon, other.pokemon);
	}

}
