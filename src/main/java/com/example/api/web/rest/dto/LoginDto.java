package com.example.api.web.rest.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginDto {

	@NotBlank(message="Nome é obrigatório")
	private String nome;
	@NotBlank(message="Senha é obrigatória")
	private String senha;

	public LoginDto() {}	
	
	public LoginDto(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	public String getNome(){
		return nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public String getSenha(){
		return senha;
	}

	public void setSenha(String senha){
		this.senha = senha;
	}

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(nome, senha);
	}
	
	@Override
	public String toString() {
		return "LoginDto [nome=" + nome + ", senha=" + senha + "]";
	}
}
