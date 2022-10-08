package com.cloudcomputing.CloudComputing.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cloudcomputing.CloudComputing.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

}
