package pokemon;

import pokemon.util.Context;

public class JpaTest {
	public static void main(String[] args) {
		Context.getEntityManagerFactory();
		Context.destroyEntityManagerFactory();
	}
}
