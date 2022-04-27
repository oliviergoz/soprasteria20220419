package formationJpaSpring;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import formationJpaSpring.dao.DaoFormation;
import formationJpaSpring.entity.Formateur;
import formationJpaSpring.entity.Formation;
import formationJpaSpring.repository.FormateurRepository;
import formationJpaSpring.repository.FormationRepository;
import formationJpaSpring.services.FormateurService;

public class AppSpring {

	@Autowired
	private DaoFormation daoFormation;

	@Autowired
	private FormationRepository formationRepo;

	@Autowired
	private FormateurService formateurService;

	public void run(String... args) {

		// daoFormation.findById(9999L).getNom();

//		Formation formation = new Formation();
//		formation.setNom("java");
//		formationRepo.save(formation);
//
//		Optional<Formation> opt = formationRepo.findById(formation.getId());
//		if (opt.isPresent()) {
//			System.out.println(opt.get().getNom());
//		} else {
//			System.out.println("pas de formation");
//		}

//		System.out.println(formationRepo.findById(1111L).orElse(new Formation()).getNom());
//
//		System.out.println(formationRepo.findById(formation.getId()).orElseThrow(NoResultException::new));
//
//		System.out.println(formationRepo.findById(111L).orElseThrow(() -> {
//			throw new NoResultException("pas de resultat");
//		}));

//		formationRepo.findAll(Sort.by("nom").descending()).forEach(f -> {
//			System.out.println(f.getNom());
//		});

//		List<Formation> formations = Arrays.asList(new Formation("java"), new Formation("html"),
//				new Formation("javascript"), new Formation("css"), new Formation("unix"), new Formation("scrum"));
//
//		formationRepo.saveAll(formations);
//
//		Pageable page1Avec3Elements = PageRequest.of(0, 4, Sort.by("nom").descending());
//		Page<Formation> page = formationRepo.findAll(page1Avec3Elements);
//		System.out.println(page);
//		page.get().forEach(f -> {
//			System.out.println(f.getNom());
//		});
//
//		page = formationRepo.findAll(page.nextOrLastPageable());
//		page.get().forEach(f -> {
//			System.out.println(f.getNom());
//		});
//
//		page = formationRepo.findAll(page.nextOrLastPageable());
//		page.get().forEach(f -> {
//			System.out.println(f.getNom());
//		});

		Formateur formateur = new Formateur();
		formateur.setPrenom("olivier");
		formateurService.create(formateur);

		System.out.println(formateurService.getById(formateur.getId()));

//		Formation formation = new Formation("java");
//		formation.setReferent(formateur);
//		formationRepo.save(formation);

	}
}
