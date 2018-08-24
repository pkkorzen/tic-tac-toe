package tictactoe;

import java.util.Random;

public class PCPlayer extends Player {

    public PCPlayer(MARK mark) {
        super(mark);
    }

    @Override
    public int[] chooseField() {
        int[] moveCoordinates = new int[2];
        Random random = new Random();
        moveCoordinates[0] = random.nextInt(3);
        moveCoordinates[1] = random.nextInt(3);
        return moveCoordinates;
    }

    @Override
    public String toString() {
        return "komputer";
    }


}
