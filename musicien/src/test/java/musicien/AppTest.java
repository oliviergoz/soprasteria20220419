package musicien;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import musicien.beans.Musicien;

public class AppTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("application-context.xml");
		Musicien musicien=ctx.getBean("guitariste",Musicien.class);
		System.out.println(musicien);
		ctx.close();
	}
}
