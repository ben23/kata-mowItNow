package com.mowitnow.util;

import com.mowitnow.exception.InvalidLawnLineException;
import com.mowitnow.exception.LawnLineNotFoundException;
import com.mowitnow.model.Lawn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LawnUtilTest {


    @Test
    void should_convert_Lawn_line_5_5() {
        //Given
        String line = "5 5";

        //When
        Lawn Lawn = LawnUtil.convert(line);

        //Then
        Assertions.assertEquals(6, Lawn.length());
        Assertions.assertEquals(6, Lawn.height());
    }

    @Test
    void should_convert_Lawn_line_2_7() {
        //Given
        String line = "2 7";

        //When
        Lawn Lawn = LawnUtil.convert(line);

        //Then
        Assertions.assertEquals(3, Lawn.length());
        Assertions.assertEquals(8, Lawn.height());
    }

    @Test
    void should_convert_Lawn_line_null() {
        //Given
        String line = null;

        //When
        LawnLineNotFoundException thrown = Assertions.assertThrows(LawnLineNotFoundException.class, () -> LawnUtil.convert(line));

        //Then
        Assertions.assertEquals("Lawn line is empty", thrown.getMessage());
    }

    @Test
    void should_convert_Lawn_line_invalid() {
        //Given
        String line = "5 null";

        //When
        InvalidLawnLineException thrown = Assertions.assertThrows(InvalidLawnLineException.class, () -> LawnUtil.convert(line));

        //Then
        Assertions.assertEquals("Invalid Filed Line", thrown.getMessage());
    }

}
