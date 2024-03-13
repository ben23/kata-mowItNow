package com.mowitnow.util;

import com.mowitnow.exception.InvalidCommandException;
import com.mowitnow.model.Command;

import java.util.Arrays;
import java.util.List;


public class CommandUtil {

    private static final String EMPTY = "";

    private CommandUtil() {
    }
    public static List<Command> convert(String line) {
        try {
            return Arrays.stream(line.split(EMPTY)).map(Command::valueOf).toList();
            } catch (IllegalArgumentException e) {
                throw new InvalidCommandException("Invalid Command");
            }
    }
}
