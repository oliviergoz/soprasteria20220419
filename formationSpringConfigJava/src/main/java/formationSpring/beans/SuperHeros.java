package formationSpring.beans;

public class SuperHeros implements IPersonne {

	private Adresse autreDimension;

	public SuperHeros() {
		this.autreDimension = new Adresse();
		this.autreDimension.setAdresse("une autre dimension");
	}

	@Override
	public Adresse getAdresse() {
		return autreDimension;
	}

}
