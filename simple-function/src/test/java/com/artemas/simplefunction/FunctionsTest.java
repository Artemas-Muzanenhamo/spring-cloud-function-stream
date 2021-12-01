package com.artemas.simplefunction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionsTest {

    private final Functions functions = new Functions();

    @Test
    @DisplayName("Should return a string uppercased given a normal string")
    void upperCaseFunction() {
        final String result = functions.uppercase().apply("hello");

        assertThat(result).isEqualTo("HELLO");
    }

    @Test
    @DisplayName("Should return a string reversed given a normal string")
    void reverseStringFunction() {
        final String result = functions.reverse().apply("artemas");

        assertThat(result).isEqualTo("sametra");
    }

    @Test
    @DisplayName("Should return a string uppercased and then reversed given a normal string")
    void toUpperCaseAndThenReversed() {
        final String result = functions.uppercase().andThen(functions.reverse()).apply("takudzwa");

        assertThat(result).isEqualTo("AWZDUKAT");
    }
}