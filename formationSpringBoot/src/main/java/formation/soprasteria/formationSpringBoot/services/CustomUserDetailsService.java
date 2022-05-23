package formation.soprasteria.formationSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private CompteService compteService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return compteService.getByLogin(username);
	}

}
