package com.cloudcomputing.CloudComputing.controller;

import javax.validation.Valid;

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
	
	@Autowired 
    ItemBusinessService itemService;

	@Autowired
	UserBusinessService userService;
	
	/*
	 * Gets /login mapping and returns the login template with specified model and title
	 */
	@GetMapping("/login")
	public String display(Model model) {

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
			model.addAttribute("title", "Login unsuccessful, please reinsert your data according to the errors displayed in the login dropdown or create a new account");
			return "login";
		}
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
		
		//Navigate back to the Main View
		return "myItems";
	}

}
