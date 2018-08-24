package tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardVerifierTest {

    private Board board;

   @Test
    public void shouldReturnTrueIfBoardIsResolvedDiagonally() {
        board = new Board();
        board.makeMove(MARK.X, 0,2);
        board.makeMove(MARK.X, 1,1);
        board.makeMove(MARK.X, 2,0);

        assertEquals(MARK.X, BoardVerifier.isBoardResolved(board));

        board = new Board();
        board.makeMove(MARK.X, 0,0);
        board.makeMove(MARK.X, 1,1);
        board.makeMove(MARK.X, 2,2);

       assertEquals(MARK.X, BoardVerifier.isBoardResolved(board));
    }

    @Test
    public void shouldReturnTrueIfBoardIsResolvedInARow() {
        board = new Board();
        board.makeMove(MARK.X, 0,0);
        board.makeMove(MARK.X, 0,1);
        board.makeMove(MARK.X, 0,2);

        assertEquals(MARK.X, BoardVerifier.isBoardResolved(board));

    }

    @Test
    public void shouldReturnTrueIfBoardIsResolvedInAColumn() {
        board = new Board();
        board.makeMove(MARK.X, 0,0);
        board.makeMove(MARK.X, 1,0);
        board.makeMove(MARK.X, 2,0);

        assertEquals(MARK.X, BoardVerifier.isBoardResolved(board));

    }

    @Test
    public void shouldReturnFalseForEmptyBoard(){
        board = new Board();
        assertEquals(MARK.NEUTRAL, BoardVerifier.isBoardResolved(board));
    }
}