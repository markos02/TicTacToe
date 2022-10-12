package com.kodilla.tictactoe;

import java.util.Arrays;

public class Board {

    private final Mark[][] boardStatus;
    int boardSize;

    public Board(int size) {
        this.boardSize = size;
        this.boardStatus = new Mark[size][size];
        for (Mark[] row : this.boardStatus) {
            Arrays.fill(row, Mark.empty);
        }
    }

    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();

        for (int i = 0; i < boardSize; i++) {
            string.append('|');
            for (int j = 0; j < boardSize; j++) {
                string.append(boardStatus[i][j].getMark());
                string.append('|');
            }
            string.append('\n');
        }

        return string.toString();
    }


    public Mark[][] getBoardStatus() {
        return boardStatus;
    }

    public boolean isFull() {

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (getBoardStatus()[i][j] == Mark.empty) {
                    return false;
                }
            }
        }
        return true;
    }

    public int calculateEmptyFields() {

        int result = 0;

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (getBoardStatus()[i][j] == Mark.empty) {
                    result++;
                }
            }
        }
        return result;
    }

    public int calculateOs() {

        int result = 0;

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (getBoardStatus()[i][j] == Mark.o) {
                    result++;
                }
            }
        }
        return result;
    }

    public int calculateXs() {

        int result = 0;

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (getBoardStatus()[i][j] == Mark.x) {
                    result++;
                }
            }
        }
        return result;
    }
}
