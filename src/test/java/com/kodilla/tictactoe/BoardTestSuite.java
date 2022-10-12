package com.kodilla.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BoardTestSuite {

    @Test
    void testCreatingNewEmptyBoard() {
        //Given
        Board board1 = new Board(3);
        Board board2 = new Board(10);

        //When & Then
        assertNotNull(board1.getBoardStatus());
        Assertions.assertEquals(3, board1.getBoardStatus().length);
        Assertions.assertEquals(3, board1.boardSize);
        Assertions.assertEquals(Mark.empty, board1.getBoardStatus()[1][1]);

        assertNotNull(board2.getBoardStatus());
        Assertions.assertEquals(10, board2.getBoardStatus().length);
        Assertions.assertEquals(10, board2.boardSize);
        Assertions.assertEquals(Mark.empty, board2.getBoardStatus()[5][5]);
    }

    @Test
    void testIsFullEmptyBoard(){
        //Given
        Board board1 = new Board(3);

        //When & Then
        Assertions.assertFalse(board1.isFull());
    }

    @Test
    void testIsFullRegularBoard() throws IllegalMoveException {
        //Given
        Board board1 = new Board(3);

        //When
        TttMechanics.recordMove(board1, 1, 1, Mark.o);
        TttMechanics.recordMove(board1, 1, 2, Mark.x);

        //When & Then
        Assertions.assertFalse(board1.isFull());
    }

    @Test
    void testIsFullFullBoard() throws IllegalMoveException {
        //Given
        Board board1 = new Board(3);

        //When
        TttMechanics.recordMove(board1, 1, 1, Mark.o);
        TttMechanics.recordMove(board1, 1, 2, Mark.x);
        TttMechanics.recordMove(board1, 1, 3, Mark.x);
        TttMechanics.recordMove(board1, 2, 1, Mark.x);
        TttMechanics.recordMove(board1, 2, 2, Mark.x);
        TttMechanics.recordMove(board1, 2, 3, Mark.x);
        TttMechanics.recordMove(board1, 3, 1, Mark.x);
        TttMechanics.recordMove(board1, 3, 2, Mark.x);
        TttMechanics.recordMove(board1, 3, 3, Mark.x);

        //When & Then
        Assertions.assertTrue(board1.isFull());
    }

    @Test
    void testCalculateEmptyFields() throws IllegalMoveException {
        //Given
        Board board1 = new Board(3);
        Board board2 = new Board(3);
        Board board3 = new Board(3);

        //When
        TttMechanics.recordMove(board1, 1, 1, Mark.o);
        TttMechanics.recordMove(board1, 1, 2, Mark.x);
        TttMechanics.recordMove(board1, 1, 3, Mark.x);
        TttMechanics.recordMove(board1, 2, 1, Mark.x);
        TttMechanics.recordMove(board1, 2, 2, Mark.x);
        TttMechanics.recordMove(board1, 2, 3, Mark.x);
        TttMechanics.recordMove(board1, 3, 1, Mark.x);
        TttMechanics.recordMove(board1, 3, 2, Mark.x);
        TttMechanics.recordMove(board1, 3, 3, Mark.x);

        TttMechanics.recordMove(board2, 3, 1, Mark.x);
        TttMechanics.recordMove(board2, 3, 2, Mark.x);
        TttMechanics.recordMove(board2, 3, 3, Mark.x);

        //When & Then
        Assertions.assertEquals(0, board1.calculateEmptyFields());
        Assertions.assertEquals(6, board2.calculateEmptyFields());
        Assertions.assertEquals(9, board3.calculateEmptyFields());
    }

    @Test
    void testCalculateOs() throws IllegalMoveException {
        //Given
        Board board1 = new Board(3);
        Board board2 = new Board(3);
        Board board3 = new Board(3);

        //When
        TttMechanics.recordMove(board1, 1, 1, Mark.o);
        TttMechanics.recordMove(board1, 1, 2, Mark.x);
        TttMechanics.recordMove(board1, 1, 3, Mark.x);
        TttMechanics.recordMove(board1, 2, 1, Mark.o);
        TttMechanics.recordMove(board1, 2, 2, Mark.x);
        TttMechanics.recordMove(board1, 2, 3, Mark.x);
        TttMechanics.recordMove(board1, 3, 1, Mark.x);
        TttMechanics.recordMove(board1, 3, 2, Mark.x);
        TttMechanics.recordMove(board1, 3, 3, Mark.x);

        TttMechanics.recordMove(board2, 3, 1, Mark.x);
        TttMechanics.recordMove(board2, 3, 2, Mark.x);
        TttMechanics.recordMove(board2, 3, 3, Mark.x);

        //When & Then
        Assertions.assertEquals(2, board1.calculateOs());
        Assertions.assertEquals(0, board2.calculateOs());
        Assertions.assertEquals(0, board3.calculateOs());
    }

    @Test
    void testCalculateXs() throws IllegalMoveException {
        //Given
        Board board1 = new Board(3);
        Board board2 = new Board(3);
        Board board3 = new Board(3);

        //When
        TttMechanics.recordMove(board1, 1, 1, Mark.o);
        TttMechanics.recordMove(board1, 1, 2, Mark.x);
        TttMechanics.recordMove(board1, 1, 3, Mark.x);
        TttMechanics.recordMove(board1, 2, 1, Mark.o);
        TttMechanics.recordMove(board1, 2, 2, Mark.x);
        TttMechanics.recordMove(board1, 2, 3, Mark.x);
        TttMechanics.recordMove(board1, 3, 1, Mark.x);
        TttMechanics.recordMove(board1, 3, 2, Mark.x);
        TttMechanics.recordMove(board1, 3, 3, Mark.x);

        TttMechanics.recordMove(board2, 3, 1, Mark.o);
        TttMechanics.recordMove(board2, 3, 2, Mark.o);
        TttMechanics.recordMove(board2, 3, 3, Mark.o);

        //When & Then
        Assertions.assertEquals(7, board1.calculateXs());
        Assertions.assertEquals(0, board2.calculateXs());
        Assertions.assertEquals(0, board3.calculateXs());
    }
}
