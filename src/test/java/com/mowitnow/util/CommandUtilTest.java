package com.mowitnow.util;

import com.mowitnow.exception.InvalidCommandException;
import com.mowitnow.model.Command;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.mowitnow.model.Command.A;
import static com.mowitnow.model.Command.G;

class CommandUtilTest {


    @Test
    @DisplayName("Should convert GAGAGAGAA from string to commands")
    void shouldConvertGAGAGAGAAFromStringToCommands() {
        //Given
        String line = "GAGAGAGAA";

        //When
        List<Command> commands = CommandUtil.convert(line);

        //Then
        Assertions.assertEquals(G, commands.get(0));
        Assertions.assertEquals(A, commands.get(1));
        Assertions.assertEquals(G, commands.get(4));
        Assertions.assertEquals(A, commands.get(7));
    }

    @Test
    @DisplayName("Should throw exception invalid command")
    void shouldThrowExceptionInvalidCommand() {

        //Given
        String line = "erdrr74";

        //When
        InvalidCommandException thrown = Assertions.assertThrows(InvalidCommandException.class, () -> CommandUtil.convert(line));

        //Then
        Assertions.assertEquals("Invalid Command", thrown.getMessage());

    }

}
