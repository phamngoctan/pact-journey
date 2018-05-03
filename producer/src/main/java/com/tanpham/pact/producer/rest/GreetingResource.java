package com.tanpham.pact.producer.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tanpham.pact.producer.model.GreetingRequest;
import com.tanpham.pact.producer.model.GreetingResponse;

@Path("greet")
@Produces(MediaType.APPLICATION_JSON)
public class GreetingResource {

	@POST
	public Response greet(GreetingRequest greetingRequest) {
		return Response.ok().entity(new GreetingResponse("Hello, " + greetingRequest.getName() + "!")).build();
	}
	
}
