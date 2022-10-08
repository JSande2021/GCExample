package com.cloudcomputing.CloudComputing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloudcomputing.CloudComputing.model.LoginModel;
import com.cloudcomputing.CloudComputing.service.ItemBusinessService;

@Controller
@RequestMapping("")
public class MainController {
    
    @Autowired
    ItemBusinessService service;

    @GetMapping("/")
	public String HomeController(Model model) {		
		
		//Add the login model for the login form in the navbar
		model.addAttribute("loginModel", new LoginModel());
		
		return "main";
	}

    @GetMapping("/about")
	public String AboutPage(Model model) {
		
		//sets message
		model.addAttribute("message", "About Pokemon Card Book");
		
		//Add the login model for the login form in the navbar
		model.addAttribute("loginModel", new LoginModel());
		
		return "about";

	}	


    @GetMapping("/index")
	public String index(Model model) 
	{
		//Add the login model for the login form in the navbar
		model.addAttribute("loginModel", new LoginModel());
				
		model.addAttribute("message", "Item Index");
		model.addAttribute("Items", service.getItems());
		return "index";
	}

}
