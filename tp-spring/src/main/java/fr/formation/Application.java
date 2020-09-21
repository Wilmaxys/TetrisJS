package fr.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.musique.IMusicien;

public class Application {
	public static void main(String[] args) {
		//CHARGER LE CONTEXT DE SPRING
//		ClassPathXmlApplicationContext myContext =
//				new ClassPathXmlApplicationContext("classpath:/application-context.xml");
		
		AnnotationConfigApplicationContext myContext =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		//RECUPERER LE MUSICIEN
		IMusicien myMusicien = myContext.getBean("unSuperGuitariste", IMusicien.class);
		myMusicien.jouer();
		
		myContext.close();
	}
}