package beans;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// quand on appel la methode performe pour un musicien il faut faire des actions 
@Component
@Aspect  //pour dire ca c'est un aspect les methode s'execute aautour d'une autre
public class Spectateur {

	@Pointcut("execution(void beans.Guitariste.performer())")
	public void pointcutGuitariste() {}
	
	
	
	@Before("pointcutGuitariste()")
	public void instaler() {
		System.out.println("les spectateurs sont assis");
	}
	 
	
	@AfterReturning(pointcut="pointcutGuitariste()") // on precise pas returning car la methode est void
	public void applaudir()
	{	
	System.out.println("les specateurs applaudissent");
}
	
	
	@AfterThrowing(pointcut="pointcutGuitariste()")
	public void huer() {
		System.out.println("houuuuuu");
	}
	
	
	
	@After("pointcutGuitariste()")
	public void partir() {
		System.out.println("le public est parti");
	}
	
	
}