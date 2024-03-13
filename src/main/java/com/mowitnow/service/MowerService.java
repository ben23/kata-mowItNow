package com.mowitnow.service;


import com.mowitnow.exception.InvalidPositionException;
import com.mowitnow.exception.LawnLineNotFoundException;
import com.mowitnow.model.Command;
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
import java.util.List;
import java.util.Scanner;

public class MowerService {

    private static final String SPACE = " ";

    private Mower mower;

    public MowerService(File file) throws FileNotFoundException {
        run(file);
    }

    public Mower getMower() {
        return mower;
    }

    public void run(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            Position position = null;
            Direction direction = null;

            if (!scanner.hasNextLine()) {
                throw new LawnLineNotFoundException("Lawn line is empty");
            }
            Lawn lawn = LawnUtil.convert(scanner.nextLine());

            int lineNumber = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (lineNumber % 2 == 1) {
                    String[] values = line.split(SPACE);
                    position = PositionUtil.convert(values);
                    if (!position.isValidPosition(lawn)) {
                        throw new InvalidPositionException("Invalid Position Data");
                    }
                    direction = DirectionUtil.convert(values[2]);
                } else {
                    mower = new Mower(lawn, position, direction);
                    List<Command> commands = CommandUtil.convert(line);
                    mower.apply(commands);
                    System.out.printf("Position %d %d %s%n", mower.getPosition().x(), mower.getPosition().y(), mower.getDirection());
                }
                lineNumber++;
            }
        }
    }


}
