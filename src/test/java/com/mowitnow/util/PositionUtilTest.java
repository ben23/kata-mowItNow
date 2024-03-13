package com.mowitnow.util;

import com.mowitnow.exception.InvalidPositionException;
import com.mowitnow.exception.PositionDataNotFoundException;
import com.mowitnow.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionUtilTest {

    @Test
    @DisplayName("Should convert position data 1 2")
    void shouldConvertPositionData12() {
        //Given
        String[] data = {"1", "2", "E"};

        //When
        Position position = PositionUtil.convert(data);

        //Then
        Assertions.assertEquals(1, position.x());
        Assertions.assertEquals(2, position.y());
    }

    @Test
    @DisplayName("Should convert position data 3 3")
    void shouldConvertPositionData33() {
        //Given
        String[] data = {"3", "3", "T"};

        //When
        Position position = PositionUtil.convert(data);

        //Then
        Assertions.assertEquals(3, position.x());
        Assertions.assertEquals(3, position.y());
    }


    @Test
    @DisplayName("Should thrown exception position data empty")
    void shouldThrowExceptionPositionDataEmpty() {
        //Given
        String[] data = {};

        //When
        PositionDataNotFoundException thrown = Assertions.assertThrows(PositionDataNotFoundException.class, () -> PositionUtil.convert(data));

        //Then
        Assertions.assertEquals("Position data is empty or incomplete", thrown.getMessage());
    }

    @Test
    @DisplayName("Should thrown exception position data incomplete")
    void shouldThrowExceptionPositionDataIncomplete() {
        //Given
        String[] data = {"5"};

        //When
        PositionDataNotFoundException thrown = Assertions.assertThrows(PositionDataNotFoundException.class, () -> PositionUtil.convert(data));

        //Then
        Assertions.assertEquals("Position data is empty or incomplete", thrown.getMessage());
    }


    @Test
    @DisplayName("Should thrown exception position data invalid")
    void shouldThrowExceptionPositionDataInvalid() {
        //Given
        String[] data = {"2", "t", "E"};

        //When
        InvalidPositionException thrown = Assertions.assertThrows(InvalidPositionException.class, () -> PositionUtil.convert(data));

        //Then
        Assertions.assertEquals("Invalid Position Data", thrown.getMessage());
    }
}
