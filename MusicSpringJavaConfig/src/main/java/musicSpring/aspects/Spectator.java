package musicSpring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import musicSpring.beans.Musicien;
import musicSpring.beans.Saxophoniste;

@Component
@Aspect
public class Spectator {
	
	@Autowired
	@Qualifier("saxophoniste")
	private Musicien m;
	
	@Pointcut("execution(String musicSpring.beans.Guitariste.performe())")
	public void pointcutG() {
		
	}
	
	@Pointcut("execution(String musicSpring.beans.Saxophoniste.performe())")
	public void pointcutS() {
		
	}
		
	@Pointcut("execution(String musicSpring.beans.Musicien.performe())")
	public void pointcutM() {
		
	}
	
	@Before("pointcutG()")
	public void before(){
		install();
		phoneOff();
	}
	
	public void install() {
		System.out.println("Spectateur s'installe");
	}
	
	public void phoneOff() {
		System.out.println("Spectateur éteind sont téléphone");
	}
	
	@AfterReturning("pointcutM()")
	public void applaudir(){
		System.out.println("Le spectateur applaudit");	
	}
	
	@AfterThrowing("pointcutM()")
	public void huer() {
		System.out.println("Le spectateur houee");
	}

	@After("pointcutG()")
	public void joueSaxo() {
		System.out.println(m.performe());
	}
	
	@After("pointcutS()")
	public void partir() {
		System.out.println("Le spectateur part");
	}
}
