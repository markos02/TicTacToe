package com.kodilla.tictactoe;

public enum Mark {
    o("O", 1),
    x("X", 5),
    empty(" ", 0);

    private final String mark;
    private final int value;

    Mark(String mark, int value) {
        this.value = value;
        this.mark = mark;
    }

    public int getValue() {
        return value;
    }

    public String getMark() {
        return mark;
    }
}
