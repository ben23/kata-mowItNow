package com.mowitnow.service;

import com.mowitnow.exception.InvalidPositionException;
import com.mowitnow.model.Direction;
import com.mowitnow.model.Lawn;
import com.mowitnow.model.Mower;
import com.mowitnow.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.mowitnow.model.Direction.E;
import static com.mowitnow.model.Direction.N;

class MowerServiceTest {


    @Test
    @DisplayName("Should read file and execute commands for one mower")
    void shouldReadFileAndExecuteCommandsForOneMower() throws URISyntaxException {

        //Given
        File file = getFile("test_1_mower.txt");

        //When
        MowerService mowerService;
        try {
            mowerService = new MowerService(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Then
        List<Mower> expected = List.of(new Mower(new Lawn(5, 5), new Position(1, 3), N));
        Assertions.assertEquals(expected, mowerService.getMowers());

    }

    @Test
    @DisplayName("Should read file and execute commands for two mowers")
    void shouldReadFileAndExecuteCommandsForTwoMowers() throws URISyntaxException {

        //Given
        File file = getFile("test_2_mowers.txt");

        //When
        MowerService mowerService;
        try {
            mowerService = new MowerService(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Then
        List<Mower> expected = List.of(new Mower(new Lawn(5, 5), new Position(1, 3), N),
                new Mower(new Lawn(5, 5), new Position(5, 1), E));
        Assertions.assertEquals(expected, mowerService.getMowers());
    }


    @Test
    @DisplayName("Should read file with bad lawn input")
    void shouldReadFileWithBadLawnInput() throws URISyntaxException {

        //Given
        File file = getFile("test_invalid_position.txt");

        //When
        InvalidPositionException thrown = Assertions.assertThrows(InvalidPositionException.class,
                () -> new MowerService(file));

        //Then
        Assertions.assertEquals("Invalid Position Data", thrown.getMessage());

    }
    private File getFile(String fileName) throws URISyntaxException {
        URL resource = getClass().getClassLoader().getResource(fileName);
        return new File(Objects.requireNonNull(resource).toURI());
    }
}
