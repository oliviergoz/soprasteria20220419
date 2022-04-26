package formationJpaSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import formationJpaSpring.config.AppConfig;

public class AppTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		ctx.close();
	}
}
