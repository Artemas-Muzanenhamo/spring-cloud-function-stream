package com.artemas.simplefunction;

import java.util.function.Function;

public class Functions {
    Function<String, String> uppercase() {
        return String::toUpperCase;
    }

    Function<String, String> reverse() {
        return message -> new StringBuilder(message).reverse().toString();
    }
}