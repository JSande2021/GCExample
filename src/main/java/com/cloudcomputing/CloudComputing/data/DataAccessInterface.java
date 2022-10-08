package com.cloudcomputing.CloudComputing.data;

import java.util.List;
import java.util.Optional;



public interface DataAccessInterface<T> {
    public List<T> findAll();
	public Optional<T> findById(String id);
	public boolean create(T t);
	public boolean update(T t);

}
