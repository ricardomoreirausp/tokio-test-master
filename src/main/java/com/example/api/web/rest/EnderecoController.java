package com.example.api.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.api.domain.Customer;
import com.example.api.domain.Endereco;
import com.example.api.service.CustomerService;
import com.example.api.service.EnderecoService;
import com.example.api.validacao.ErroValidacaoController;
import com.example.api.web.rest.dto.CepsDto;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ErroValidacaoController erroValidacaoController;
	
	@PostMapping
	public List<?> novos(@RequestBody CepsDto cepsDto, BindingResult result) throws Exception {
		Customer customer = customerService.findById(cepsDto.getCustomerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
		
		List<Endereco> enderecos = enderecoService.createAll(customer, cepsDto, result);
		if(result.hasErrors()) return erroValidacaoController.handle(result);
		
		return enderecos;
	}
}
