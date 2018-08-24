package tictactoe;

public abstract class Player {

    private MARK mark;

    public Player(MARK mark) {
        this.mark = mark;
    }

    public MARK getMark() {
        return mark;
    }

    public abstract int[] chooseField();
}
