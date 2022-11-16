package com.cloudcomputing.CloudComputing.controller;

import java.util.Optional;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.cloudcomputing.CloudComputing.model.Item;
import com.cloudcomputing.CloudComputing.model.LoginModel;
import com.cloudcomputing.CloudComputing.service.ItemBusinessService;

@Controller
@RequestMapping("/")
public class ItemController {

    private static final Logger logger = LogManager.getLogger("ItemController");

    @Autowired
    ItemBusinessService service;

    @GetMapping("/myItems")
    public String index(Model model){
        logger.info("Entering index for ItemController");
        model.addAttribute("Items", service.getItems());
        //Adds the model for the create item modal to use when validating data
		model.addAttribute("Item", new Item()); 
		//Add the login model for the login form in the navbar
		model.addAttribute("loginModel", new LoginModel());
        logger.info("Exiting index for ItemController");
        return "myItems";
    }

    @GetMapping("/myItems/newItem")
	public String showNewItemForm(Model model) {
        logger.info("Creating new item for ItemController");
		Item Item = new Item();
		model.addAttribute("Item", Item);
        logger.info("Exiting new item for ItemController");
		return "newItem";
	}


    @GetMapping("/myItems/item/{id}")
    public Optional<Item> show(@PathVariable String id){
        logger.info("Finding item for ItemController");
        return service.findById(id);
    }

    @PostMapping("/myItems/saveItem")
    public String create(@Valid Item Item, BindingResult bindingResult, Model model, @ModelAttribute(value="name") String name, 
    @ModelAttribute(value="price") String price, @ModelAttribute(value="description") String description)
    {
        logger.info("saving new item for ItemController");
        //Check for validation errors
        if(bindingResult.hasErrors()) 
        {				
            //Adds the model for the create card modal to use when validating data
            model.addAttribute("Item", new Item()); 
            return "myItems";
        }
        //Display the myItem view with new title to indicate successful results from the create Item form
        model.addAttribute("title", "New Item Created Successfully");	
        //Adds the model for the create card modal to use when validating data
        model.addAttribute("Item", new Item()); 
        //Add the login model for the login form in the navbar
        model.addAttribute("loginModel", new LoginModel());
        //Adds card to database
        service.createItem(name, price, description);
        model.addAttribute("Items", service.getItems());
        logger.info("exiting saving new item for ItemController");
            return "myItems";
    }


    @PostMapping("/myItems/updateItem/{id}")
	public String updateItem(@PathVariable(value="id") String id,Item Item, 
			Model model) {
                logger.info("Updating item for ItemController");
		service.update(Item);
        model.addAttribute("Items", service.getItems());
        logger.info("Exiting update item for ItemController");
		return "redirect:/myItems";
	}
	

    // @DeleteMapping("/myItems/delete{id}")
    // public String delete(@PathVariable String id){
    //     service.delete(id);
    //     return "redirect:/myItems";
    // }

    @PostMapping(value="/myItems/delete{id}")
	public String delete(@RequestParam String id) {
        logger.info("Deleting item for ItemController");
		service.delete(id);
		return "redirect:/myItems";
	}


    @PostMapping(value="/myItems/edit{id}")
	public String showUpdateForm(
			@RequestParam String id, Model model) {
		model.addAttribute("Item", service.findById(id));
        logger.info("Editing item for ItemController");
		return "editItem";
	}
}
