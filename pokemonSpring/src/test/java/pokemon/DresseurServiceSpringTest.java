package pokemon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import pokemon.config.PokemonConfig;
import pokemon.entity.Dresseur;
import pokemon.exceptions.DresseurException;
import pokemon.services.DresseurService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { PokemonConfig.class })
@Transactional
@Rollback
class DresseurServiceSpringTest {

	@Autowired
	DresseurService dresseurService;

	@Test
	// @Commit
	@Disabled
	void insertDresseurTest() {
		Dresseur dresseur = new Dresseur();
		dresseur.setNom("test");
		dresseurService.create(dresseur);
		assertNotNull(dresseur.getId());
		assertNotNull(dresseurService.getById(dresseur.getId()));
	}

	@Test
	void findDresseur() {
		assertThrows(DresseurException.class, () -> {
			dresseurService.getById(99999);
		});
	}

}
