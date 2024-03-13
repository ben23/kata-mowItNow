package com.mowitnow.util;

import com.mowitnow.exception.InvalidCommandException;
import com.mowitnow.model.Command;

import java.util.ArrayList;
import java.util.List;


public class CommandUtil {

    public static final String EMPTY = "";

    private CommandUtil() {
    }

    public static List<Command> convert(String line) {
        String[] values = line.split(EMPTY);
        List<Command> commands = new ArrayList<>();
        for (String a : values) {
            try {
                commands.add(Command.valueOf(a));
            } catch (IllegalArgumentException e) {
                throw new InvalidCommandException("Invalid Command");
            }
        }
        return commands;
    }
}
