package com.cloudcomputing.CloudComputing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.cloudcomputing.CloudComputing.data.ItemDataService;
import com.cloudcomputing.CloudComputing.model.Item;

@Service
public class ItemBusinessService implements ItemBusinessServiceInterface {

    @Autowired
    private ItemDataService service;

    @Override
    public List<Item> getItems() {
    	//get all the Items
		List<Item> item = service.findAll();
		//Iterate over the Items and create a list of Domain Orders
		List<Item> itemDomain = new ArrayList<Item>();
		for(Item entity : item) {
			itemDomain.add(new Item(entity.getId(),entity.getName(), entity.getPrice(), entity.getDescription()));
		}
		//Return list of Domain Items
		return itemDomain;
	}

	public Optional<Item> findById(String id) {
			return service.findById(id);
	}

	

	public void delete(String item) {
		service.delete(item);	
	}

	public void createItem(String name, String price, String description) {
		// TODO Auto-generated method stub
        try{
            Double translatedPrice = Double.parseDouble(price);
            service.create(new Item(name, translatedPrice, description));
        } catch(Exception e){
            Double translatedPrice = 0.0;
            service.create(new Item(name, translatedPrice, description));
        }
	}

	public void updateItem(@Validated Item item) {
		// TODO Auto-generated method stub
		Item eItem = new Item(item.getId(),item.getName(),item.getPrice(),item.getDescription());
		service.update(eItem);
	}

	public void update(Item item) {
		service.update(item);
	}

    
}
