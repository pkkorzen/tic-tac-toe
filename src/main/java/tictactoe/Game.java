package tictactoe;

import java.util.Random;

public class Game {

    private Player humanPlayer;
    private Player pcPlayer;
    private Board board;
    private Player firstPlayer;
    private Player secondPlayer;

    public Game(Player humanPlayer, Player pcPlayer, Board board) {
        this.humanPlayer = humanPlayer;
        this.pcPlayer = pcPlayer;
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public void play() {
        GameView gameView = new GameView();
        if (!BoardVerifier.isBoardResolved(board).equals(MARK.NEUTRAL)) {
            checkGameResult();
            displayGameResult(gameView, checkGameResult());
        } else {
            determineFirstPlayer();
            while (BoardVerifier.isBoardResolved(board).equals(MARK.NEUTRAL)) {
                retrieveMoves(gameView, firstPlayer);
                if (!BoardVerifier.isBoardResolved(board).equals(MARK.NEUTRAL)) {
                    checkGameResult();
                    displayGameResult(gameView, checkGameResult());
                } else {
                    retrieveMoves(gameView, secondPlayer);
                    if (!BoardVerifier.isBoardResolved(board).equals(MARK.NEUTRAL)) {
                        checkGameResult();
                        displayGameResult(gameView, checkGameResult());
                    }
                }
            }
        }
    }

    private void determineFirstPlayer() {
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        if (randomNumber == 0) {
            firstPlayer = humanPlayer;
            secondPlayer = pcPlayer;
        } else {
            firstPlayer = pcPlayer;
            secondPlayer = humanPlayer;
        }
        System.out.println("Zaczyna gracz " + firstPlayer.toString() + "(" + firstPlayer.getMark() + ")");
    }

    private void displayGameResult(GameView gameView, String message) {
        System.out.println(gameView.showBoard(board));
        System.out.println(message);
    }

    public String checkGameResult() {
        if(BoardVerifier.isBoardResolved(board) == humanPlayer.getMark()){
            return "Wygrałeś!";
        } else if(BoardVerifier.isBoardResolved(board) == pcPlayer.getMark()){
            return "Przegrałeś!";
        } else {
            return "Remis!";
        }
    }

    public void retrieveMoves(GameView gameView, Player player) {
        int[] moveCoordinates;
        do {
            if (player == humanPlayer) {
                System.out.println(gameView.showBoard(board));
            }
            moveCoordinates = player.chooseField();
            try {
                board.checkIfLegalMove(moveCoordinates[0], moveCoordinates[1]);
            } catch (IllegalArgumentException e) {
                if (player == humanPlayer) {
                    System.out.println("Nieprawidłowy ruch! Wartości dla wiersza i kolumny muszą być w zakresie 0 - 2.");
                }
            } catch (IllegalStateException e) {
                if (player == humanPlayer) {
                    System.out.println("Nieprawidłowy ruch! Pole jest już zajęte. Wybierz inne pole.");
                }
            }
        }
        while (board.isLegalArgument(moveCoordinates[0], moveCoordinates[1]) || board.isFilled(moveCoordinates[0], moveCoordinates[1]));
        board.makeMove(player.getMark(), moveCoordinates[0], moveCoordinates[1]);
        System.out.println("Gracz " + player.toString() + "(" + player.getMark() + ")" + " wybrał pole: " + moveCoordinates[0] + ", " + moveCoordinates[1]);
        System.out.println();
    }

}
