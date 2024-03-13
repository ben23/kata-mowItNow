package com.mowitnow.model;

public record Position(int x, int y) {

    public boolean isValidPosition(Lawn lawn) {
        return lawn != null
                && this.x >= 0
                && this.y >= 0
                && (this.x <= lawn.length())
                && this.y <= lawn.height();
    }
}
