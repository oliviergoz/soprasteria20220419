package formation.soprasteria.formationSpringBoot.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ConsoleService implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleService.class);

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello world");
		LOGGER.trace("trace");
		LOGGER.debug("debug");
		LOGGER.info("info");
		LOGGER.warn("warning");
		LOGGER.error("error");
	}
	//1-TRACE
	//2-DEBUG
	//3-INFO
	//4-WARNING
	//5-ERROR
	//6-FATAL
	
	
	//OFF
	

}
