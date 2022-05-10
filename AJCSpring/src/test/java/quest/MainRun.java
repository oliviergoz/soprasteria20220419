package quest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import quest.config.QuestConfig;

public class MainRun {

	public static void main(String[] args) {
	
		AnnotationConfigApplicationContext aca = new AnnotationConfigApplicationContext(QuestConfig.class);
		
		aca.getBeanFactory().createBean(QuestAppSpring.class).run();
		
		aca.close();
		
		
	}

}
