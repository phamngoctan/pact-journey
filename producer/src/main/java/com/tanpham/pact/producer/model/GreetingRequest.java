package com.tanpham.pact.producer.model;

public class GreetingRequest {
	private String name;

	public GreetingRequest(String greeting) {
		this.name = greeting;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
