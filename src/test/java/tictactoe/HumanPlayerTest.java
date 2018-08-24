package tictactoe;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

public class HumanPlayerTest {

    @Test
    public void shouldCreateNewHumanPlayerInstance(){
        HumanPlayer humanPlayer = new HumanPlayer(MARK.O, "Ty");
        assertNotNull(humanPlayer);
    }

    @Test
    public void shouldReturnValuesIfProperCellSelectedWhenDataProvidedToInputStrem(){
        HumanPlayer humanPlayer = new HumanPlayer(MARK.O, "Ty");
        int[] chosenField;
        String data = "2,2";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            chosenField = humanPlayer.chooseField();
        } finally {
            System.setIn(stdin);
        }
        assertArrayEquals(chosenField, new int[] {2,2});
    }

}