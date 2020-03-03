package com.example.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.api.domain.Customer;
import com.example.api.domain.Endereco;
import com.example.api.repository.EnderecoRepository;
import com.example.api.web.rest.dto.CepsDto;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;
	
	@Autowired
	private RestTemplate client;

	public Iterable<Endereco> saveAll(Iterable<Endereco> enderecos) {
		return repository.saveAll(enderecos);
	}
	
	/**
	 * cria uma lista de Endereco, com ceps passados,<br>
	 * mas se tiver um cep errado,seta o erro no result
	 */
	public List<Endereco> createAll(Customer customer, CepsDto cepsDto, BindingResult result) {
		List<Endereco> enderecos = new ArrayList<>();
		List<String> cepsInvalidos = new ArrayList<>();
		
		for (String cep : cepsDto.getCeps()) {
			try {
				Endereco endereco = restFindByCep(cep);
				endereco.setCustomer(customer);
				enderecos.add(endereco);
			} catch (RestClientException e) {
				cepsInvalidos.add(cep);
			}
		}
		
		if(!cepsInvalidos.isEmpty()) {
			result.rejectValue("ceps", "inválido", new Object[]{"'ceps'"}, 
					cepsInvalidos+" não são um ceps válidos");
		}
		
		return enderecos;
	}
	
	public Endereco restFindByCep(String cep) {
		ResponseEntity<Endereco> responseEntity = client.exchange("https://viacep.com.br/ws/"+cep+"/json/", HttpMethod.GET, null, Endereco.class);
		return responseEntity.getBody();
	}
}
