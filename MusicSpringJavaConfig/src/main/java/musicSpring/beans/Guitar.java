package musicSpring.beans;

import org.springframework.stereotype.Component;

@Component
public class Guitar implements Instrument{

	@Override
	public String jouer() {
		return "joue de la guitar";
	}

}
