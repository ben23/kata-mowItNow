package com.mowitnow.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.mowitnow.model.Direction.E;

class MowerTest {

    @Test
    @DisplayName("Should initiate lawn with h5 and l5")
    void shouldInitiateLawnWithH5AndL5() {
        //Given
        Mower mower;
        Lawn lawn = new Lawn(6, 6);


        //When
        mower = new Mower(lawn, null, null);

        //Then
        Assertions.assertEquals(6, mower.getLawn().length());
        Assertions.assertEquals(6, mower.getLawn().height());

    }

    @Test
    @DisplayName("Should initiate position 1 2 N given lawn 5 5")
    void shouldInitiatePosition1_2NGivenLawn55() {
        //Given
        Position position = new Position(1, 2);
        Direction direction = Direction.N;
        Mower mower;

        //When
        mower = new Mower(null, position, direction);

        //Then
        Assertions.assertEquals(1, mower.getPosition().x());
        Assertions.assertEquals(2, mower.getPosition().y());
        Assertions.assertEquals(Direction.N, mower.getDirection());

    }

    @Test
    @DisplayName("Should move mower following GAGAGAGAA")
    void shouldMoveMowerFollowingGAGAGAGAA() {
        //Given
        Mower mower;
        Lawn lawn = new Lawn(6, 6);
        Position position = new Position(1, 2);
        Direction direction = Direction.N;
        mower = new Mower(lawn, position, direction);
        List<Command> commands = new ArrayList<>();
        commands.add(Command.G);
        commands.add(Command.A);
        commands.add(Command.G);
        commands.add(Command.A);
        commands.add(Command.G);
        commands.add(Command.A);
        commands.add(Command.G);
        commands.add(Command.A);
        commands.add(Command.A);

        //When
        mower.apply(commands);

        //Then
        Assertions.assertEquals(1, mower.getPosition().x());
        Assertions.assertEquals(3, mower.getPosition().y());
        Assertions.assertEquals(Direction.N, mower.getDirection());

    }

    @Test
    @DisplayName("Should should initiate position 3 3 E given lawn 5 5")
    void shouldInitiatePosition33EGivenLawn55() {
        //Given
        Position position = new Position(3, 3);
        Mower mower;

        //When
        mower = new Mower(null, position, E);

        //Then
        Assertions.assertEquals(3, mower.getPosition().x());
        Assertions.assertEquals(3, mower.getPosition().y());
        Assertions.assertEquals(E, mower.getDirection());

    }


    @Test
    @DisplayName("Should move mower following AADAADADDA")
    void shouldMoveMowerFollowingAADAADADDA() {
        //Given
        Mower mower;
        Lawn lawn = new Lawn(6, 6);
        Position position = new Position(3, 3);
        mower = new Mower(lawn, position, E);
        List<Command> commands = new ArrayList<>();
        commands.add(Command.A);
        commands.add(Command.A);
        commands.add(Command.D);
        commands.add(Command.A);
        commands.add(Command.A);
        commands.add(Command.D);
        commands.add(Command.A);
        commands.add(Command.D);
        commands.add(Command.D);
        commands.add(Command.A);

        //When
        mower.apply(commands);

        //Then
        Assertions.assertEquals(5, mower.getPosition().x());
        Assertions.assertEquals(1, mower.getPosition().y());
        Assertions.assertEquals(E, mower.getDirection());

    }
}
