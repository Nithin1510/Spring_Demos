package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetController {
	
	@RequestMapping("/greet")
	public String greetUser(Model model) {
		// call service layer from here
		// add attribute and send to next page
		model.addAttribute("message", "Great Day");  // THIS IS THE NAME OF THE JSP PAGE NOT THE DATA
		return "success";
	}
	
	@RequestMapping("/hello")
	public String sayHello(Model model) {
		// call service layer from here
		// add attribute and send to next page
		model.addAttribute("message", "Have a great Day");
		return "success";
	}
	
	@RequestMapping("/welcome")
	public ModelAndView welcomeUser() {
		ModelAndView modelAndView = new ModelAndView("success", "message", "Welcome to MVC");
		return modelAndView;
	}
}
