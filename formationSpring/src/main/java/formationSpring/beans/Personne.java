package formationSpring.beans;

public class Personne implements IPersonne{

	private String nom;
	private Adresse adresse;
	
	public Personne() {
		System.out.println("construction d'une personne");
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
}
