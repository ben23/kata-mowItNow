package com.mowitnow.util;

import com.mowitnow.exception.InvalidDirectionException;
import com.mowitnow.model.Direction;

public class DirectionUtil {

    private DirectionUtil() {
    }

    public static Direction convert(String value) {
        try {
            return Direction.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidDirectionException("Invalid Direction");
        }
    }
}
