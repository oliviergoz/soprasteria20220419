package formationSpring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import formationSpring.beans.IPersonne;
import formationSpring.beans.Personne;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

		System.out.println(ctx);

		// Personne personne=new Personne();
		IPersonne personne = ctx.getBean("olivier", IPersonne.class);
		System.out.println(personne.getAdresse().getAdresse());
		
		ctx.close();
	}

}
