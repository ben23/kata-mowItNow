package com.mowitnow.util;

import com.mowitnow.exception.InvalidPositionException;
import com.mowitnow.exception.PositionDataNotFoundException;
import com.mowitnow.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PositionUtilTest {

    @Test
    void should_convert_position_data_1_2() {
        //Given
        String[] data = {"1", "2", "E"};

        //When
        Position position = PositionUtil.convert(data);

        //Then
        Assertions.assertEquals(1, position.x());
        Assertions.assertEquals(2, position.y());
    }

    @Test
    void should_convert_position_data_3_3() {
        //Given
        String[] data = {"3", "3", "T"};

        //When
        Position position = PositionUtil.convert(data);

        //Then
        Assertions.assertEquals(3, position.x());
        Assertions.assertEquals(3, position.y());
    }


    @Test
    void should_throw_exception_position_data_empty() {
        //Given
        String[] data = {};

        //When
        PositionDataNotFoundException thrown = Assertions.assertThrows(PositionDataNotFoundException.class, () -> PositionUtil.convert(data));

        //Then
        Assertions.assertEquals("Position data is empty or incomplete", thrown.getMessage());
    }

    @Test
    void should_throw_exception_position_data_incomplete() {
        //Given
        String[] data = {"5"};

        //When
        PositionDataNotFoundException thrown = Assertions.assertThrows(PositionDataNotFoundException.class, () -> PositionUtil.convert(data));

        //Then
        Assertions.assertEquals("Position data is empty or incomplete", thrown.getMessage());
    }


    @Test
    void should_throw_exception_position_data_invalid() {
        //Given
        String[] data = {"2", "t", "E"};

        //When
        InvalidPositionException thrown = Assertions.assertThrows(InvalidPositionException.class, () -> PositionUtil.convert(data));

        //Then
        Assertions.assertEquals("Invalid Position Data", thrown.getMessage());
    }
}
