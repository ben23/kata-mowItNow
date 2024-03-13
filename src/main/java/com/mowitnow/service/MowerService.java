package com.mowitnow.service;


import com.mowitnow.exception.InvalidPositionException;
import com.mowitnow.exception.LawnLineNotFoundException;
import com.mowitnow.model.Direction;
import com.mowitnow.model.Lawn;
import com.mowitnow.model.Mower;
import com.mowitnow.model.Position;
import com.mowitnow.util.CommandUtil;
import com.mowitnow.util.DirectionUtil;
import com.mowitnow.util.LawnUtil;
import com.mowitnow.util.PositionUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MowerService {

    private static final String SPACE = " ";
    private static final Logger LOGGER = Logger.getLogger(MowerService.class.getName());

    private List<Mower> mowers;

    public MowerService(File file) throws FileNotFoundException {
        run(file);
    }

    public List<Mower> getMowers() {
        return mowers;
    }

    private void run(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            mowers = new ArrayList<>();
            Position position = null;
            Direction direction = null;
            int lineNumber = 1;

            Lawn lawn = extractLawn(scanner);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (lineNumber % 2 == 1) {
                    String[] values = line.split(SPACE);
                    position = extractPosition(values, lawn);
                    direction = DirectionUtil.convert(values[2]);
                } else {
                    Mower mower = new Mower(lawn, position, direction);
                    mower.apply(CommandUtil.convert(line));
                    mowers.add(mower);
                }
                lineNumber++;
            }

            mowers.forEach(mower -> LOGGER.log(Level.INFO,
                    String.format("Position %d %d %s%n", mower.getPosition().x(),
                            mower.getPosition().y(), mower.getDirection())));
        }
    }

    private Position extractPosition(String[] values, Lawn lawn) {
        Position position = PositionUtil.convert(values);
        if (!position.isValidPosition(lawn)) {
            throw new InvalidPositionException("Invalid Position Data");
        }
        return position;
    }

    private Lawn extractLawn(Scanner scanner) {
        if (!scanner.hasNextLine()) {
            throw new LawnLineNotFoundException("Lawn line is empty");
        }
        return LawnUtil.convert(scanner.nextLine());
    }
}
