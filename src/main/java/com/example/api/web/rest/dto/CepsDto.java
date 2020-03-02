package com.example.api.web.rest.dto;

import java.util.List;

public class CepsDto {
	private Long customerId;
	private List<String> ceps;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public List<String> getCeps() {
		return ceps;
	}

	public void setCeps(List<String> ceps) {
		this.ceps = ceps;
	}

	@Override
	public String toString() {
		return "CepsDto [customerId=" + customerId + ", ceps=" + ceps + "]";
	}
}
