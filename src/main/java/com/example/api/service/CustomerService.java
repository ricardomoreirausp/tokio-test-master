package com.example.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.api.domain.Customer;
import com.example.api.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	public List<Customer> findAll() {
		return repository.findAllByOrderByNameAsc();
	}
	
	public Page<Customer> findAll(Pageable page) {
		return repository.findAllByOrderByNameAsc(page);
	}

	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}
	
	public Customer save(Customer customer) {
		return repository.save(customer);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
