package com.kodilla.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PlayerTestSuite {

    @Nested
    @DisplayName("Tests for PlayerComputer")
    class testPlayerComputer {

        @Test
        void testPlayerComputerCreatePlayer() {
            //Given
            PlayerComputer playerComputer = new PlayerComputer(Mark.o);

            //When & Then
            Assertions.assertEquals("Computer", playerComputer.getPlayerName());
            Assertions.assertEquals(Mark.o, playerComputer.getPlayerMark());
        }

        @Test
        void testGetMoveRegularMove() {
            //Given
            Board board = new Board(3);
            PlayerComputer playerComputerO = new PlayerComputer(Mark.o);
            PlayerComputer playerComputerX = new PlayerComputer(Mark.x);

            //When
            playerComputerO.getMove(board);
            playerComputerX.getMove(board);
            playerComputerX.getMove(board);

            //Then
            Assertions.assertEquals(1, board.calculateOs());
            Assertions.assertEquals(2, board.calculateXs());
        }

        @Test
        void testGetMoveOneOption() throws IllegalMoveException {
            //Given
            Board board = new Board(3);
            PlayerComputer playerComputer = new PlayerComputer(Mark.x);

            //When
            TttMechanics.recordMove(board, 1, 1, Mark.o);
            TttMechanics.recordMove(board, 1, 2, Mark.o);
            TttMechanics.recordMove(board, 1, 3, Mark.o);
            TttMechanics.recordMove(board, 2, 1, Mark.o);
            TttMechanics.recordMove(board, 2, 2, Mark.o);
            TttMechanics.recordMove(board, 2, 3, Mark.o);
            TttMechanics.recordMove(board, 3, 1, Mark.o);
            TttMechanics.recordMove(board, 3, 2, Mark.o);

            playerComputer.getMove(board);

            //Then
            Assertions.assertEquals(Mark.x, board.getBoardStatus()[2][2]);
            Assertions.assertEquals(8, board.calculateOs());
            Assertions.assertEquals(1, board.calculateXs());

        }

        @Test
        void testGetMoveFullBoard() throws IllegalMoveException {
            //Given
            Board board = new Board(3);
            PlayerComputer playerComputer = new PlayerComputer(Mark.x);

            //When
            TttMechanics.recordMove(board, 1, 1, Mark.o);
            TttMechanics.recordMove(board, 1, 2, Mark.o);
            TttMechanics.recordMove(board, 1, 3, Mark.o);
            TttMechanics.recordMove(board, 2, 1, Mark.o);
            TttMechanics.recordMove(board, 2, 2, Mark.o);
            TttMechanics.recordMove(board, 2, 3, Mark.o);
            TttMechanics.recordMove(board, 3, 1, Mark.o);
            TttMechanics.recordMove(board, 3, 2, Mark.o);
            TttMechanics.recordMove(board, 3, 3, Mark.o);

            //Then
            Assertions.assertFalse(playerComputer.getMove(board));

        }

        @Test
        void testGetMoveFillBoard() throws IllegalMoveException {
            //Given
            Board board1 = new Board(3);
            Board board2 = new Board(10);
            PlayerComputer playerComputer = new PlayerComputer(Mark.x);

            //When
            for (int i = 0; i < 9; i++) {
                playerComputer.getMove(board1);
            }

            for (int i = 0; i < 100; i++) {
                playerComputer.getMove(board2);
            }

            //Then
            Assertions.assertTrue(board1.isFull());
            Assertions.assertEquals(9, board1.calculateXs());
            Assertions.assertTrue(board2.isFull());
            Assertions.assertEquals(100, board2.calculateXs());

        }
    }

    @Nested
    @DisplayName("Tests for PlayerPerson")
    class testPlayerPerson {

        @Test
        void testPlayerPersonCreatePlayer() {
            //Given
            PlayerPerson player1 = new PlayerPerson("Player 1", Mark.o);
            PlayerPerson player2 = new PlayerPerson("Player 2", Mark.x);

            //When & Then
            Assertions.assertEquals("Player 1", player1.getPlayerName());
            Assertions.assertEquals(Mark.o, player1.getPlayerMark());
            Assertions.assertEquals("Player 2", player2.getPlayerName());
            Assertions.assertEquals(Mark.x, player2.getPlayerMark());
        }
    }
}
