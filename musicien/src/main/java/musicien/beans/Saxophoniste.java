package musicien.beans;

public class Saxophoniste implements Musicien {

	private Instrument instrument;

	@Override
	public String perform() {
		return "le saxophoniste joue:" + this.instrument.jouer();
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}
