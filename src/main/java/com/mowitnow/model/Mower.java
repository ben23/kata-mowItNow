package com.mowitnow.model;

import java.util.List;

public class Mower {

    private final Lawn lawn;
    private Position position;
    private Direction direction;


    public Mower(Lawn lawn, Position position, Direction direction) {
        this.lawn = lawn;
        this.position = position;
        this.direction = direction;
    }


    public Lawn getLawn() {
        return lawn;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void apply(List<Command> commands) {
        for (Command command : commands) {
            switch (command) {
                case G -> this.direction = this.direction.getLeft();
                case D -> this.direction = this.direction.getRight();
                case A -> move();
            }
        }
    }

    private void move() {
        switch (direction) {
            case E -> {
                if (this.position.x() < lawn.length() - 1) {
                    this.position = new Position(position.x() + 1, position.y());
                }
            }
            case W -> {
                if (this.position.x() > 0) {
                    this.position = new Position(position.x() - 1, position.y());
                }
            }
            case N -> {
                if (this.position.y() < lawn.length() - 1) {
                    this.position = new Position(position.x(), position.y() + 1);
                }
            }
            case S -> {
                if (this.position.y() > 0) {
                    this.position = new Position(position.x(), position.y() - 1);
                }
            }
        }
    }
}
