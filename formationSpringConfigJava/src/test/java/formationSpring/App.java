package formationSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import formationSpring.beans.IPersonne;
import formationSpring.beans.Personne;
import formationSpring.config.AppConfig;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println(ctx);

		// Personne personne=new Personne();
		IPersonne personne = ctx.getBean("personne", IPersonne.class);
		System.out.println(personne.getAdresse());
		
		ctx.close();
	}

}
