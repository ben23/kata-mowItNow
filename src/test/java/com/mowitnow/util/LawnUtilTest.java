package com.mowitnow.util;

import com.mowitnow.exception.InvalidLawnLineException;
import com.mowitnow.exception.LawnLineNotFoundException;
import com.mowitnow.model.Lawn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LawnUtilTest {

    @Test
    @DisplayName("Should convert Lawn line 2 7")
    void shouldConvertLawnLine27() {
        //Given
        String line = "2 7";

        //When
        Lawn Lawn = LawnUtil.convert(line);

        //Then
        Assertions.assertEquals(2, Lawn.length());
        Assertions.assertEquals(7, Lawn.height());
    }

    @Test
    @DisplayName("Should convert Lawn line null")
    void shouldConvertLawnLineNull() {
        //Given
        String line = null;

        //When
        LawnLineNotFoundException thrown = Assertions.assertThrows(LawnLineNotFoundException.class, () -> LawnUtil.convert(line));

        //Then
        Assertions.assertEquals("Lawn line is empty", thrown.getMessage());
    }

    @Test
    @DisplayName("Should convert Lawn line invalid")
    void shouldConvertLawnLineInvalid() {
        //Given
        String line = "5 null";

        //When
        InvalidLawnLineException thrown = Assertions.assertThrows(InvalidLawnLineException.class, () -> LawnUtil.convert(line));

        //Then
        Assertions.assertEquals("Invalid Filed Line", thrown.getMessage());
    }

}
