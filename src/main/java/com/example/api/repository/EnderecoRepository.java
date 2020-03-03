package com.example.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.api.domain.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
	
}
