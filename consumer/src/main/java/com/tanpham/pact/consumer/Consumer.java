package com.tanpham.pact.consumer;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public final class Consumer {
	private final WebTarget target;

    public Consumer(WebTarget target) {
        this.target = target;
    }

    public String run() {
        return target.path("/").request(MediaType.TEXT_PLAIN).get(String.class);
    }

    public static Consumer of(String uri) {
        return new Consumer(ClientBuilder.newClient().target(uri));
    }

    public static void main(String[] args) {
        final Consumer consumer = Consumer.of("http://localhost:8080");
        System.out.println(consumer.run());
    }
}
