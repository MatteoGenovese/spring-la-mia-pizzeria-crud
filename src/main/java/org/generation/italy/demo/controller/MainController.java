package org.generation.italy.demo.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.service.Pizzaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private Pizzaservice pizzaService;
	
	@GetMapping
	public String getBooks(Model model) {
		
		List<Pizza> pizzaList = pizzaService.findAll();
		model.addAttribute("pizzaList", pizzaList);
		
		return "pizza-index";
	}
	

}
