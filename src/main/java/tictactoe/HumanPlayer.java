package tictactoe;

import java.util.Scanner;

public class HumanPlayer extends Player {

    private String name;

    public HumanPlayer(MARK mark, String name) {
        super(mark);
        this.name = name;
    }

    @Override
    public int[] chooseField() {
        String[] coordinates;
        int[] moveCoordinates = new int[2];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wybraną komórkę w formacie: a,b. Gdzie a = wiersz, b = kolumna.");
        coordinates = scanner.nextLine().replaceAll(" ", "").split(",");
        moveCoordinates[0] = Integer.parseInt(coordinates[0]);
        moveCoordinates[1] = Integer.parseInt(coordinates[1]);
        return moveCoordinates;
    }

    @Override
    public String toString() {
        return name;
    }
}
