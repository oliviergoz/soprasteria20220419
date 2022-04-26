package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Guitariste implements Musicien {
	@Autowired // faire injection
	@Qualifier("guitare")
	private Instrument instrument;

	@Override
	public void performer() {
		System.out.println("le guitariste performe");

	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}
