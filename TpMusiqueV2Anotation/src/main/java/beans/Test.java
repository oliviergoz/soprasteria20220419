package beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import config.AppConfig;

public class Test {

	public static void main(String[] args) {
		
AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//Guitariste x = (Guitariste) cxt.getBean("guitariste"); // spring ne boss pas avec le guitariste mais un musicien 
		
		Musicien x =cxt.getBean("guitariste",Musicien.class);
		x.performer();
//		x.getInstrument().jouer();
//		
//	
//		y.performer();
//		y.getInstrument().jouer();
		
		
	}

}
