package tictactoe;

import java.util.Scanner;

public class GameMenu {
    private static StringBuilder display = new StringBuilder();
    private Game game;

    public Game getGame() {
        return game;
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println(mainMenu());
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 2);
        if (choice == 1) {
            String name;
            System.out.println(nameMenu());
            Scanner scanner1 = new Scanner(System.in);
            name = scanner1.nextLine();
            do {
                System.out.println(markMenu());
                choice = scanner.nextInt();
            } while (choice < 1 || choice > 2);
            startGame(choice, name);
        }
    }

    public static StringBuilder mainMenu() {
        display.delete(0, display.length());
        display.append("#############################################\n#                MENU GRY                   #\n#");
        display.append("                                           #\n# Wybierz:                                  #\n#");
        display.append(" 1 - Rozpocznij nową grę                   #\n# 2 - Wyjdź                                 #\n#");
        display.append("############################################");
        return display;
    }

    public static StringBuilder nameMenu() {
        display.delete(0, display.length());
        display.append("#############################################\n#                    IMIĘ                   #\n#");
        display.append("                                           #\n# Podaj swoje imię:                         #\n#");
        display.append("                                           #\n#");
        display.append("############################################");
        return display;
    }

    public static StringBuilder markMenu() {
        display.delete(0, display.length());
        display.append("#############################################\n#                WYBÓR SYMBOLU              #\n#");
        display.append("                                           #\n# Wybierz swój symbol:                      #\n#");
        display.append(" 1 - X                                     #\n# 2 - O                                     #\n#");
        display.append("############################################");
        return display;
    }
    public void startGame(int choice, String name) {
        MARK[] marks = assignMarks(choice);
        createGame(marks, name);
        game.play();
    }

    public static MARK[] assignMarks(int choice){
        MARK[] marks = new MARK[2];
        switch (choice) {
            case 1:
                marks[0] = MARK.X;
                marks[1] = MARK.O;
                break;
            default:
                marks[0] = MARK.O;
                marks[1] = MARK.X;
                break;
        }
        return marks;
    }

    public void createGame(MARK[] marks, String name) {
        game = new Game(new HumanPlayer(marks[0], name), new PCPlayer(marks[1]), new Board());
    }
}
