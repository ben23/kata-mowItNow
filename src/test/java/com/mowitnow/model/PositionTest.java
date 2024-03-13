package com.mowitnow.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PositionTest {


    @ParameterizedTest
    @MethodSource("providePositionAndValidationPositionResult")
    @DisplayName("Should invalid position when lawn is null")
    void shouldCheckValidationPosition(Position input, boolean expected) {
        //Given
        Lawn lawn = new Lawn(6, 6);


        //When
        boolean actual = input.isValidPosition(lawn);

        //Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should invalid position when lawn is null")
    void shouldInvalidWhenLawnIsNull() {
        //Given
        Lawn lawn = null;


        //When
        boolean actual = new Position(1, 1).isValidPosition(lawn);

        //Then
        Assertions.assertFalse(actual);
    }

    private static Stream<Arguments> providePositionAndValidationPositionResult() {
        return Stream.of(
                Arguments.of(new Position(-1, 0), false),
                Arguments.of(new Position(0, 0), true),
                Arguments.of(new Position(1, 0), true),
                Arguments.of(new Position(6, 0), true),
                Arguments.of(new Position(7, 0), false),
                Arguments.of(new Position(0, -1), false),
                Arguments.of(new Position(0, 0), true),
                Arguments.of(new Position(0, 1), true),
                Arguments.of(new Position(0, 6), true),
                Arguments.of(new Position(0, 7), false)
        );
    }

}
