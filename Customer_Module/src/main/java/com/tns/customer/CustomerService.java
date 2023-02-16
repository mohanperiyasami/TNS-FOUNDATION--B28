package com.tns.customer;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerService {
@Autowired
	private CustomerRepository repo;
public List<Customer> listall(){
	return repo.findAll();
}
public void save(Customer customer) {
	repo.save(customer);
}
public Customer get(Integer id) {
	if(id < 0) {
		return null;
	}
	return repo.findById(id).get();
}
public void delete(Integer id) {
	repo.deleteById(id);
}
}
