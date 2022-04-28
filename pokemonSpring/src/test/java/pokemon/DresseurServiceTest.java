package pokemon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pokemon.config.PokemonConfig;
import pokemon.entity.Dresseur;
import pokemon.services.DresseurService;

class DresseurServiceTest {

	static AnnotationConfigApplicationContext ctx;

	DresseurService dresseurService;

	@BeforeAll
	static void initCtx() {
		ctx = new AnnotationConfigApplicationContext(PokemonConfig.class);
	}

	@AfterAll
	static void closeCtx() {
		ctx.close();
	}

	@BeforeEach
	void initDresseurService() {
		dresseurService = ctx.getBean(DresseurService.class);
	}

	@Test
	void insertDresseurTest() {
		Dresseur dresseur = new Dresseur();
		dresseur.setNom("test");
		dresseurService.create(dresseur);
		assertNotNull(dresseur.getId());
		assertNotNull(dresseurService.getById(dresseur.getId()));
	}

}
