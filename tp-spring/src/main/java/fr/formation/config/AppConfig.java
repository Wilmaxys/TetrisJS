package fr.formation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan({ "fr.formation", "package2", "package3" })
@ComponentScan("fr.formation")
//POUR CHARGER UNE CONFIG XML
//@ImportResource("classpath:/application-context.xml")
public class AppConfig {
	//DECLARATION DES BEANS (HORS @Component, etc.)
//	@Bean
//	public IMusicien guitariste() {
//		return new Guitariste();
//	}
}