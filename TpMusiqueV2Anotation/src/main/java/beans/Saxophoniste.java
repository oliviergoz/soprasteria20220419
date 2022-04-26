package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Saxophoniste implements Musicien{
@Autowired
@Qualifier("saxophone")
	private Instrument instrument; // joue d'un instrument c'est dans XML qu'on va préciser que c'est un sax
	@Override
	public void performer() {
		System.out.println("le Saxophoniste performe");
		
	}
	public Instrument getInstrument() {
		return instrument;
	}
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	

}
