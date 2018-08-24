package tictactoe;

import java.util.Arrays;

public class BoardVerifier {

    private static MARK[] winningPatternX = new MARK[] {MARK.X, MARK.X, MARK.X};
    private static MARK[] winningPatternO = new MARK[] {MARK.O, MARK.O, MARK.O};

    public static MARK isBoardResolved(Board board) {
        if(!isRowResolved(board).equals(MARK.NEUTRAL)){
            return isRowResolved(board);
        } else if(!isColumnResolved(board).equals(MARK.NEUTRAL)){
            return isColumnResolved(board);
        } else if(!isDiagonalResolved(board).equals(MARK.NEUTRAL)){
            return isDiagonalResolved(board);
        } else if(isBoardFullyFilled(board)){
            return MARK.DRAW;
        } else {
            return MARK.NEUTRAL;
        }
    }

    public static MARK isRowResolved(Board board) {
        for (MARK[] row : board.getGameBoard()) {
            if (Arrays.equals(winningPatternX, row)) {
                return MARK.X;
            } else if(Arrays.equals(winningPatternO, row)){
                return MARK.O;
            }
        }
        return MARK.NEUTRAL;
    }

    public static MARK isColumnResolved(Board board) {
        MARK[] columnArray = new MARK[board.getGameBoard().length];
        for (int i = 0; i < board.getGameBoard().length; i++) {
            for (int j = 0; j < board.getGameBoard()[i].length; j++) {
                columnArray[j] = board.getGameBoard()[j][i];
            }
            if (Arrays.equals(winningPatternX, columnArray)) {
                return MARK.X;
            } else if(Arrays.equals(winningPatternO, columnArray)){
                return MARK.O;
            }
        }
        return MARK.NEUTRAL;
    }

    public static MARK isDiagonalResolved(Board board) {
        MARK[] diagonalArray = new MARK[board.getGameBoard().length];
        for (int i = 0; i < board.getGameBoard().length; i++) {
            diagonalArray[i] = board.getGameBoard()[i][i];
        }
        if (Arrays.equals(winningPatternX, diagonalArray)) {
            return MARK.X;
        } else if (Arrays.equals(winningPatternO, diagonalArray)){
            return MARK.O;
        }
        int j = 0;
        for (int i = board.getGameBoard().length - 1; i >= 0; i--) {
            diagonalArray[i] = board.getGameBoard()[j][i];
            j++;
        }
        if (Arrays.equals(winningPatternX, diagonalArray)) {
            return MARK.X;
        } else if (Arrays.equals(winningPatternO, diagonalArray)){
            return MARK.O;
        }
        return MARK.NEUTRAL;
    }

    public static boolean isBoardFullyFilled(Board board) {
        for (int i = 0; i < board.getGameBoard().length; i++) {
            for (int j = 0; j < board.getGameBoard()[i].length; j++) {
                if (!board.isFilled(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}

