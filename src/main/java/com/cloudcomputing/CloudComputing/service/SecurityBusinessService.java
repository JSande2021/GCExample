package com.cloudcomputing.CloudComputing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudcomputing.CloudComputing.data.UserDataService;

@Service
public class SecurityBusinessService {
    
    @Autowired
    private UserDataService service;

    public boolean authenticate(String userName, String userPassword) 
	{
		if(service.validate(userName, userPassword)) 
		{
			System.out.println(String.format("Hello from the SecurityBusinessService username of %s and a password of %s",
            userName, userPassword));
			return true;
		}
		else
		{
			System.out.println("Incorrect username or password");
			return false;
		}
	}
}
