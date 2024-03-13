package com.mowitnow.util;

import com.mowitnow.exception.InvalidLawnLineException;
import com.mowitnow.exception.LawnLineNotFoundException;
import com.mowitnow.model.Lawn;

public class LawnUtil {

    private static final String SPACE = " ";

    private LawnUtil() {

    }

    public static Lawn convert(String line) {
        if (line == null || line.isEmpty()) {
            throw new LawnLineNotFoundException("Lawn line is empty");
        }
        String[] values = line.split(SPACE);
        try {
            return new Lawn(Integer.parseInt(values[0]) + 1, Integer.parseInt(values[1]) + 1);
        } catch (NumberFormatException e) {
            throw new InvalidLawnLineException("Invalid Filed Line");
        }
    }

}
