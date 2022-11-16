package com.cloudcomputing.CloudComputing.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.cloudcomputing.CloudComputing.model.User;
import com.cloudcomputing.CloudComputing.service.ItemBusinessService;
import com.cloudcomputing.CloudComputing.service.UserBusinessService;

@Controller
@RequestMapping("")
public class LoginController {

	private static final Logger logger = LogManager.getLogger("LoginController");
	
	@Autowired 
    ItemBusinessService itemService;

	@Autowired
	UserBusinessService userService;
	
	/*
	 * Gets /login mapping and returns the login template with specified model and title
	 */
	@GetMapping("/login")
	public String display(Model model) {
		logger.info("Logging in for LoginController");
		//creates new login model
		model.addAttribute("user", new User());
		return "login";
	}	
	
	@PostMapping("/myItems")
	public String doLogin(@Valid User User, BindingResult bindingResult, Model model,
			 @ModelAttribute(value="userName") String username,
			@ModelAttribute(value="userPassword") String password)
	{
		//Check for validation errors
		if(bindingResult.hasErrors()) 
		{
			logger.info("Failed Logging in for LoginController");
			model.addAttribute("title", "Login unsuccessful, please reinsert your data according to the errors displayed in the login dropdown or create a new account");
			return "login";
		}
		logger.info("Successfully Logging in for LoginController");
		//Check if the username/password combination is not in the database (which means that the login is invalid)
		// if(!security.authenticate(username, password))
		// {
		// 	//model.addAttribute("title", "Username or password is incorrect, please enter a valid username or password.");
		// 	return "login";
		// }
		
		//Display the New User Homepage View
		model.addAttribute("title", "User Authenticated");
		
		//Add the login model for the login form in the navbar
		model.addAttribute("user", new User());
		model.addAttribute("Items", itemService.getItems());
		//Adds the new user to the database
		//userService.createUser(username, password);
		logger.info("Finishing Logging in for LoginController");
		//Navigate back to the Main View
		return "myItems";
	}

}
