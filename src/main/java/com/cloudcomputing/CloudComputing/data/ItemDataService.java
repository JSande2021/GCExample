package com.cloudcomputing.CloudComputing.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.cloudcomputing.CloudComputing.data.repository.ItemRepository;
import com.cloudcomputing.CloudComputing.model.Item;

@Service
public class ItemDataService implements DataAccessInterface<Item> {

    @Autowired
	private ItemRepository itemRepository;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	// private JdbcTemplate jdbcTemplatedObject;

    	/*
	 * Constructor
	 */
	public ItemDataService(ItemRepository itemRepository, DataSource dataSource) {
		this.itemRepository = itemRepository;
		this.dataSource = dataSource;
		// this.jdbcTemplatedObject = new JdbcTemplate(dataSource);
	}


    public List<Item> findAll() {
        List<Item> items = new ArrayList<Item>();
		
		try {
			Iterable<Item> cardsIterable = itemRepository.findAll();
			
			items = new ArrayList<Item>();
			cardsIterable.forEach(items::add);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return items;
    }

    @Override
    public Optional<Item> findById(String id) {
        try {
            Long translatedId = Long.parseLong(id);
			return this.itemRepository.findById(translatedId);
		}
		catch(Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
    }

    @Override
    public boolean create(Item t) {
        try {
			this.itemRepository.save(t);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
    }

    @Override
    public boolean update(Item t) {
        try {
            Optional<Item> item = itemRepository.findById(t.getId());
            item.get().setName(t.getName());
            item.get().setPrice(t.getPrice());
            item.get().setDescription(t.getDescription());
            this.itemRepository.save(item.get());
    }
    catch(Exception e) {
        e.printStackTrace();
        return false;
    }
    return true;
    }

    public void delete(String id) {
        try {
			//Execute SQL Insert
            Long translatedId = Long.parseLong(id);
			Optional<Item> eItem = this.itemRepository.findById(translatedId);
			Item item = eItem.get();
			itemRepository.delete(item);
	    }
	    catch(Exception e) {
		    e.printStackTrace();
        }

    }
    
}
