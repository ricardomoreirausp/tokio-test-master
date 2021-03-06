package com.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableSpringDataWebSupport
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		System.out.println("http://localhost:8080/customers?page=1&size=1");
		
		//(100, 'Mariazinha', 'mariazinha@email.com'),
		//(200, 'Joãozinho', 'joaozinho@email.com');
		System.out.println("testes ok, o arquivo data foi alterado por conta da tabela de is do hibernate ");
		System.out.println("validação ok");
		System.out.println("frontend não deu tempo");
		System.out.println("autenticação ok, post na url http://localhost:8080/autenticacao {\"nome\":\"adm\", \"senha\":\"1234\"}");
		System.out.println("documentação ok, na url http://localhost:8080/doc");
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
