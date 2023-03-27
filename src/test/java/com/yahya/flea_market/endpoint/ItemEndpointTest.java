package com.yahya.flea_market.endpoint;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @ParameterizedTest
    @MethodSource("parameters")
    void getRequiredPriceAndName(String url) {
        var result = restTemplate.getForEntity(url, String.class);
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());

    }

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("/items/test2?minPrice=21&name=g"),
                Arguments.of("/items/test2?minPrice=-5&name=gl"),
                Arguments.of("/items/test2?minPrice=100&name=gl"),
                Arguments.of("/items/test2?minPrice=100&name=glassssssss"),
                Arguments.of("/items/test2?minPrice=10&name=gla")

        );
    }
}