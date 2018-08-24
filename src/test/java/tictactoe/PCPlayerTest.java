package tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PCPlayerTest {

    @Test
    public void shouldCreateNewPCPlayerInstance(){
        PCPlayer PCPlayer = new PCPlayer(MARK.O);
        assertNotNull(PCPlayer);
    }

    @Test
    public void shouldReturnTrueIfValuesChosenAreWithinRange(){
        PCPlayer PCPlayer = new PCPlayer(MARK.O);
        int[] chosenField;
        chosenField = PCPlayer.chooseField();
        assertTrue(chosenField[0] >=0 && chosenField[0] <=2);
        assertTrue(chosenField[1] >=0 && chosenField[1] <=2);
    }

}