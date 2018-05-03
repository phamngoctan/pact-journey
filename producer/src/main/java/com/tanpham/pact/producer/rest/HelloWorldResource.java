package com.tanpham.pact.producer.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tanpham.pact.producer.model.GreetingRequest;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

	@GET
	public String helloWorld(GreetingRequest greetingRequest) {
		return "Hello, world!";
	}
	
}
