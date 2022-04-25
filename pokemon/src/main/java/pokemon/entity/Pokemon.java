package pokemon.entity;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pokemon")
@SequenceGenerator(name = "seqPokemon", sequenceName = "seq_pokemon", initialValue = 10, allocationSize = 1)
public class Pokemon {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPokemon")
	private Integer id;
	private String genre;
	private int pvMax;
	private int pv;
	private int attaque;
	private int vitesse;
	private int defense;
	private int niveau;
	private int expRequis;
	private int exp;
	@ManyToOne
	@JoinColumn(name = "pokedex_id", foreignKey = @ForeignKey(name = "pokemon_pokedex_id_fk"))
	private Pokedex pokedex;
	private boolean equipe;
	@ManyToOne
	@JoinColumn(name = "dresseur_id", foreignKey = @ForeignKey(name = "pokemon_dresseur_id_fk"))
	private Dresseur dresseur;
	@OneToMany(mappedBy = "key.pokemon")
	private Set<Move> moveSet;

	public Pokemon() {

	}

	public Pokemon(String genre, int niveau, Pokedex pokedex, Dresseur dresseur, List<Move> moveSet, boolean equipe) {
		this.genre = genre;
		this.pvMax = pokedex.getPvBase();

		this.attaque = pokedex.getAttaqueBase();
		this.vitesse = pokedex.getVitesseBase();
		this.defense = pokedex.getVitesseBase();
		this.niveau = 1;
		this.dresseur = dresseur;
		this.expRequis = 100;
		this.exp = 0;
		this.pokedex = pokedex;
		this.equipe = equipe;
		this.moveSet = moveSet;

		for (int i = 1; i < niveau; i++) {
			gainNiveau();
		}
		this.pv = this.pvMax;
	}

	public Pokemon(Integer id, String genre, int pvMax, int pv, int attaque, int vitesse, int defense, int niveau,
			int expRequis, int exp, Pokedex pokedex, boolean equipe, Dresseur dresseur) {
		this.id = id;
		this.genre = genre;
		this.pvMax = pvMax;
		this.pv = pv;
		this.attaque = attaque;
		this.vitesse = vitesse;
		this.defense = defense;
		this.niveau = niveau;
		this.expRequis = expRequis;
		this.exp = exp;
		this.pokedex = pokedex;
		this.equipe = equipe;
		this.dresseur = dresseur;

	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public int getExpRequis() {
		return expRequis;
	}

	public void setExpRequis(int expRequis) {
		this.expRequis = expRequis;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPvMax() {
		return pvMax;
	}

	public void setPvMax(int pvMax) {
		this.pvMax = pvMax;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public Pokedex getPokedex() {
		return pokedex;
	}

	public void setPokedex(Pokedex pokedex) {
		this.pokedex = pokedex;
	}

	public boolean isEquipe() {
		return equipe;
	}

	public void setEquipe(boolean equipe) {
		this.equipe = equipe;
	}

	public Dresseur getDresseur() {
		return dresseur;
	}

	public void setDresseur(Dresseur dresseur) {
		this.dresseur = dresseur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int degats(Attaque att, Pokemon adversaire, double coefType) {
		List<Type> types = this.getPokedex().getType().stream().collect(Collectors.toList());
		double cm = (att.getType().equals(types.get(0)) || att.getType().equals(types.get(1))) ? 1.5 : 1;
		cm *= coefType;
		double coefAttaquant = niveau * 0.4 + 2;
		double coefDegats = attaque * att.getDegats();
		double coefDefense = (adversaire.defense * 50);

		double degats = (((coefAttaquant * coefDegats) / coefDefense) + 2) * cm;

		return (int) degats;
	}

	public void subirDegats(int degats) {
		this.pv -= degats;
		if (this.pv < 0) {
			this.pv = 0;
		}
	}

	public void recevoirSoins(int soins) {
		this.pv += soins;
		if (this.pv > this.pvMax) {
			this.pv = this.pvMax;
		}
	}

	public boolean capture(Ball ball) {

		Random r = new Random();
		int aleaInt = r.nextInt(2);
		double alea = (aleaInt == 0) ? 1.10 : 0.9;

		double tauxPv = (1 - ((2.0 / 3.0) * (pv / pvMax)));

		double txLvl = 1.35 + ((100.0 - niveau) / 100.0) / 2.0;

		return (tauxPv * pokedex.getTauxCapture() * ball.getTaux() * alea * txLvl >= 255) ? true : false;
	}

	public String gainExperience(int pokemonVivants, Pokemon adversaire, boolean capture) {
		String text = "";
		double a = (capture == true) ? 1.5 : 1;
		int b = 800;
		double gain = (a * b * adversaire.niveau) / (7 * pokemonVivants);
		this.exp += gain;
		while (this.exp > this.expRequis) {
			this.exp -= this.expRequis;
			text += gainNiveau();
		}

		text += "\n" + exp + "  experience sur " + expRequis;
		return text;
	}

	private String gainNiveau() {
		this.niveau++;
		this.expRequis = (int) (1.2 * Math.pow(niveau, 3) - 15 * Math.pow(niveau, 2) + 100 * niveau - 140);
		this.pvMax += 2 + niveau / 45;
		this.attaque += 1 + niveau / 45;
		this.defense += 1 + niveau / 45;
		this.vitesse += 1 + niveau / 45;
		return "\n" + pokedex.getNom() + " passe au niveau " + niveau;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return Objects.equals(id, other.id);
	}

}
