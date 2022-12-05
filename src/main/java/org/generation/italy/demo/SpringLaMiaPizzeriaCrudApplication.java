package org.generation.italy.demo;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.service.Pizzaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {
	
	@Autowired
	private Pizzaservice pizzaService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		

		Pizza p1 = new Pizza("Margherita", "Pomodoro e mozzarella", 7);
		Pizza p2 = new Pizza("Marco", "Pomodoro, burrata, pesto", 7);
		Pizza p3 = new Pizza("Prosciutto", "Pomodoro, prosciutto e mozzarella", 7);
		Pizza p4 = new Pizza("Salame", "Pomodoro, salame e mozzarella", 7);
		Pizza p5 = new Pizza("Diavola", "Pomodoro, salame piccante e mozzarella", 7);

		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
		pizzaService.save(p4);
		pizzaService.save(p5);
		
	}

}
