package com.tns.customer;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
@RestController
public class CustomerController {
	
    public CustomerController() {
		
		this.service = new CustomerService();
	}
	@Autowired
	private CustomerService service;
    
	@GetMapping("/customers")
	public List<Customer> list(){
		return service.listall();
	}
//	@GetMapping("/customers/{id}")
//	public ResponseEntity<Customer> get(@PathVariable Integer id){
//	try {
//		Customer customer = service.get(id);
//		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
//	} catch (NoSuchElementException e) {
//		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
//	}	
	
	//}
	
	
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<?> get(@PathVariable Integer id){
	try {
	
		if(id <0)
		{
			return new ResponseEntity<String>("No customer with id " + id,HttpStatus.OK);
		}
		
	
		Customer customer = service.get(id);
		if(customer == null)
		{
			return new ResponseEntity<String>("No customer with id " + id,HttpStatus.OK);
			
		}
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	} catch (NoSuchElementException e) {
		return new ResponseEntity<String>("No customer with id " + id,HttpStatus.OK);
	}
	}	
	
	
	
	@PostMapping("/customers")	
	public void add(@RequestBody Customer customer) {
		service.save(customer);
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<?> update(@RequestBody Customer customer,@PathVariable Integer id){
		try
		{
			Customer existCustomer = service.get(id);
			service.save(customer);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
@DeleteMapping("/customers/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
