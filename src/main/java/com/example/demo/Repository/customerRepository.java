package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.customer;

@Repository
public interface customerRepository  extends CrudRepository<customer, Integer> {

}



