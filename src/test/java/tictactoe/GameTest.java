package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;
    private GameView gameView;

    @Before
    public void setup() {
        game = new Game(new HumanPlayer(MARK.X, "Ty"), new PCPlayer(MARK.O), new Board());
        gameView = new GameView();
    }

    @Test
    public void shouldCreateNewGameInstance() {
        assertNotNull(game);
    }

    @Test
    public void shouldReturnTrueWhenReceivingMoveFromAPlayer() {
        String data = "2,2";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            game.retrieveMoves(gameView, new HumanPlayer(MARK.X, "Ty"));
        } finally {
            System.setIn(stdin);
        }
        assertTrue(game.getBoard().isFilled(2, 2));
    }

    @Test
    public void shouldReturnTrueIfRecievesMovesFromTwoPlayers() {
        String data = "0,0";
        game.getBoard().makeMove(MARK.X,0,1);
        game.getBoard().makeMove(MARK.O,2,2);
        game.getBoard().makeMove(MARK.X,1,1);
        game.getBoard().makeMove(MARK.O,1,0);
        game.getBoard().makeMove(MARK.X,1,2);
        game.getBoard().makeMove(MARK.X,2,0);
        game.getBoard().makeMove(MARK.O,2,1);
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            game.retrieveMoves(gameView, new HumanPlayer(MARK.X, "Ty"));
        } finally {
            System.setIn(stdin);
        }
        game.retrieveMoves(gameView, new PCPlayer(MARK.O));
        assertTrue(game.getBoard().isFilled(0, 0));
        assertTrue(game.getBoard().isFilled(0, 2));
    }

    @Test
    public void shouldReturnTrueIfMoveIsMadeAndBoardHasProperSymbolOfEachPlayer() {
        String data = "0,0";
        game.getBoard().makeMove(MARK.X,0,1);
        game.getBoard().makeMove(MARK.O,0,2);
        game.getBoard().makeMove(MARK.X,1,1);
        game.getBoard().makeMove(MARK.O,1,0);
        game.getBoard().makeMove(MARK.X,1,2);
        game.getBoard().makeMove(MARK.X,2,0);
        game.getBoard().makeMove(MARK.O,2,1);

        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            game.retrieveMoves(gameView, new HumanPlayer(MARK.X, "Ty"));
        } finally {
            System.setIn(stdin);
        }
        game.retrieveMoves(gameView, new PCPlayer(MARK.O));
        assertEquals(MARK.X, game.getBoard().getValue(0, 0));
        assertEquals(MARK.O, game.getBoard().getValue(2, 2));
    }

    @Test
    public void shouldReturnTrueIfSomebodyWinsAndNoFurtherMovesAreRetrieved() {
        String data = "2,2";
        game.getBoard().makeMove(MARK.X, 0, 0);
        game.getBoard().makeMove(MARK.X, 1, 1);
        game.getBoard().makeMove(MARK.O, 0, 1);
        game.getBoard().makeMove(MARK.O, 0, 2);
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            game.retrieveMoves(gameView, new HumanPlayer(MARK.X, "Ty"));
            game.play();
        } finally {
            System.setIn(stdin);
        }
        assertEquals(MARK.X, BoardVerifier.isBoardResolved(game.getBoard()));
        assertEquals("Wygrałeś!", game.checkGameResult());
        assertTrue(!game.getBoard().isFilled(1, 0));
        assertTrue(!game.getBoard().isFilled(1, 2));
        assertTrue(!game.getBoard().isFilled(2, 0));
        assertTrue(!game.getBoard().isFilled(2, 1));
    }

    @Test
    public void shouldReturnTrueIfBoardIsFullyResolvedWithoutAWinner() {
        String data = "1,2";
        game.getBoard().makeMove(MARK.X, 0, 1);
        game.getBoard().makeMove(MARK.X, 1, 0);
        game.getBoard().makeMove(MARK.X, 2, 2);
        game.getBoard().makeMove(MARK.X, 2, 0);
        game.getBoard().makeMove(MARK.O, 0, 0);
        game.getBoard().makeMove(MARK.O, 0, 2);
        game.getBoard().makeMove(MARK.O, 2, 1);
        game.getBoard().makeMove(MARK.O, 1, 1);
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            game.retrieveMoves(gameView, new HumanPlayer(MARK.X, "Ty"));
        } finally {
            System.setIn(stdin);
        }
        assertEquals("Remis!", game.checkGameResult());
    }

    @Test
    public void shouldReturnTrueIfGameReceivesFullyResolvedBoardAndGameDisplaysCorrectResultAndNoFurtherMovesAreRetrieved() {
        game.getBoard().makeMove(MARK.X, 0, 1);
        game.getBoard().makeMove(MARK.X, 1, 0);
        game.getBoard().makeMove(MARK.X, 2, 2);
        game.getBoard().makeMove(MARK.X, 2, 0);
        game.getBoard().makeMove(MARK.X, 1, 2);
        game.getBoard().makeMove(MARK.O, 0, 0);
        game.getBoard().makeMove(MARK.O, 0, 2);
        game.getBoard().makeMove(MARK.O, 2, 1);
        game.getBoard().makeMove(MARK.O, 1, 1);
        game.play();
        assertTrue(BoardVerifier.isBoardFullyFilled(game.getBoard()));
        assertEquals("Remis!", game.checkGameResult());
    }
}