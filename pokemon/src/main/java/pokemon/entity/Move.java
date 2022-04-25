package pokemon.entity;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "move")
public class Move {

	private int pp;
	@EmbeddedId
	private MoveKey key;

	public Move() {

	}

	public Move(int pp, MoveKey key) {
		super();
		this.pp = pp;
		this.key = key;
	}

	public int getPp() {
		return pp;
	}

	public void setPp(int pp) {
		this.pp = pp;
	}

	public void useMove() {
		if (pp > 0) {
			pp--;
		} else {
			System.out.println("Vous n'avez plus de PP pour cette attaque !");
		}
	}

	public MoveKey getKey() {
		return key;
	}

	public void setKey(MoveKey key) {
		this.key = key;
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
		Move other = (Move) obj;
		return Objects.equals(key, other.key);
	}

}
