package com.tns.orderdetails;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
@RestController
public class OrderdetailsController {
	@Autowired
	private OrderDetailsService service;
	
	@GetMapping("/orderdetails")
	public List<OrderDetails> list(){
		return service.listAll();
	}
@GetMapping("/orderdetails/{id}")
	public ResponseEntity<OrderDetails> get(@PathVariable Integer id){
		try {
			OrderDetails orderDetails=service.get(id);
			return new ResponseEntity<OrderDetails>(orderDetails, HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<OrderDetails>(HttpStatus.NOT_FOUND);
		}
	}
@PostMapping("/orderdetails")
public void add(@RequestBody OrderDetails orderDetails) {
	service.save(orderDetails);
}
	
@PutMapping("/orderdetails/{id}")
public ResponseEntity<?> update(@RequestBody OrderDetails orderDetails, @PathVariable Integer id) 
{
try
{
OrderDetails existorder = service.get(id);
service.save(orderDetails);
return new ResponseEntity<>(HttpStatus.OK);
} 
catch (NoSuchElementException e) 
{
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
} 
}
// RESTful API method for Delete operation
@DeleteMapping("/orderdetails/{id}")
public void delete(@PathVariable Integer id) 
{
service.delete(id);
}
}