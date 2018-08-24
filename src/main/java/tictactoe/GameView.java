package tictactoe;

public class GameView {

    public StringBuilder showBoard(Board board) {
        StringBuilder boardView = new StringBuilder();
        boardView.append("   ").append(0).append("   ").append(1).append("   ").append(2).append("\n");
        for (int i = 0; i < board.getGameBoard().length; i++) {
            boardView.append(i).append(" ");
            for (int j = 0; j < board.getGameBoard()[i].length; j++) {
                boardView.append(" ");
                if (board.getValue(i, j) != null) {
                    if (board.getValue(i, j).equals(MARK.X)) {
                        boardView.append("X");
                    } else {
                        boardView.append("O");
                    }
                } else {
                    boardView.append(" ");
                }
                boardView.append(" ");
                if (j < board.getGameBoard()[i].length - 1) {
                    boardView.append("|");
                }
            }
            if (i < board.getGameBoard().length - 1) {
                boardView.append("\n  -----------\n");
            }
        }
        return boardView;
    }
}
