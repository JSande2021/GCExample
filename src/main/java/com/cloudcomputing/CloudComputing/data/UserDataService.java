package com.cloudcomputing.CloudComputing.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cloudcomputing.CloudComputing.data.repository.UserRepository;
import com.cloudcomputing.CloudComputing.model.User;

@Service
public class UserDataService implements DataAccessInterface<User> {


    @Autowired
	private UserRepository userRepository;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplatedObject;

    /*
	 * Constructor
	 */
	public UserDataService(UserRepository userRepository, DataSource dataSource) {
		this.userRepository = userRepository;
		this.dataSource = dataSource;
		this.jdbcTemplatedObject = new JdbcTemplate(dataSource);
	}

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<User>();
		
		try {
			Iterable<User> usersIterable = userRepository.findAll();
			
			users = new ArrayList<User>();
			usersIterable.forEach(users::add);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return users;
    }

    @Override
    public Optional<User> findById(String id) {
        try {
            Long translatedId = Long.parseLong(id);
			return this.userRepository.findById(translatedId);
		}
		catch(Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
    }

    @Override
    public boolean create(User t) {
        try {
			this.userRepository.save(t);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
    }

    @Override
    public boolean update(User t) {
        try {
            Optional<User> user = userRepository.findById(t.getId());
            user.get().setName(t.getName());
            user.get().setPassword(t.getPassword());
            this.userRepository.save(user.get());
    }
        catch(Exception e) {
            e.printStackTrace();
            return false;
    }
    return true;
    }

    public void delete(String id) {
        try {

            Long translatedId = Long.parseLong(id);
			//Execute SQL Insert
			jdbcTemplatedObject.execute("DELETE FROM user WHERE ID = ?" + translatedId);
			Optional<User> eUser = this.userRepository.findById(translatedId);
			User user = eUser.get();
			userRepository.delete(user);
	    }
	    catch(Exception e) {
		    e.printStackTrace();
	    }
    }

    public boolean validate(String userName, String userPassword) {
        try
		{
			Iterable<User> users = userRepository.findAll();
			for(User user : users)
			{
				if(user.getName().compareTo(userName) == 0)
				{
					if(user.getPassword().compareTo(userPassword) == 0)
					{
						return true;
					}
					else
					{
						return false;
					}
				}
			}
			return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
            System.out.println(e);
			return false;
		}
    }
    
}
