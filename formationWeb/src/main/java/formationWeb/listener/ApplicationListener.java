package formationWeb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import quest.config.QuestConfig;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public ApplicationListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		((AnnotationConfigApplicationContext) sce.getServletContext().getAttribute("ctxSpring")).close();
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("ctxSpring", new AnnotationConfigApplicationContext(QuestConfig.class));

	}

}
