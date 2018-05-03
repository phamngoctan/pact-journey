package com.tanpham.pact.consumer;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;

public class ConsumerAnnotationTest {
	@Rule
    public PactProviderRuleMk2 mockProvider =
            new PactProviderRuleMk2("My Spring Boot Provider", this);


    @Pact(consumer = "My JAX-RS Consumer")
    public RequestResponsePact createFragment(PactDslWithProvider builder) {
        return builder
                .uponReceiving("a root request").method("GET").path("/producer/api")
                .willRespondWith().status(200).body("Hello, world!")
                .toPact();
    }

    @Test
    @PactVerification
    public void runTest() throws Exception {
        final Consumer consumer = Consumer.of(mockProvider.getUrl());
        assertEquals(consumer.run(), "Hello, world!");
    }
}
