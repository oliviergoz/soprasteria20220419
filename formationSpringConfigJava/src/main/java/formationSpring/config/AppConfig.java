package formationSpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import formationSpring.beans.Adresse;

@Configuration
@ComponentScan(basePackages = { "formationSpring.beans", "formationSpring.aspects" })
@EnableAspectJAutoProxy
public class AppConfig {

	@Bean("ajc")
	public Adresse ajc() {
		Adresse ajc = new Adresse();
		ajc.setAdresse("adresse AJC");
		return ajc;
	}
}
