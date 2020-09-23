package fr.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.demo.Demo;

public class Application {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ctx.getBean(Demo.class).demo();
		
		ctx.close();
	}
}