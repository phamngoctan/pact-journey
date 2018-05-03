package com.tanpham.pact.consumer;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class JsonConsumer {
	private final WebTarget target;

	public JsonConsumer(String uri) {
		this(uri, ClientBuilder.newClient());
	}

	private JsonConsumer(String uri, Client client) {
		this(client.target(uri));
	}

	private JsonConsumer(WebTarget target) {
		this.target = target;
	}

	public String greet(String name) {
		// TODO
		// try adding a second field (e.g. gender) with a random value
		// the test now fails because we send more than specified which should
		// result in a contract change
		return target.path("/producer/api/greet").request(MediaType.APPLICATION_JSON).post(
				// entity("{ \"name\": \"" + name + "\", \"gender\": \"male\"
				// }", APPLICATION_JSON),
				Entity.entity("{ \"name\": \"" + name + "\" }", MediaType.APPLICATION_JSON), String.class);
	}
}
