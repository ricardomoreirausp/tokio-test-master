package com.example.api.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Customer customer;
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public Customer getCustomer(){
		return customer;
	}

	public void setCustomer(Customer customer){
		this.customer = customer;
	}

	public String getCep(){
		return cep;
	}

	public void setCep(String cep){
		this.cep = cep;
	}

	public String getLogradouro(){
		return logradouro;
	}

	public void setLogradouro(String logradouro){
		this.logradouro = logradouro;
	}

	public String getComplemento(){
		return complemento;
	}

	public void setComplemento(String complemento){
		this.complemento = complemento;
	}

	public String getBairro(){
		return bairro;
	}

	public void setBairro(String bairro){
		this.bairro = bairro;
	}

	public String getLocalidade(){
		return localidade;
	}

	public void setLocalidade(String localidade){
		this.localidade = localidade;
	}

	public String getUf(){
		return uf;
	}

	public void setUf(String uf){
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", customer=" + customer + ", cep=" + cep + ", logradouro=" + logradouro
				+ ", complemento=" + complemento + ", bairro=" + bairro + ", localidade=" + localidade + ", uf=" + uf
				+ "]";
	}
}
