package org.generation.italy.demo.controller;

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
@RequestMapping("/pizza")
public class PizzaController {
	
	@Autowired
	private Pizzaservice pizzaService;
	
	@GetMapping
	public String getPizzaList(Model model) {
		
		List<Pizza> pizzaList = pizzaService.findAll();
		model.addAttribute("pizzaList", pizzaList);
		
		return "pizza/index";
	}
	
	@GetMapping("/{id}")
	public String getPizzaById(@PathVariable("id") int id, Model model)
	{
		Optional<Pizza> optPizza = pizzaService.getPizzaById(id);
		
		Pizza pizza =optPizza.get();
		
		model.addAttribute("pizza", pizza);
		
		return "pizza/show";
	}
	
	
	@GetMapping("/create")
	public String createPizza( Model model)
	{

		
		Pizza pizza = new Pizza();
		
		model.addAttribute("pizza", pizza);
		model.addAttribute("type", "create");
		model.addAttribute("h1text", "Create a new pizza for the list:");
		
		return "pizza/form";
	}
	
	@PostMapping("/create")
	public String storePizza(@Valid @ModelAttribute("pizza") Pizza pizza)
	{
		pizzaService.save(pizza);
		
		return "redirect:/pizza";
	}
	
	@GetMapping("/edit/{id}")
	public String editPizza(@PathVariable("id") int id, Model model)
	{

		
		Optional<Pizza> optPizza = pizzaService.getPizzaById(id);
		
		Pizza pizza =optPizza.get();
		
		model.addAttribute("pizza", pizza);
		
		model.addAttribute("type", "edit");
		model.addAttribute("h1text", "Update pizza:");
		
		
		return "pizza/form";
	}
	
	@PostMapping("/edit")
	public String updatePizza(@Valid @ModelAttribute("pizza") Pizza pizza)
	{
		pizzaService.save(pizza);
		
		return "redirect:/pizza";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		
		Optional<Pizza> optPizza = pizzaService.getPizzaById(id);
		
		Pizza pizza =optPizza.get();
		
		pizzaService.delete(id);
		
		return "redirect:/pizza";
	}
	

}
