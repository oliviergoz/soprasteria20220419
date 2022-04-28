package pokemon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pokemon.config.PokemonConfig;

public class AppTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PokemonConfig.class);
		ctx.getBeanFactory().createBean(PokemonAppSpring.class).run(args);
		ctx.close();

	}
}
