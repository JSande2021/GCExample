package com.cloudcomputing.CloudComputing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import com.cloudcomputing.CloudComputing.data.UserDataService;
import com.cloudcomputing.CloudComputing.model.User;

@Service
public class UserBusinessService implements UserBusinessServiceInterface {
    
    @Autowired
    private UserDataService service;

	public Optional<User> findById(String id) {
			return service.findById(id);
	}

	public void delete(String item) {
		service.delete(item);	
	}

	public void createUser(String name, String password) {
        try{
            service.create(new User(name, password));
        } catch(Exception e){
           System.out.println("User cound not be created");
        }
	}

	public void updateUser(@Validated User user) {
		User eUser = new User(user.getId(),user.getName(),user.getPassword());
		service.update(eUser);
	}

	public void update(User user) {
		service.update(user);
	}

    @Override
    public List<User> getUsers() {
        //get all the Users
		List<User> userEntity = service.findAll();
		//Iterate over the Users and create a list of Domain Orders
		List<User> userDomain = new ArrayList<User>();
		for(User entity : userEntity) {
			userDomain.add(new User(entity.getId(),entity.getName(), entity.getPassword()));
		}
		//Return list of Domain Users
		return userDomain;
    }
}
