package com.cloudcomputing.CloudComputing.controller;

import java.util.Optional;
import javax.validation.Valid;
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

    @Autowired
    ItemBusinessService service;

    @GetMapping("/myItems")
    public String index(Model model){
        model.addAttribute("Items", service.getItems());
        //Adds the model for the create item modal to use when validating data
		model.addAttribute("Item", new Item()); 
		//Add the login model for the login form in the navbar
		model.addAttribute("loginModel", new LoginModel());
        return "myItems";
    }

    @GetMapping("/myItems/newItem")
	public String showNewItemForm(Model model) {
		Item Item = new Item();
		model.addAttribute("Item", Item);
		return "newItem";
	}


    @GetMapping("/myItems/item/{id}")
    public Optional<Item> show(@PathVariable String id){
        return service.findById(id);
    }

    // @PostMapping("/item/search")
    // public List<Item> search(@RequestBody String search){
    //     return itemRepository.findByName(search);
    // }

    @PostMapping("/myItems/saveItem")
    public String create(@Valid Item Item, BindingResult bindingResult, Model model, @ModelAttribute(value="name") String name, 
    @ModelAttribute(value="price") String price, @ModelAttribute(value="description") String description)
    {
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
            return "myItems";
    }


    @PostMapping("/myItems/updateItem/{id}")
	public String updateItem(@PathVariable(value="id") String id,Item Item, 
			Model model) {
		service.update(Item);
        model.addAttribute("Items", service.getItems());
		return "redirect:/myItems";
	}
	

    // @DeleteMapping("/myItems/delete{id}")
    // public String delete(@PathVariable String id){
    //     service.delete(id);
    //     return "redirect:/myItems";
    // }

    @PostMapping(value="/myItems/delete{id}")
	public String delete(@RequestParam String id) {
		service.delete(id);
		return "redirect:/myItems";
	}


    @PostMapping(value="/myItems/edit{id}")
	public String showUpdateForm(
			@RequestParam String id, Model model) {
		model.addAttribute("Item", service.findById(id));

		return "editItem";
	}
}
