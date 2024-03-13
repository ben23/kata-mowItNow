package com.mowitnow.util;

import com.mowitnow.exception.InvalidDirectionException;
import com.mowitnow.model.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionUtilTest {


    @Test
    @DisplayName("Should convert valid value E")
    void shouldConvertValidValueE() {
        //Given
        String value = "E";

        //When
        Direction direction = DirectionUtil.convert(value);

        //Then
        Assertions.assertEquals(Direction.E, direction);
    }

    @Test
    @DisplayName("Should convert valid value N")
    void shouldConvertValidValueN() {
        //Given
        String value = "N";

        //When
        Direction direction = DirectionUtil.convert(value);

        //Then
        Assertions.assertEquals(Direction.N, direction);
    }

    @Test
    @DisplayName("Should convert valid value W")
    void shouldConvertValidValueW() {
        //Given
        String value = "W";

        //When
        Direction direction = DirectionUtil.convert(value);

        //Then
        Assertions.assertEquals(Direction.W, direction);
    }

    @Test
    @DisplayName("Should convert valid value S")
    void shouldConvertValidValueS() {
        //Given
        String value = "S";

        //When
        Direction direction = DirectionUtil.convert(value);

        //Then
        Assertions.assertEquals(Direction.S, direction);
    }

    @Test
    @DisplayName("Should convert invalid value")
    void shouldConvertInvalidValue() {
        //Given
        String value = "T";

        //When
        InvalidDirectionException thrown = Assertions.assertThrows(InvalidDirectionException.class, () -> DirectionUtil.convert(value));

        //Then
        Assertions.assertEquals("Invalid Direction", thrown.getMessage());
    }

}
