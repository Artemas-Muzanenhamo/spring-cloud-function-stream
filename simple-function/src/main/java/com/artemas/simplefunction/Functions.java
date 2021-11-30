package com.artemas.simplefunction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class Functions {
    private static final Logger LOGGER = LoggerFactory.getLogger(Functions.class);

    Function<String, String> uppercase() {
        return message -> {
            LOGGER.info("CONVERTING STRING");
            return message.toUpperCase();
        };
    }

    Function<String, String> reverse() {
        return message -> new StringBuilder(message).reverse().toString();
    }
}