package com.tns.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class CustomerControllerTest {
	
	@MockBean	
	private CustomerService service;

	@MockBean	
private	CustomerRepository repo;
	
	
	@Test
public void getNegativeIdTest() {
		// arrange
	int  id = -1;
	CustomerController customerController = new CustomerController();
	ResponseEntity<?> resultObject = customerController.get(id);	

assertEquals("No customer with id " + id, resultObject.getBody());
}


	
@BeforeEach
void setup() {
	int  id = 1;
	Optional<Customer> customer = Optional.of(new Customer(-1,"mohan","4545","63803932","mohan@gmail.com"));
	Customer customer2 = new Customer(-1,"mohan","4545","63803932","mohan@gmail.com");
	Mockito.when(service.get(id)).thenReturn(customer2);
	Mockito.when(repo.findById(id)).thenReturn(customer);
	
}

@Test	
	public void getPostiveIdTest() {
		// arrange
	int id =1;
	CustomerController customerController = new CustomerController();
	try {
		ResponseEntity<?> resultObject = customerController.get(id);	
		int ii = 8;

	} catch (Exception e) {
		Object object = e;
		// TODO: handle exception
	}

// assertEquals(resultObject.getBody()+   "No customer with id " + id, resultObject.getBody());
}
	

	
	
}
