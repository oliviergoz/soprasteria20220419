package musicSpring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Saxophoniste implements Musicien{
	
	@Autowired
	@Qualifier("saxophone")
	private Instrument instrument;
	private String nom = "Audrey";
	
	@Override
	public String performe() {
		return nom + " " + instrument.jouer();
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
}
