package org.generation.italy.demo.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.service.Pizzaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private Pizzaservice pizzaService;
	
	@GetMapping
	public String getPizzaList(Model model) {
		
		List<Pizza> pizzaList = pizzaService.findAll();
		model.addAttribute("pizzaList", pizzaList);
		
		return "index";
	}
	
	@GetMapping("/pizza/{id}")
	public String getPizzaById(@PathVariable("id") int id, Model model)
	{
		Optional<Pizza> optPizza = pizzaService.getPizzaById(id);
		
		Pizza pizza =optPizza.get();
		
		model.addAttribute("pizza", pizza);
		
		return "show";
	}
	
	
	@GetMapping("/pizza/create")
	public String createPizza( Model model)
	{

		
		Pizza pizza = new Pizza();
		
		model.addAttribute("pizza", pizza);
		
		return "create";
	}
	
	@PostMapping("/pizza/create")
	public String storePizza(@Valid @ModelAttribute("pizza") Pizza pizza)
	{
		pizzaService.save(pizza);
		
		return "redirect:/";
	}
	
	@GetMapping("/pizza/edit/{id}")
	public String editPizza(@PathVariable("id") int id, Model model)
	{

		
		Optional<Pizza> optPizza = pizzaService.getPizzaById(id);
		
		Pizza pizza =optPizza.get();
		
		model.addAttribute("pizza", pizza);
		
		return "edit";
	}
	
	@PostMapping("/pizza/edit")
	public String updatePizza(@Valid @ModelAttribute("pizza") Pizza pizza)
	{
		pizzaService.save(pizza);
		
		return "redirect:/";
	}
	
	@GetMapping("/pizza/delete/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		
		Optional<Pizza> optPizza = pizzaService.getPizzaById(id);
		
		Pizza pizza =optPizza.get();
		
		pizzaService.delete(id);
		
		return "redirect:/";
	}
	

}
