package com.kodilla.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TttMechanicsTestSuite {


    @Nested
    @DisplayName("Tests for recording a move")
    class testRecordMove {

        @Test
        void testRecordMoveAdd1Mark() throws IllegalMoveException {
            //Given
            Board board = new Board(3);

            //When
            TttMechanics.recordMove(board, 1, 1, Mark.o);
            TttMechanics.recordMove(board, 1, 2, Mark.x);

            //Then
            Assertions.assertEquals(Mark.o, board.getBoardStatus()[0][0]);
            Assertions.assertEquals(Mark.x, board.getBoardStatus()[1][0]);
        }

        @Test
        void testRecordMoveIllegalMove() throws IllegalMoveException {
            //Given
            Board board = new Board(3);

            //When
            TttMechanics.recordMove(board, 1, 1, Mark.o);

            // Then
            assertThrows(IllegalMoveException.class, () -> TttMechanics.recordMove(board, 1, 1, Mark.o));
        }

        @Test
        void testRecordMoveMoveOutsideBoard() {

            //Given
            Board board = new Board(3);

            // When & Then
            assertThrows(IllegalMoveException.class, () -> TttMechanics.recordMove(board, 4, 1, Mark.o));
            assertThrows(IllegalMoveException.class, () -> TttMechanics.recordMove(board, 0, 3, Mark.o));

        }
    }

    @Nested
    @DisplayName("Tests for checking if someone won")
    class testCheckBoard {

        @Test
        void testCheckBoardEmptyBoard() {

            //Given
            Board board1 = new Board(3);
            Board board2 = new Board(10);
            PlayerPerson player1 = new PlayerPerson("Player 1", Mark.o);
            PlayerPerson player2 = new PlayerPerson("Player 2", Mark.x);

            //When & Then
            assertNull(TttMechanics.checkBoard(player1, player2, board1, 3));
            assertNull(TttMechanics.checkBoard(player1, player2, board2, 1));

        }

        @Nested
        @DisplayName("Tests for 3x3 board")
        class testCheckBoard3x3 {


            @Test
            void testPlayer1WinsRow() throws IllegalMoveException {

                //Given
                Board board1 = new Board(3);
                Board board2 = new Board(3);
                Board board3 = new Board(3);
                PlayerPerson player1 = new PlayerPerson("Player 1", Mark.o);
                PlayerPerson player2 = new PlayerPerson("Player 2", Mark.x);

                //When
                TttMechanics.recordMove(board1, 1, 1, Mark.o);
                TttMechanics.recordMove(board1, 2, 1, Mark.o);
                TttMechanics.recordMove(board1, 3, 1, Mark.o);

                TttMechanics.recordMove(board2, 1, 2, Mark.o);
                TttMechanics.recordMove(board2, 2, 2, Mark.o);
                TttMechanics.recordMove(board2, 3, 2, Mark.o);

                TttMechanics.recordMove(board3, 1, 3, Mark.o);
                TttMechanics.recordMove(board3, 2, 3, Mark.o);
                TttMechanics.recordMove(board3, 3, 3, Mark.o);

                //Then
                Assertions.assertEquals("Player 1", TttMechanics.checkBoard(player1, player2, board1, 3));
                Assertions.assertEquals("Player 1", TttMechanics.checkBoard(player1, player2, board2, 3));
                Assertions.assertEquals("Player 1", TttMechanics.checkBoard(player1, player2, board3, 3));
            }


            @Test
            void testPlayer1WinsColumn() throws IllegalMoveException {

                //Given
                Board board1 = new Board(3);
                Board board2 = new Board(3);
                Board board3 = new Board(3);
                PlayerPerson player1 = new PlayerPerson("Player 1", Mark.o);
                PlayerPerson player2 = new PlayerPerson("Player 2", Mark.x);


                //When
                TttMechanics.recordMove(board1, 1, 1, Mark.o);
                TttMechanics.recordMove(board1, 1, 2, Mark.o);
                TttMechanics.recordMove(board1, 1, 3, Mark.o);

                TttMechanics.recordMove(board2, 2, 1, Mark.o);
                TttMechanics.recordMove(board2, 2, 2, Mark.o);
                TttMechanics.recordMove(board2, 2, 3, Mark.o);

                TttMechanics.recordMove(board3, 3, 1, Mark.o);
                TttMechanics.recordMove(board3, 3, 2, Mark.o);
                TttMechanics.recordMove(board3, 3, 3, Mark.o);

                //Then
                Assertions.assertEquals("Player 1", TttMechanics.checkBoard(player1, player2, board1, 3));
                Assertions.assertEquals("Player 1", TttMechanics.checkBoard(player1, player2, board2, 3));
                Assertions.assertEquals("Player 1", TttMechanics.checkBoard(player1, player2, board3, 3));
            }

            @Test
            void testPlayer2WinsRow() throws IllegalMoveException {

                //Given
                Board board1 = new Board(3);
                Board board2 = new Board(3);
                Board board3 = new Board(3);
                PlayerPerson player1 = new PlayerPerson("Player 1", Mark.o);
                PlayerPerson player2 = new PlayerPerson("Player 2", Mark.x);


                //When
                TttMechanics.recordMove(board1, 1, 1, Mark.x);
                TttMechanics.recordMove(board1, 2, 1, Mark.x);
                TttMechanics.recordMove(board1, 3, 1, Mark.x);

                TttMechanics.recordMove(board2, 1, 2, Mark.x);
                TttMechanics.recordMove(board2, 2, 2, Mark.x);
                TttMechanics.recordMove(board2, 3, 2, Mark.x);

                TttMechanics.recordMove(board3, 1, 3, Mark.x);
                TttMechanics.recordMove(board3, 2, 3, Mark.x);
                TttMechanics.recordMove(board3, 3, 3, Mark.x);

                //Then
                Assertions.assertEquals("Player 2", TttMechanics.checkBoard(player1, player2, board1, 3));
                Assertions.assertEquals("Player 2", TttMechanics.checkBoard(player1, player2, board2, 3));
                Assertions.assertEquals("Player 2", TttMechanics.checkBoard(player1, player2, board3, 3));
            }

            @Test
            void testPlayer2WinsColumn() throws IllegalMoveException {

                //Given
                Board board1 = new Board(3);
                Board board2 = new Board(3);
                Board board3 = new Board(3);
                PlayerPerson player1 = new PlayerPerson("Player 1", Mark.o);
                PlayerPerson player2 = new PlayerPerson("Player 2", Mark.x);


                //When
                TttMechanics.recordMove(board1, 1, 1, Mark.x);
                TttMechanics.recordMove(board1, 1, 2, Mark.x);
                TttMechanics.recordMove(board1, 1, 3, Mark.x);

                TttMechanics.recordMove(board2, 2, 1, Mark.x);
                TttMechanics.recordMove(board2, 2, 2, Mark.x);
                TttMechanics.recordMove(board2, 2, 3, Mark.x);

                TttMechanics.recordMove(board3, 3, 1, Mark.x);
                TttMechanics.recordMove(board3, 3, 2, Mark.x);
                TttMechanics.recordMove(board3, 3, 3, Mark.x);

                //Then
                Assertions.assertEquals("Player 2", TttMechanics.checkBoard(player1, player2, board1, 3));
                Assertions.assertEquals("Player 2", TttMechanics.checkBoard(player1, player2, board2, 3));
                Assertions.assertEquals("Player 2", TttMechanics.checkBoard(player1, player2, board3, 3));
            }


            @Test
            void testPlayer1WinsDiagonal() throws IllegalMoveException {

                //Given
                Board board1 = new Board(3);
                Board board2 = new Board(3);
                PlayerPerson player1 = new PlayerPerson("Player 1", Mark.o);
                PlayerPerson player2 = new PlayerPerson("Player 2", Mark.x);


                //When
                TttMechanics.recordMove(board1, 1, 1, Mark.o);
                TttMechanics.recordMove(board1, 2, 2, Mark.o);
                TttMechanics.recordMove(board1, 3, 3, Mark.o);

                TttMechanics.recordMove(board2, 1, 3, Mark.o);
                TttMechanics.recordMove(board2, 2, 2, Mark.o);
                TttMechanics.recordMove(board2, 3, 1, Mark.o);

                //Then
                Assertions.assertEquals("Player 1", TttMechanics.checkBoard(player1, player2, board1, 3));
                Assertions.assertEquals("Player 1", TttMechanics.checkBoard(player1, player2, board2, 3));
            }

            @Test
            void testPlayer2WinsDiagonal() throws IllegalMoveException {

                //Given
                Board board1 = new Board(3);
                Board board2 = new Board(3);
                PlayerPerson player1 = new PlayerPerson("Player 1", Mark.o);
                PlayerPerson player2 = new PlayerPerson("Player 2", Mark.x);


                //When
                TttMechanics.recordMove(board1, 1, 1, Mark.x);
                TttMechanics.recordMove(board1, 2, 2, Mark.x);
                TttMechanics.recordMove(board1, 3, 3, Mark.x);

                TttMechanics.recordMove(board2, 1, 3, Mark.x);
                TttMechanics.recordMove(board2, 2, 2, Mark.x);
                TttMechanics.recordMove(board2, 3, 1, Mark.x);

                //Then
                Assertions.assertEquals("Player 2", TttMechanics.checkBoard(player1, player2, board1, 3));
                Assertions.assertEquals("Player 2", TttMechanics.checkBoard(player1, player2, board2, 3));
            }

            @Test
            void testTie() throws IllegalMoveException {

                //Given
                Board board = new Board(3);
                PlayerPerson player1 = new PlayerPerson("Player 1", Mark.o);
                PlayerPerson player2 = new PlayerPerson("Player 2", Mark.x);


                //When
                TttMechanics.recordMove(board, 1, 1, Mark.x);
                TttMechanics.recordMove(board, 1, 2, Mark.x);
                TttMechanics.recordMove(board, 1, 3, Mark.o);
                TttMechanics.recordMove(board, 2, 1, Mark.o);
                TttMechanics.recordMove(board, 2, 2, Mark.o);
                TttMechanics.recordMove(board, 2, 3, Mark.x);
                TttMechanics.recordMove(board, 3, 1, Mark.x);
                TttMechanics.recordMove(board, 3, 2, Mark.o);
                TttMechanics.recordMove(board, 3, 3, Mark.o);

                //Then
                Assertions.assertEquals("Tie", TttMechanics.checkBoard(player1, player2, board, 3));
            }
        }

        @Nested
        @DisplayName("Tests for 10x10 board")
        class testCheckBoard10x10 {

            @Test
            void testNoWinner() throws IllegalMoveException {

                //Given
                Board board1 = new Board(10);
                Board board2 = new Board(10);
                PlayerPerson player1 = new PlayerPerson("Player 1", Mark.o);
                PlayerPerson player2 = new PlayerPerson("Player 2", Mark.x);

                //When
                TttMechanics.recordMove(board1, 1, 1, Mark.o);
                TttMechanics.recordMove(board1, 2, 1, Mark.o);
                TttMechanics.recordMove(board1, 3, 1, Mark.o);
                TttMechanics.recordMove(board1, 4, 1, Mark.o);
                TttMechanics.recordMove(board1, 5, 1, Mark.o);

                TttMechanics.recordMove(board2, 3, 4, Mark.o);
                TttMechanics.recordMove(board2, 4, 4, Mark.x);
                TttMechanics.recordMove(board2, 5, 4, Mark.o);
                TttMechanics.recordMove(board2, 6, 4, Mark.o);
                TttMechanics.recordMove(board2, 7, 4, Mark.o);

                //Then
                assertNull(TttMechanics.checkBoard(player1, player2, board1, 6));
                assertNull(TttMechanics.checkBoard(player1, player2, board2, 5));
            }

            @Test
            void testPlayer1WinsRow() throws IllegalMoveException {

                //Given
                Board board1 = new Board(10);
                Board board2 = new Board(10);
                PlayerPerson player1 = new PlayerPerson("Player 1", Mark.o);
                PlayerPerson player2 = new PlayerPerson("Player 2", Mark.x);

                //When
                TttMechanics.recordMove(board1, 1, 1, Mark.o);
                TttMechanics.recordMove(board1, 2, 1, Mark.o);
                TttMechanics.recordMove(board1, 3, 1, Mark.o);
                TttMechanics.recordMove(board1, 4, 1, Mark.o);
                TttMechanics.recordMove(board1, 5, 1, Mark.o);

                TttMechanics.recordMove(board2, 3, 4, Mark.o);
                TttMechanics.recordMove(board2, 4, 4, Mark.o);
                TttMechanics.recordMove(board2, 5, 4, Mark.o);
                TttMechanics.recordMove(board2, 6, 4, Mark.o);
                TttMechanics.recordMove(board2, 7, 4, Mark.o);

                //Then
                Assertions.assertEquals("Player 1", TttMechanics.checkBoard(player1, player2, board1, 5));
                Assertions.assertEquals("Player 1", TttMechanics.checkBoard(player1, player2, board2, 5));
            }


            @Test
            void testPlayer1WinsColumn() throws IllegalMoveException {

                //Given
                Board board1 = new Board(10);
                Board board2 = new Board(10);
                PlayerPerson player1 = new PlayerPerson("Player 1", Mark.o);
                PlayerPerson player2 = new PlayerPerson("Player 2", Mark.x);


                //When
                TttMechanics.recordMove(board1, 1, 1, Mark.o);
                TttMechanics.recordMove(board1, 1, 2, Mark.o);
                TttMechanics.recordMove(board1, 1, 3, Mark.o);
                TttMechanics.recordMove(board1, 1, 4, Mark.o);
                TttMechanics.recordMove(board1, 1, 5, Mark.o);

                TttMechanics.recordMove(board2, 6, 3, Mark.o);
                TttMechanics.recordMove(board2, 6, 4, Mark.o);
                TttMechanics.recordMove(board2, 6, 5, Mark.o);
                TttMechanics.recordMove(board2, 6, 6, Mark.o);
                TttMechanics.recordMove(board2, 6, 7, Mark.o);

                //Then
                Assertions.assertEquals("Player 1", TttMechanics.checkBoard(player1, player2, board1, 5));
                Assertions.assertEquals("Player 1", TttMechanics.checkBoard(player1, player2, board2, 5));
            }

            @Test
            void testPlayer2WinsRow() throws IllegalMoveException {

                //Given
                Board board1 = new Board(10);
                Board board2 = new Board(10);
                PlayerPerson player1 = new PlayerPerson("Player 1", Mark.o);
                PlayerPerson player2 = new PlayerPerson("Player 2", Mark.x);


                //When
                TttMechanics.recordMove(board1, 1, 1, Mark.x);
                TttMechanics.recordMove(board1, 2, 1, Mark.x);
                TttMechanics.recordMove(board1, 3, 1, Mark.x);
                TttMechanics.recordMove(board1, 4, 1, Mark.x);
                TttMechanics.recordMove(board1, 5, 1, Mark.x);

                TttMechanics.recordMove(board2, 3, 9, Mark.x);
                TttMechanics.recordMove(board2, 4, 9, Mark.x);
                TttMechanics.recordMove(board2, 5, 9, Mark.x);
                TttMechanics.recordMove(board2, 6, 9, Mark.x);
                TttMechanics.recordMove(board2, 7, 9, Mark.x);

                //Then
                Assertions.assertEquals("Player 2", TttMechanics.checkBoard(player1, player2, board1, 5));
                Assertions.assertEquals("Player 2", TttMechanics.checkBoard(player1, player2, board2, 5));
            }

            @Test
            void testPlayer2WinsColumn() throws IllegalMoveException {

                //Given
                Board board1 = new Board(10);
                Board board2 = new Board(10);
                PlayerPerson player1 = new PlayerPerson("Player 1", Mark.o);
                PlayerPerson player2 = new PlayerPerson("Player 2", Mark.x);


                //When
                TttMechanics.recordMove(board1, 1, 1, Mark.x);
                TttMechanics.recordMove(board1, 1, 2, Mark.x);
                TttMechanics.recordMove(board1, 1, 3, Mark.x);
                TttMechanics.recordMove(board1, 1, 4, Mark.x);
                TttMechanics.recordMove(board1, 1, 5, Mark.x);

                TttMechanics.recordMove(board2, 10, 5, Mark.x);
                TttMechanics.recordMove(board2, 10, 6, Mark.x);
                TttMechanics.recordMove(board2, 10, 7, Mark.x);
                TttMechanics.recordMove(board2, 10, 8, Mark.x);
                TttMechanics.recordMove(board2, 10, 9, Mark.x);

                //Then
                Assertions.assertEquals("Player 2", TttMechanics.checkBoard(player1, player2, board1, 5));
                Assertions.assertEquals("Player 2", TttMechanics.checkBoard(player1, player2, board2, 5));
            }


            @Test
            void testPlayer1WinsDiagonal() throws IllegalMoveException {

                //Given
                Board board1 = new Board(10);
                Board board2 = new Board(10);
                PlayerPerson player1 = new PlayerPerson("Player 1", Mark.o);
                PlayerPerson player2 = new PlayerPerson("Player 2", Mark.x);


                //When
                TttMechanics.recordMove(board1, 1, 1, Mark.o);
                TttMechanics.recordMove(board1, 2, 2, Mark.o);
                TttMechanics.recordMove(board1, 3, 3, Mark.o);
                TttMechanics.recordMove(board1, 4, 4, Mark.o);
                TttMechanics.recordMove(board1, 5, 5, Mark.o);

                TttMechanics.recordMove(board2, 9, 4, Mark.o);
                TttMechanics.recordMove(board2, 8, 5, Mark.o);
                TttMechanics.recordMove(board2, 7, 6, Mark.o);
                TttMechanics.recordMove(board2, 6, 7, Mark.o);
                TttMechanics.recordMove(board2, 5, 8, Mark.o);

                //Then
                Assertions.assertEquals("Player 1", TttMechanics.checkBoard(player1, player2, board1, 5));
                Assertions.assertEquals("Player 1", TttMechanics.checkBoard(player1, player2, board2, 5));
            }

            @Test
            void testPlayer2WinsDiagonal() throws IllegalMoveException {

                //Given
                Board board1 = new Board(10);
                Board board2 = new Board(10);
                PlayerPerson player1 = new PlayerPerson("Player 1", Mark.o);
                PlayerPerson player2 = new PlayerPerson("Player 2", Mark.x);


                //When
                TttMechanics.recordMove(board1, 6, 6, Mark.x);
                TttMechanics.recordMove(board1, 7, 7, Mark.x);
                TttMechanics.recordMove(board1, 8, 8, Mark.x);
                TttMechanics.recordMove(board1, 9, 9, Mark.x);
                TttMechanics.recordMove(board1, 10, 10, Mark.x);

                TttMechanics.recordMove(board2, 10, 1, Mark.x);
                TttMechanics.recordMove(board2, 9, 2, Mark.x);
                TttMechanics.recordMove(board2, 8, 3, Mark.x);
                TttMechanics.recordMove(board2, 7, 4, Mark.x);
                TttMechanics.recordMove(board2, 6, 5, Mark.x);

                //Then
                Assertions.assertEquals("Player 2", TttMechanics.checkBoard(player1, player2, board1, 5));
                Assertions.assertEquals("Player 2", TttMechanics.checkBoard(player1, player2, board2, 5));
            }

            @Test
            void testTie() throws IllegalMoveException {

                //Given
                Board board = new Board(10);
                PlayerPerson player1 = new PlayerPerson("Player 1", Mark.o);
                PlayerPerson player2 = new PlayerPerson("Player 2", Mark.x);


                //When
                int counter = 0;
                Mark mark = Mark.o;

                for (int i = 1; i < 11; i++) {
                    for (int j = 1; j < 11; j++) {

                        counter++;

                        if (counter % 4 == 0) {
                            if (mark == Mark.o) {
                                mark = Mark.x;
                            } else {
                                mark = Mark.o;
                            }
                        }

                        TttMechanics.recordMove(board, i, j, mark);
                    }
                }

                //Then
                Assertions.assertEquals("Tie", TttMechanics.checkBoard(player1, player2, board, 5));
            }
        }
    }
}

