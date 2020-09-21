package fr.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;

public class Application {
	public static void main(String[] args) {
		//CHARGER LE CONTEXT DE SPRING
//		ClassPathXmlApplicationContext myContext =
//				new ClassPathXmlApplicationContext("classpath:/application-context.xml");
		
		AnnotationConfigApplicationContext myContext =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		//RECUPERER LE MUSICIEN
//		IMusicien myMusicien = myContext.getBean("unSuperGuitariste", IMusicien.class);
//		myMusicien.jouer();
		
//		myContext.getBean(Application.class).run();
		
		myContext
			.getBeanFactory()
			.createBean(SpringApplication.class)
			.run();
		
		myContext.close();
	}
}