package com.kodilla.tictactoe;

import java.util.Scanner;

public class TttPresentation {

    private static final Scanner scanner = new Scanner(System.in);
    static Player player1 = null;
    static Player player2 = null;

    public void start() {

        boolean run = true;

        while (run) {

            System.out.println("\nNEW GAME");

            boolean testChoice = true;
            int gameMode;

            while (testChoice) {

                System.out.println("""

                        Choose game mode:
                        [1] Single player game (against computer)
                        [2] Two players game"""
                );

                gameMode = scanner.nextInt();

                if (setPlayers(gameMode)) {
                    testChoice = false;
                } else {
                    System.out.println("Incorrect game mode. Choose \"1\" or \"2\"");
                }
            }

            testChoice = true;
            int boardSize;

            while (testChoice) {

                System.out.println("""

                        Choose board size:
                        [3] 3x3 (classic TicTacToe)
                        [10] 10x10 (5 marks in a row to win)"""
                );

                boardSize = scanner.nextInt();

                if (boardSize == 3 || boardSize == 10) {
                    playGame(boardSize);
                    testChoice = false;
                } else {
                    System.out.println("Incorrect board size. Choose \"3\" or \"10\"");
                }
            }

            System.out.println("""


                    Press n to restart the game
                    Press any other key to end the game""");

            String choice = scanner.next();
            if (!choice.equals("n")) {
                run = false;
            }
        }

        System.out.println("Thanks for playing!");
    }

    public void playGame(int boardSize) {

        final Board board = new Board(boardSize);
        int win = 0;

        if (boardSize == 3) {
            win = 3;
        } else if (boardSize == 10) {
            win = 5;
        }

        boolean turn = true;                   //true if player 1 (O) turn, false if player 2 (x) turn

        System.out.println("\n\nInstructions:\n" +
                "Choose column and row number [1-" + boardSize + "] when it is your turn\n"
        );

        boolean nextRound = true;

        while (nextRound) {

            if (turn) {
                if (player1.getMove(board)) {
                    turn = !turn;
                }
            } else {
                if (player2.getMove(board)) {
                    turn = !turn;
                }
            }

            String winner = TttMechanics.checkBoard(player1, player2, board, win);

            if (winner != null) {
                if (winner.equals("Tie")) {
                    System.out.println("It's a tie!");
                } else {
                    System.out.println(winner + " won");
                }
                nextRound = false;
            }
        }
    }


    private static boolean setPlayers(int gameMode) {

        if (gameMode == 1) {
            System.out.print("Players name: ");
            String playerName = (scanner.next());

            boolean testChoice = true;

            while (testChoice) {

                System.out.print("Do you want to play \"o\" or \"x\"? ");
                String choice = (scanner.next());

                switch (choice) {
                    case "o" -> {
                        player1 = new PlayerPerson(playerName, Mark.o);
                        player2 = new PlayerComputer(Mark.x);
                        testChoice = false;
                    }
                    case "x" -> {
                        player1 = new PlayerComputer(Mark.o);
                        player2 = new PlayerPerson(playerName, Mark.x);
                        testChoice = false;
                    }
                    default -> System.out.println("Incorrect choice. Press \"o\" or \"x\"");
                }
            }
            return true;
        }

        if (gameMode == 2) {
            System.out.print("Player 1 (O) name: ");
            String player1Name = (scanner.next());

            System.out.print("Player 2 (X) name: ");
            String player2Name = scanner.next();

            player1 = new PlayerPerson(player1Name, Mark.o);
            player2 = new PlayerPerson(player2Name, Mark.x);

            return true;
        }
        return false;
    }
}