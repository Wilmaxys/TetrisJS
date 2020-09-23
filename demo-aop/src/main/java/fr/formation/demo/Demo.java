package fr.formation.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.formation.annotation.DemoTx;

@Component
public class Demo {
	@Autowired
	private DemoDeux demoDeux;
	
	@DemoTx
	public void demo() {
		System.out.println("DEMO");
		demoDeux.demo();
	}
}