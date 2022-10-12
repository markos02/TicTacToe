package com.kodilla.tictactoe;

public class TttMechanics {

    static int player1Counter;
    static int player2Counter;

    public static void recordMove(Board board, int column, int row, Mark mark) throws IllegalMoveException {

        column = column - 1;
        row = row - 1;

        try {
            if (board.getBoardStatus()[row][column] == Mark.empty) {
                board.getBoardStatus()[row][column] = mark;
            } else {
                throw new IllegalMoveException();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalMoveException();
        }
    }

    public static String checkBoard(Player player1, Player player2, Board board, int win) {

        int size = board.getBoardStatus().length;
        Player winner = null;

        //Check columns
        for (int i = 0; i < size; i++) {

            player1Counter = 0;
            player2Counter = 0;

            for (int j = 0; j < size; j++) {

                winner = calculateCounters(player1, player2, board.getBoardStatus()[i][j], win);

                if (winner != null) {
                    return winner.getPlayerName();
                }
            }
        }

        //Check rows
        for (int i = 0; i < size; i++) {

            player1Counter = 0;
            player2Counter = 0;

            for (int j = 0; j < size; j++) {

                winner = calculateCounters(player1, player2, board.getBoardStatus()[j][i], win);

                if (winner != null) {
                    return winner.getPlayerName();
                }
            }
        }

        //Check diagonals TopLeft-BottomRight
        for (int i = size - 1; i > -size; i--) {

            player1Counter = 0;
            player2Counter = 0;
            int row = i;

            for (int col = 0; col < size - i; col++) {

                try {
                    winner = calculateCounters(player1, player2, board.getBoardStatus()[col][row], win);
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }

                if (winner != null) {
                    return winner.getPlayerName();
                }

                row++;

            }
        }

        //Check diagonals TopRight-BottomLeft
        for (int i = 0; i <= size * 2; i++) {

            player1Counter = 0;
            player2Counter = 0;
            int row = i;

            for (int col = 0; col <= i; col++) {

                try {
                    winner = calculateCounters(player1, player2, board.getBoardStatus()[col][row], win);
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }

                if (winner != null) {
                    return winner.getPlayerName();
                }

                row--;

            }
        }

        //Check if there is a tie
        if (board.isFull()) {
            return "Tie";
        }

        return null;
    }

    private static Player calculateCounters(Player player1, Player player2, Mark mark, int win) {

        if (mark == player1.getPlayerMark()) {
            player1Counter++;
            player2Counter = 0;
        }

        if (mark == player2.getPlayerMark()) {
            player2Counter++;
            player1Counter = 0;
        }

        if (mark == Mark.empty) {
            player1Counter = 0;
            player2Counter = 0;
        }

        if (player1Counter == win) {
            return player1;
        }

        if (player2Counter == win) {
            return player2;
        }

        return null;
    }
}


