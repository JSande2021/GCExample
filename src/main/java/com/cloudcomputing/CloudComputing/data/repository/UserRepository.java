package com.cloudcomputing.CloudComputing.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cloudcomputing.CloudComputing.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {


}
