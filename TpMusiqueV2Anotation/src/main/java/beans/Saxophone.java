package beans;

import org.springframework.stereotype.Component;

@Component
public class Saxophone implements Instrument{

	@Override
	public void jouer() {
		System.out.println("joue Saxo");
		
	}

}
