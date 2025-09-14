package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.customer;
import com.example.demo.Repository.customerRepository;

@Service
public class customerService 
{
	@Autowired
	customerRepository obj;
	//display all records of customer
	public Iterable<customer> showAll()
	{
		return obj.findAll();
	}
	//Save customer records
	public customer insertdata(customer cust)
	{
		return obj.save(cust);
	}
    //Search detail of customer by bank_id
	public Optional<customer> search(int Bank_ID)
	{
		return obj.findById(Bank_ID);
	}
	public void deletedata(int Bank_ID)
	{
		obj.deleteById(Bank_ID);
	}
	
	
}

	

