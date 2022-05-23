package formation.soprasteria.formationSpringBoot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.antMatcher("/**")
				.authorizeHttpRequests()
					.antMatchers("/formateur/**").permitAll()
					.antMatchers("/matiere/**").hasRole("ADMIN")
					.anyRequest().authenticated()
				.and()
				.formLogin();
		// @formatter:on
	}

	@Autowired
	private UserDetailsService userDetailService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// @formatter:off
//		auth.inMemoryAuthentication()
//				.withUser("admin").password("{noop}admin").roles("ADMINISTRATEUR")
//				.and()
//				.withUser("user1").password("{noop}user1").roles("USER");
		auth.userDetailsService(userDetailService);		
		// @formatter:on
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
