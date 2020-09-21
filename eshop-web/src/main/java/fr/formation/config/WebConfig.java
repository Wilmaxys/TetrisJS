package fr.formation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("fr.formation")
@EnableWebMvc //ACTIVE LA DELEGUATION DE REQUETE
public class WebConfig {

}