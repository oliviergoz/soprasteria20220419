package musicien.beans;

public class Guitariste implements Musicien {

	private Instrument instrument;

	@Override
	public String perform() {
		return "le guitariste joue:" + this.instrument.jouer();
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}
