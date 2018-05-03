package com.tanpham.pact.consumer;

import static au.com.dius.pact.consumer.ConsumerPactRunnerKt.runConsumerTest;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import au.com.dius.pact.consumer.ConsumerPactBuilder;
import au.com.dius.pact.consumer.PactVerificationResult;
import au.com.dius.pact.model.MockProviderConfig;
import au.com.dius.pact.model.RequestResponsePact;

public class ConsumerDslTest {
	
	@Test
    public void runTest() throws Exception {
        RequestResponsePact pact = ConsumerPactBuilder
                .consumer("My JAX-RS Consumer")
                .hasPactWith("My Spring Boot Provider")
                .uponReceiving("a root request")
                    .method("GET")
                    .path("/")
                .willRespondWith()
                    .status(200)
                    .body("Hello, world!")
                .toPact();
        PactVerificationResult result = runConsumerTest(
            pact,
            MockProviderConfig.createDefault(),
            mockServer -> {
                final Consumer consumer = Consumer.of(mockServer.getUrl());
                assertEquals(consumer.run(), "Hello, world!");
            }
        );
        assertEquals(PactVerificationResult.Ok.INSTANCE, result);
    }
	
}
