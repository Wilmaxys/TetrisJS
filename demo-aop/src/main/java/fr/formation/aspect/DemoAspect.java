package fr.formation.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAspect {
	@Before("@annotation(fr.formation.annotation.DemoTx)")
	public void beforeDemo() {
		System.out.println("BEFORE DEMO");
	}
	
	@After("@annotation(fr.formation.annotation.DemoTx)")
	public void afterDemo() {
		System.out.println("AFTER DEMO");
	}
}