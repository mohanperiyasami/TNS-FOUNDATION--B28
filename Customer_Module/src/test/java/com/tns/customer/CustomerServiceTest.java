package com.tns.customer;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class CustomerServiceTest {
	@Autowired
	private CustomerService service;
@Test
	public void getTest() {
	//	CustomerService service = new CustomerService();
		int id = -1;
		Customer result=service.get(id);
		
		assertEquals(result, service.get(id));
	}


}
