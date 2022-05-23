package formation.soprasteria.formationSpringBoot;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import formation.soprasteria.formationSpringBoot.repositories.CompteRepository;
import formation.soprasteria.formationSpringBoot.services.MatiereService;

@SpringBootTest
public class JpaTest {

	@Autowired
	private MatiereService matiereSerivce;

	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	public void matiereServiceTest() {
		assertNotNull(matiereSerivce.getAll());
	}

	@Test
	@Transactional
	@Commit
	@Disabled
	public void initPassword() {
		compteRepository.findAll().forEach(c -> {
			c.setPassword(passwordEncoder.encode(c.getLogin()));
			compteRepository.save(c);
		});
	}
}
