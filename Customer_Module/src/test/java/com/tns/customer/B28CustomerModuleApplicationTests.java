package com.tns.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class B28CustomerModuleApplicationTests {
	@Autowired
	private CustomerService service;
	
	
	
	@MockBean
	private CustomerRepository repo;
	
//	@BeforeEach
//	void setup() {
//	Optional<Customer> customer = Optional.of(new Customer(-1,"mohan","4545","63803932","mohan@gmail.com"));
//	Mockito.when(repo.findById(1)).thenReturn(customer);
//	}
	@Test
	void getCustomerById() {
		Optional<Customer> customer = Optional.of(new Customer(-1,"mohan","4545","63803932","mohan@gmail.com"));
		Mockito.when(repo.findById(1)).thenReturn(customer);
		String name= "mohan";
		Customer customer2 = service.get(1);
		assertEquals(name, customer2.getName());
	}
	@Test
	public void getCustomereList() {
		List<Customer> customers = Arrays.asList(new Customer(1,"mohan","4545","63803932","mohan@gmail.com"),
				new Customer(2,"vigneshwaar","9685","48314","vignesh@gmail.com"));
		when(repo.findAll()).thenReturn(customers);
		assertEquals(2, service.listall().size());
	}
	
	@Test
	public void saveCustomerTest() {
	
		Optional<Customer> customer = Optional.of(new Customer(1,"mohan","4545","63803932","mohan@gmail.com"));
		when(repo.findById(1)).thenReturn(customer);
		
	//assertEquals(customer, service.save(customer));
		
	}
	@Test
	public void deleteCustomer() {
		Optional<Customer> customer = Optional.of(new Customer(1,"mohan","4545","63803932","mohan@gmail.com"));

		service.delete(1);
	//	verify(repo,times(1)).delete();
		
	}
	
	
	
		
	
}
