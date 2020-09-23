package fr.formation.demo;

import org.springframework.stereotype.Component;

import fr.formation.annotation.DemoTx;

@Component
public class DemoDeux {
	@DemoTx
	public void demo() {
		System.out.println("DEMO 2");
	}
}