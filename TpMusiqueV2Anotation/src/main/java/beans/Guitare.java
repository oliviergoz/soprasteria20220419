package beans;

import org.springframework.stereotype.Component;

@Component  // a la place de creer des bean dans le fichier xml 
public class Guitare implements Instrument {

	@Override
	public void jouer() {
		System.out.println("Jouer Guitare");
		
	}

}
