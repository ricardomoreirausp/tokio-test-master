package com.example.api;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import com.example.api.domain.Endereco;
import com.example.api.mock.BindingResultMock;
import com.example.api.validacao.Erro;
import com.example.api.web.rest.EnderecoController;
import com.example.api.web.rest.dto.CepsDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnderecoTests {
	
	@Autowired
	private EnderecoController enderecoController;
	
	@Test
	public void novosCepsValidos() throws Exception {
		CepsDto cepsDto = new CepsDto();
		cepsDto.setCustomerId(100L);
		cepsDto.setCeps(Arrays.asList("01310940", "01311936"));
		List<?> novos = enderecoController.novos(cepsDto, new BindingResultMock());
		
		assertEquals(novos.size(), 2);
		assertEquals(novos.get(0).getClass(), Endereco.class);
	}
	
	@Test(expected=ResponseStatusException.class)
	public void novosCustomerIdInvalidos() throws Exception {
		CepsDto cepsDto = new CepsDto();
		cepsDto.setCustomerId(10000000L);
		cepsDto.setCeps(Arrays.asList("01310940", "01311936"));
		enderecoController.novos(cepsDto, new BindingResultMock());
	}
	
	@Test
	public void novosCepsInvalidos1() throws Exception {
		CepsDto cepsDto = new CepsDto();
		cepsDto.setCustomerId(100L);
		cepsDto.setCeps(Arrays.asList("01310", "01311936"));
		List<?> novos = enderecoController.novos(cepsDto, new BindingResultMock());
		System.out.println(novos);
		
		assertEquals(novos.size(), 1);
		assertEquals(novos.get(0).getClass(), Erro.class);
	}
	
	@Test
	public void novosCepsInvalidos2() throws Exception {
		CepsDto cepsDto = new CepsDto();
		cepsDto.setCustomerId(100L);
		cepsDto.setCeps(Arrays.asList("01310", "01311"));
		List<?> novos = enderecoController.novos(cepsDto, new BindingResultMock());
		System.out.println(novos);
		
		assertEquals(novos.size(), 1);
		assertEquals(novos.get(0).getClass(), Erro.class);
	}
}
