package com.mowitnow.model;

public record Position(int x, int y) {

    public boolean isValidPosition(Lawn lawn) {
        return lawn != null && (this.x < lawn.length() - 1) && this.y < lawn.height() - 1;
    }
}
