package com.cloudcomputing.CloudComputing.controller;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.cloudcomputing.CloudComputing.model.LoginModel;
import com.cloudcomputing.CloudComputing.model.User;
import com.cloudcomputing.CloudComputing.service.UserBusinessService;



@RestController
public class UserController {

    @Autowired
    private UserBusinessService service;

    private static final Logger logger = LogManager.getLogger("LoginController");
    
    @GetMapping("/user")
    public String index(Model model){
        logger.info("user page for UserController");
        model.addAttribute("users", service.getUsers());
        return "user";
    }

    @GetMapping(value="/login/newUser")
		public String showNewUserForm(Model model) {
			User User = new User();
            logger.info("new user registration page for UserController");
			model.addAttribute("User", User);
			return "newUser";
		}	

    @PostMapping(value = "/saveUser")
	public String saveUser(@Valid User User, BindingResult bindingResult, Model model,
    @ModelAttribute(value="userName") String userName, 
	@ModelAttribute(value="userPassword") String userPassword)
	{
        logger.info("save new user for UserController");
			//Check for validation errors
			if(bindingResult.hasErrors()) 
			{		
                logger.info("failed save new user for UserController");		
				//Adds the model for the create user modal to use when validating data
				model.addAttribute("User", new User()); 
				return "newUser";
			}
			//Display the user view with new title to indicate successful results from the create card form
			model.addAttribute("title", "New User Created Successfully");	
			//Adds the model for the create user modal to use when validating data
			model.addAttribute("User", new User()); 
			//Add the login model for the login form in the navbar
			model.addAttribute("loginModel", new LoginModel());
			//Adds user to database
			service.createUser(userName, userPassword);
            logger.info("saved new user for UserController");
			return "user";
	}	


    @GetMapping("/user/{id}")
    public Optional<User> show(@PathVariable String id){
        logger.info("search user for UserController");
        return service.findById(id);
    }

    @PutMapping("/user/{id}")
    public void update(@PathVariable String id, @RequestBody Map<String, String> body){
        // getting user
        Optional<User> user = service.findById(id);
        logger.info("update user for UserController");
        user.get().setName(body.get("name"));
        user.get().setPassword(body.get("password"));
        service.updateUser(user.get());
    }

    @DeleteMapping("user/{id}")
    public boolean delete(@PathVariable String id){
        logger.info("delete user for UserController");
        service.delete(id);
        return true;
    }

}
