package com.artemas.simplefunction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class CloudFunctions {

    @Bean
    Function<String, String> uppercase() {
        return String::toUpperCase;
    }

    @Bean
    Function<Message, String> reverseWithMessage() {
        return message -> new StringBuilder(message.content()).reverse().toString();
    }
}