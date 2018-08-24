package tictactoe;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameMenuTest {

    private static GameMenu gameMenu;
    private static StringBuilder expected;

    @BeforeClass
    public static void setup(){
        gameMenu = new GameMenu();
        expected = new StringBuilder();
    }

    @Test
    public void shouldReturnTrueIfPrintsCorrectMainMenu(){
        expected.delete(0, expected.length());
        expected.append("#############################################\n#                MENU GRY                   #\n#");
        expected.append("                                           #\n# Wybierz:                                  #\n#");
        expected.append(" 1 - Rozpocznij nową grę                   #\n# 2 - Wyjdź                                 #\n#");
        expected.append("############################################");
        assertEquals(expected.toString(), GameMenu.mainMenu().toString());
    }

    @Test
    public void shouldReturnTrueIfPrintsCorrectNameMenu(){
        expected.delete(0, expected.length());
        expected.append("#############################################\n#                    IMIĘ                   #\n#");
        expected.append("                                           #\n# Podaj swoje imię:                         #\n#");
        expected.append("                                           #\n#");
        expected.append("############################################");
        assertEquals(expected.toString(), GameMenu.nameMenu().toString());
    }

    @Test
    public void shouldReturnTrueIfPrintsCorrectMarkMenu(){
        expected.delete(0, expected.length());
        expected.append("#############################################\n#                WYBÓR SYMBOLU              #\n#");
        expected.append("                                           #\n# Wybierz swój symbol:                      #\n#");
        expected.append(" 1 - X                                     #\n# 2 - O                                     #\n#");
        expected.append("############################################");
        assertEquals(expected.toString(), GameMenu.markMenu().toString());
    }

    @Test
    public void shouldReturnTrueIfAssignsCorrectMark(){
        assertEquals(MARK.X, GameMenu.assignMarks(1)[0]);
        assertEquals(MARK.O, GameMenu.assignMarks(2)[0]);
    }

    @Test
    public void shouldReturnTrueIfGameInstanceIsCreated(){
        gameMenu.createGame(new MARK[] {MARK.X, MARK.O}, "Adam");
        assertNotNull(gameMenu.getGame());
    }
}