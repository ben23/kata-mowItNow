package com.mowitnow.util;

import com.mowitnow.exception.InvalidCommandException;
import com.mowitnow.model.Command;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.mowitnow.model.Command.A;
import static com.mowitnow.model.Command.G;

class CommandUtilTest {


    @Test
    void should_convert_GAGAGAGAA_from_string_to_commands() {
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
    void should_throw_exception_invalid_command() {

        //Given
        String line = "erdrr74";

        //When
        InvalidCommandException thrown = Assertions.assertThrows(InvalidCommandException.class, () -> CommandUtil.convert(line));

        //Then
        Assertions.assertEquals("Invalid Command", thrown.getMessage());

    }

}
