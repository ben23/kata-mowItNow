package com.mowitnow.util;

import com.mowitnow.exception.InvalidPositionException;
import com.mowitnow.exception.PositionDataNotFoundException;
import com.mowitnow.model.Lawn;
import com.mowitnow.model.Position;

public class PositionUtil {

    private PositionUtil() {
    }

    public static Position convert(String[] values) {
        Position position;
        if (values == null || values.length != 3) {
            throw new PositionDataNotFoundException("Position data is empty or incomplete");
        }
        try {
            position = new Position(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
        } catch (NumberFormatException e) {
            throw new InvalidPositionException("Invalid Position Data");
        }
        return position;
    }
}
