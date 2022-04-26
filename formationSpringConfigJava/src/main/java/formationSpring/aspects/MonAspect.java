package formationSpring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MonAspect {

	@Pointcut("execution(String formationSpring.beans.*.methodePourAspect())")
	public void pointcutMethodePourAspect() {

	}

	@Pointcut("execution(void formationSpring.beans.Personne.getAdresse())")
	public void pointcutGetAdresse() {

	}

	@Before("pointcutMethodePourAspect()")
	public void before() {
		System.out.println("before");
	}

	@After("pointcutMethodePourAspect()")
	public void after() {
		System.out.println("after");
	}

	@AfterReturning(pointcut = "pointcutMethodePourAspect()", returning = "returning")
	public void afterReturning(String returning) {
		System.out.println("valeur renvoye par la methode intercepte:" + returning);
	}

	@AfterThrowing(pointcut = "pointcutMethodePourAspect()")
	public void afterThrowing() {
		System.out.println("exception pendant le traitment");
	}

	@Around("pointcutMethodePourAspect()")
	public String around(ProceedingJoinPoint pJP) throws Throwable {
		// execution de la methode interceptee
		System.out.println("dans around avant execution");
		// String retour = (String) pJP.proceed();

		System.out.println("dans around apres execution avant return");
		return "fake string";
	}

	// @Before avant une methode
	// @AfterReturning apres une methode qui a fonctionné
	// @AfterThrowing apres une methode qui declenchée une exception
	// @After apres une methode apres AfterReturning ou AfterThrowing
	// @Around
}
