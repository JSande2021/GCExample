package com.cloudcomputing.CloudComputing.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger("LoginController");
	
    @Autowired
    ItemBusinessService service;

    @GetMapping("/")
	public String HomeController(Model model) {		
		logger.info("home for HomeController");
		//Add the login model for the login form in the navbar
		model.addAttribute("loginModel", new LoginModel());
		
		return "main";
	}

    @GetMapping("/about")
	public String AboutPage(Model model) {
		logger.info("about for HomeController");
		//sets message
		model.addAttribute("message", "About Pokemon Card Book");
		
		//Add the login model for the login form in the navbar
		model.addAttribute("loginModel", new LoginModel());
		
		return "about";

	}	


    @GetMapping("/index")
	public String index(Model model) 
	{
		logger.info("index for HomeController");
		//Add the login model for the login form in the navbar
		model.addAttribute("loginModel", new LoginModel());
				
		model.addAttribute("message", "Item Index");
		model.addAttribute("Items", service.getItems());
		return "index";
	}

}
