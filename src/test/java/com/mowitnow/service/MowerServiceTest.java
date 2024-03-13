package com.mowitnow.service;

import com.mowitnow.exception.InvalidPositionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
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
        Assertions.assertEquals(1, mowerService.getMower().getPosition().x());
        Assertions.assertEquals(3, mowerService.getMower().getPosition().y());
        Assertions.assertEquals(N, mowerService.getMower().getDirection());

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
        Assertions.assertEquals(5, mowerService.getMower().getPosition().x());
        Assertions.assertEquals(1, mowerService.getMower().getPosition().y());
        Assertions.assertEquals(E, mowerService.getMower().getDirection());

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
