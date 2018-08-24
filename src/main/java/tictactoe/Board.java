package tictactoe;

public class Board {

    private MARK[][] gameBoard;

    public Board() {
        gameBoard = new MARK[3][3];
    }

    public boolean isClear() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (isFilled(i,j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void makeMove(MARK symbol, int a, int b) {
        gameBoard[a][b] = symbol;
    }

    public MARK[][] getGameBoard() {
        return gameBoard;
    }

    public MARK getValue(int a, int b){
        if(isLegalArgument(a, b)) {
            throw new IllegalArgumentException();
        }
            return gameBoard[a][b];
    }


    public boolean isLegalArgument(int a, int b) {
        return a < 0 || a >= gameBoard.length || b < 0 || b >= gameBoard[0].length;
    }

    public boolean isFilled(int a, int b){
        return gameBoard[a][b] != null;
    }

    public void checkIfLegalMove(int a, int b){
        if(isLegalArgument(a, b)){
            throw new IllegalArgumentException();
        } else if(isFilled(a, b)){
            throw new IllegalStateException();
        }
    }
}
