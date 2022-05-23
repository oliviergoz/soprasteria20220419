package formation.soprasteria.formationSpringBoot.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ConsoleService implements CommandLineRunner{

	// 1 seul, donc final
	// convention écrit tout en maj
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
	// 7 niveaux de log disponible
	// 1-TRACE
	// 2-DEBUG
	// 3-INFO -> affiche tous ce qu'il y a après, lui inclus (par défaut, peut être changer dans les properties)
	// 4-WARNING
	// 5-ERROR
	// 6-FATAL -> on gère pas, springboot les gère
	
	// OFF -> apart, pour ne plus rien afficher (sauf les FATAL)
}
