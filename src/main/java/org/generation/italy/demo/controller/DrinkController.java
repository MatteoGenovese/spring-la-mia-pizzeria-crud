package org.generation.italy.demo.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.service.Drinkservice;
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
@RequestMapping("/drinks")
public class DrinkController {
	
	@Autowired
	private Drinkservice drinkService;
	
	@GetMapping
	public String getDrinkList(Model model) {
		
		List<Drink> drinkList = drinkService.findAll();
		model.addAttribute("drinkList", drinkList);
		
		return "drink/index";
	}
	
	@GetMapping("/{id}")
	public String getDrinkById(@PathVariable("id") int id, Model model)
	{
		Optional<Drink> optDrink = drinkService.getDrinkById(id);
		
		Drink drink =optDrink.get();
		
		model.addAttribute("drink", drink);
		
		return "drink/show";
	}
	
	
	@GetMapping("/create")
	public String createDrink( Model model)
	{

		
		Drink drink = new Drink();
		
		model.addAttribute("drink", drink);
		model.addAttribute("type", "create");
		model.addAttribute("h1text", "Create a new drink for the list:");
		
		return "drink/form";
	}
	
	@PostMapping("/create")
	public String storeDrink(@Valid @ModelAttribute("drink") Drink drink)
	{
		drinkService.save(drink);
		
		return "redirect:/drinks";
	}
	
	@GetMapping("/edit/{id}")
	public String editDrink(@PathVariable("id") int id, Model model)
	{

		
		Optional<Drink> optDrink = drinkService.getDrinkById(id);
		
		Drink drink =optDrink.get();
		
		model.addAttribute("drink", drink);
		
		model.addAttribute("type", "edit");
		model.addAttribute("h1text", "Update drink:");
		
		
		return "drink/form";
	}
	
	@PostMapping("/edit")
	public String updateDrink(@Valid @ModelAttribute("drink") Drink drink)
	{
		drinkService.save(drink);
		
		return "redirect:/drinks";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		
		Optional<Drink> optDrink = drinkService.getDrinkById(id);
		
		Drink drink =optDrink.get();
		
		drinkService.delete(id);
		
		return "redirect:/drinks";
	}
	

}
