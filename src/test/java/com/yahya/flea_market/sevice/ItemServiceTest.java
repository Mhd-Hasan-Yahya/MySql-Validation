package com.yahya.flea_market.sevice;

import com.yahya.flea_market.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;
import java.security.CodeSigner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @ParameterizedTest
    @MethodSource("input")
    void saveItem(Item item) {
        assertThrows(ConstraintViolationException.class, () -> itemService.saveItem(item));
    }

    static Stream<Arguments> input(){
        return Stream.of(
                Arguments.of(new Item(1,"", 12)),
                Arguments.of(new Item(1,"Hasan", 12)),
                Arguments.of(new Item(1,"Hasan", -5)),
                Arguments.of(new Item(1,"Hasan", 81))
        );
    }
}