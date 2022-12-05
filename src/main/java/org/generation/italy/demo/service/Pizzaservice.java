package org.generation.italy.demo.service;

import java.util.List;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Pizzaservice {
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	public void save(Pizza pizza)
	{
		pizzaRepository.save(pizza);
	}
	
	public List<Pizza> findAll(){
		return pizzaRepository.findAll();
	}

}
