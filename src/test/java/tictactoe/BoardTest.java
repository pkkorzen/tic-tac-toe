package tictactoe;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    private Board board;

    @Before
    public void setup(){
        board = new Board();
    }

    @Test
    public void shouldCheckIfNewBoardIsCreated(){
        assertArrayEquals(new MARK[3][3], board.getGameBoard());
    }

    @Test
    public void shouldReturnTrueIfAnArrayFieldsAreEmpty(){
        assertTrue(board.isClear());
    }

    @Test
    public void shouldCheckIfALegalMoveCanBeMade(){
        board.makeMove(MARK.X, 2,2);
        Assertions.assertThat(!board.isClear());

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenAddingWrongArgument(){
        board.checkIfLegalMove(4,4);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowIllegalStateExceptionWhenMakingTheSameMoveTwice(){
        board.makeMove(MARK.X, 2,2);
        board.checkIfLegalMove(2,2);
        board.makeMove(MARK.X, 2,2);
    }

    @Test
    public void shouldReturnValueForAGivenField(){
        board.makeMove(MARK.X, 2,2);
        assertEquals(MARK.X, board.getValue(2,2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnIllegalArgumentExceptionGivenFieldIsNotCorrect(){
        board.makeMove(MARK.X, 2,2);
        assertEquals(MARK.X, board.getValue(-1,0));
    }
}