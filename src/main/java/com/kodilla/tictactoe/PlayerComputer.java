package com.kodilla.tictactoe;

import java.util.Random;

public class PlayerComputer extends Player {

    public PlayerComputer(Mark mark) {
        super("Computer", mark);
    }

    @Override
    protected boolean getMove(Board board) {

        if (board.isFull()) {
            return false;
        }

        int size = board.boardSize;
        Random random = new Random();
        int column;
        int row;

        boolean illegalMove = true;

        while (illegalMove) {
            try {
                column = 1 + random.nextInt(size);
                row = 1 + random.nextInt(size);
                TttMechanics.recordMove(board, column, row, getPlayerMark());
                System.out.println(getPlayerName() + " (" + getPlayerMark().getMark() + ") makes a move");
                System.out.println(board);
                illegalMove = false;
            } catch (IllegalMoveException ignore) {
            }
        }
        return true;
    }
}
