package com.example.api;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import com.example.api.web.rest.AutenticacaoController;
import com.example.api.web.rest.dto.LoginDto;
import com.example.api.web.rest.dto.TokenDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutenticacaoTests {

	@Autowired
	private AutenticacaoController autenticacaoController;
	
	@Test
	public void tokenValido() {
		try {
			TokenDto token = autenticacaoController.autenticar(new LoginDto("adm", "1234"));
			
			assertNotNull(token);
		} catch (ResponseStatusException e) {
			fail();
		}
	}
	
	@Test(expected=ResponseStatusException.class)
	public void tokenInvalidoNome() {
		autenticacaoController.autenticar(new LoginDto("xxx", "1234"));
	}
	
	@Test(expected=ResponseStatusException.class)
	public void tokenInvalidoSenha() {
		autenticacaoController.autenticar(new LoginDto("adm", "xxx"));
	}
}
