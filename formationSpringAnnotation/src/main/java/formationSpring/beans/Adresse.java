package formationSpring.beans;

import org.springframework.stereotype.Component;

@Component("domicile")
public class Adresse {
	private String adresse="chez moi";

	public Adresse() {

	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
