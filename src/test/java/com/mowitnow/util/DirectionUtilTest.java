package com.mowitnow.util;

import com.mowitnow.exception.InvalidDirectionException;
import com.mowitnow.model.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DirectionUtilTest {


    @Test
    void should_convert_valid_value_E() {
        //Given
        String value = "E";

        //When
        Direction direction = DirectionUtil.convert(value);

        //Then
        Assertions.assertEquals(Direction.E, direction);
    }

    @Test
    void should_convert_valid_value_N() {
        //Given
        String value = "N";

        //When
        Direction direction = DirectionUtil.convert(value);

        //Then
        Assertions.assertEquals(Direction.N, direction);
    }

    @Test
    void should_convert_valid_value_W() {
        //Given
        String value = "W";

        //When
        Direction direction = DirectionUtil.convert(value);

        //Then
        Assertions.assertEquals(Direction.W, direction);
    }

    @Test
    void should_convert_valid_value_S() {
        //Given
        String value = "S";

        //When
        Direction direction = DirectionUtil.convert(value);

        //Then
        Assertions.assertEquals(Direction.S, direction);
    }

    @Test
    void should_convert_invalid_value() {
        //Given
        String value = "T";

        //When
        InvalidDirectionException thrown = Assertions.assertThrows(InvalidDirectionException.class, () -> DirectionUtil.convert(value));

        //Then
        Assertions.assertEquals("Invalid Direction", thrown.getMessage());
    }

}
