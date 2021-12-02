package com.artemas.simplefunction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

@FunctionalSpringBootTest
class CloudFunctionsTest {
    @Autowired
    private FunctionCatalog catalog;

    @Test
    void testUpperCaseThenReverseWithMessage() {
        final Message message = new Message("hello world");

        Function<String, String> function = catalog.lookup(Function.class, "uppercase|reverseWithMessage");

        assertThat(function.apply(message.content())).isEqualTo("DLROW OLLEH");
    }

    @Test
    void testUpperCaseThenReverseFlux() {
        Function<String, Flux<String>> function = catalog.lookup(Function.class, "uppercase|reverseFlux");

        StepVerifier
                .create(function.apply("hello world"))
                .expectNext("DLROW OLLEH")
                .verifyComplete();
    }
}