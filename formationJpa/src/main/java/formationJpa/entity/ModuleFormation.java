package formationJpa.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "module_formation")
public class ModuleFormation {

	@EmbeddedId
	private ModuleFormationId key;

	private LocalDate date;
	@ManyToOne
	@JoinColumn(name = "animateur_id", foreignKey = @ForeignKey(name = "module_formation_animateur_id_fk"))
	private Formateur animateur;

	public ModuleFormation() {

	}

	public ModuleFormationId getKey() {
		return key;
	}

	public void setKey(ModuleFormationId key) {
		this.key = key;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Formateur getAnimateur() {
		return animateur;
	}

	public void setAnimateur(Formateur animateur) {
		this.animateur = animateur;
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
		ModuleFormation other = (ModuleFormation) obj;
		return Objects.equals(key, other.key);
	}

}
