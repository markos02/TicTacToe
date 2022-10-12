package com.kodilla.tictactoe;

import java.util.Scanner;

public class PlayerPerson extends Player{

    public PlayerPerson(String playerName, Mark playerMark) {
        super(playerName, playerMark);
    }

    @Override
    protected boolean getMove(Board board) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(getPlayerName() + " (" + getPlayerMark().getMark() + ") makes a move");
        System.out.print("Column: ");
        int column = scanner.nextInt();
        System.out.print("Row: ");
        int row = scanner.nextInt();

        try {
            TttMechanics.recordMove(board, column, row, getPlayerMark());
            System.out.println(board);
            return true;
        } catch (
                IllegalMoveException e) {
            System.out.println("Illegal move!\n");
            return false;
        }
    }
}
