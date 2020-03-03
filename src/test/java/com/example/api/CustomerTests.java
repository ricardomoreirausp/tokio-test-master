package com.example.api;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.server.ResponseStatusException;

import com.example.api.domain.Customer;
import com.example.api.web.rest.CustomerController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTests {
	
	@Autowired
	private CustomerController customerController;
	
	@Test
	public void findAllPage0() {
		Page<Customer> customers = customerController.findAll(PageRequest.of(0, 1));
		assertEquals(customers.getContent().size(), 1);
	}
	
	@Test
	public void findAllPage1() {
		Page<Customer> customers = customerController.findAll(PageRequest.of(1, 1));
		assertEquals(customers.getContent().size(), 1);
	}
	
	@Test
	public void novoCustomerValido() {
		Customer customer = new Customer();
		customer.setName("Ana");
		customer.setEmail("ana@email.com");
		customer = customerController.novo(customer);
		assertNotNull(customer.getId());
	}
	
	@Test(expected=TransactionSystemException.class)
	public void novoCustomerNomeInvalido() {
		Customer customer = new Customer();
		customer.setName("");
		customer.setEmail("ana@email.com");
		customer = customerController.novo(customer);
	}
	
	@Test(expected=TransactionSystemException.class)
	public void novoCustomerEmailInvalido1() {
		Customer customer = new Customer();
		customer.setName("Ana");
		customer.setEmail("anaemail.com");
		customer = customerController.novo(customer);
	}
	
	@Test(expected=TransactionSystemException.class)
	public void novoCustomerEmailInvalido2() {
		Customer customer = new Customer();
		customer.setName("Ana");
		customer.setEmail("");
		customer = customerController.novo(customer);
	}
	
	@Test
	public void editarCustomerValido() {
		Customer customer = new Customer();
		customer.setId(100L);
		customer.setName("Ana");
		customer.setEmail("ana@email.com");
		customer = customerController.editar(customer);
		assertNotNull(customer);
	}
	
	@Test(expected=ResponseStatusException.class)
	public void editarCustomerIdInvalido() {
		Customer customer = new Customer();
		customer.setId(10000000000L);
		customer.setName("Ana");
		customer.setEmail("ana@email.com");
		customer = customerController.editar(customer);
	}
	
	@Test
	public void excluirIdValido() {
		ResponseEntity<?> responseEntity = customerController.excluir(100L);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
		
		Page<Customer> customers = customerController.findAll(PageRequest.of(0, 2));
		assertEquals(customers.getContent().size(), 2); // tinha 2, adicionei 1 e removi 1
	}
	
	@Test(expected=ResponseStatusException.class)
	public void excluirIdInvalido() {
		customerController.excluir(10000000000L);
	}
}
