package musicSpring.beans;

import org.springframework.stereotype.Component;

@Component
public class Saxophone implements Instrument{

	@Override
	public String jouer() {
		return "joue du saxophone";
	}

}
