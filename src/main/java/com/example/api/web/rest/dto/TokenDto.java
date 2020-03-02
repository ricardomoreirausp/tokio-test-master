package com.example.api.web.rest.dto;

public class TokenDto {

	private String token;
	private String tipo;

	public TokenDto() {}

	public TokenDto(String token, String tipo) {
		this.token = token;
		this.tipo = tipo;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "TokenDto [token=" + token + ", tipo=" + tipo + "]";
	}

}
