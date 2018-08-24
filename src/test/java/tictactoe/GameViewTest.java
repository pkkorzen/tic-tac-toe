package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameViewTest {
    private GameView gameView;
    private Board board;

    @Before
    public void setup(){
        gameView = new GameView();
        board = new Board();
    }

    @Test
    public void shouldReturnTrueIfEmptyBoardIsDisplayed(){
        String expected = "   " + 0 + "   " + 1 + "   " + 2 + "\n" + 0 + "    |   |   \n  -----------\n" + 1 + "    |   |   \n  -----------\n" + 2 + "    |   |   ";
        assertEquals(expected, gameView.showBoard(board).toString());
    }

    @Test
    public void shouldReturnTrueIfBoardIsFullyFilledAndProperlyDisplayed(){
        String expected = "   " + 0 + "   " + 1 + "   " + 2 + "\n" + 0 + "  X | O | X \n  -----------\n" + 1 + "  O | X | O \n  -----------\n" + 2 + "  X | O | X ";
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if((i+j)%2 == 0){
                    board.makeMove(MARK.X,i,j);
                } else {
                    board.makeMove(MARK.O, i,j);
                }
            }
        }
        assertEquals(expected, gameView.showBoard(board).toString());
    }

    @Test
    public void shouldReturnTrueIfSomeFieldsAreFilledAndBoardProperlyDisplayed(){
        String expected = "   " + 0 + "   " + 1 + "   " + 2 + "\n" + 0 + "  X |   |   \n  -----------\n" + 1 + "    | O |   \n  -----------\n" + 2 + "    |   | O ";
        board.makeMove(MARK.X,0,0);
        board.makeMove(MARK.O,1,1);
        board.makeMove(MARK.O,2,2);
        assertEquals(expected, gameView.showBoard(board).toString());
    }


}