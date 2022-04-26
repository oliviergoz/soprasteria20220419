package musicSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import musicSpring.beans.Musicien;


public class AppSpring {
	@Autowired
	@Qualifier("guitariste")
	private Musicien musicien;

	// ... veut dire peut avoir plusieurs paramètres ou même rien du tout
	public void run(String ...args) {
		try {
			System.out.println(musicien.performe());

		}catch(Exception e) {
			
		}
	}
}
