package quest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import quest.entity.Compte;
import quest.entity.Evaluation;
import quest.entity.Formateur;
import quest.entity.Matiere;
import quest.entity.Module;
import quest.entity.Session;
import quest.entity.Stagiaire;
import quest.services.CompteService;
import quest.services.EvaluationService;
import quest.services.MatiereService;
import quest.services.ModuleService;
import quest.services.SessionService;

public class QuestAppSpring {


	@Autowired
	private CompteService compteService;

	@Autowired
	private EvaluationService evaluationService;
	
	@Autowired
	private MatiereService matiereService;
	
	@Autowired
	private ModuleService moduleService;
	
	@Autowired
	SessionService sessionService;

	public void init() 
	{
		Formateur f = new Formateur("Jordan","jordan", "Abid", "Jordan");
		Formateur f2 = new Formateur("Olivé","tom", "Gozlan", "Olivier");
		
		
		compteService.create(f);
		compteService.create(f2);
		
		
		Session s = new Session("I-220321-DIS-399-SOPRA-JAVA");
		
		sessionService.create(s);
		
		
		
		Matiere m1 = new Matiere("Algo avec Java");
		Matiere m2 = new Matiere("Java Objet"); 
		Matiere m3 = new Matiere("UML"); 
		Matiere m4 = new Matiere("Init Bdd et SQL"); 
		Matiere m5 = new Matiere("Maven et GIT"); 
		
		matiereService.create(m1);
		matiereService.create(m2);
		matiereService.create(m3);
		matiereService.create(m4);
		matiereService.create(m5);
		
		Module mod1 = new Module(LocalDate.parse("2022-03-21"),LocalDate.parse("2022-03-23"),m1,f,s);
		Module mod2 = new Module(LocalDate.parse("2022-03-24"),LocalDate.parse("2022-03-29"),m2,f,s);
		Module mod3 = new Module(LocalDate.parse("2022-03-30"),LocalDate.parse("2022-03-30"),m3,f,s);
		Module mod4 = new Module(LocalDate.parse("2022-03-31"),LocalDate.parse("2022-03-04"),m4,f,s);
		Module mod5 = new Module(LocalDate.parse("2022-04-19"),LocalDate.parse("2022-03-19"),m5,f2,s);
		
	
		moduleService.create(mod1);
		moduleService.create(mod2);
		moduleService.create(mod3);
		moduleService.create(mod4);
		moduleService.create(mod5);
		
		
		Stagiaire s1 = new Stagiaire("layla","layla","Adil","Layla",s);
		Stagiaire s2 = new Stagiaire("joe","joe","Alhelou","Joe",s);
		Stagiaire s3 = new Stagiaire("meg","meg","Amiot","Meggane",s);
		Stagiaire s4 = new Stagiaire("chris","tophe","Assassa","Christophe",s);
		Stagiaire s5 = new Stagiaire("benoit","benoit","Beylerian","Benoit",s);
		Stagiaire s6 = new Stagiaire("rom1","zzccmx","Cartier","Romain",s);
		Stagiaire s7 = new Stagiaire("marianne","coriandre","Ferreira","Marianne",s);
		
		compteService.create(s1);
		compteService.create(s2);
		compteService.create(s3);
		compteService.create(s4);
		compteService.create(s5);
		compteService.create(s6);
		compteService.create(s7);
		
		
		
		
		
		Evaluation e1 = new Evaluation(99,"J'aurais donné 100 s'il avait fait de la magie !" , mod1, s6);
		
		evaluationService.create(e1);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void run(String... args) {
			
	/*	String login = "Olivé";
		String password="tom";
		
		
		Compte c = compteService.seConnecter(login, password);
		
		System.out.println(c.getNom()+" "+c.getPrenom());
		
		for(Session s : sessionService.getAll()) 
		{
			System.out.println(s.getLibelle()+ "" + s.getId());
		}
		
		for(Stagiaire s : compteService.getAllStagiaires()) 
		{
			System.out.println(s.getPrenom());
		}
		
		
		for(Formateur f : compteService.getAllFormateurs()) 
		{
			System.out.println(f.getPrenom());
		}*/
	}

}
