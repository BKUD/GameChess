public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toColumn < 0 || toLine > 7 || toColumn > 7) {
            return false;
        } else if (line == toLine && column == toColumn) {
            return false;
        } else if (Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1) {
            // check if destination is empty or occupied by opponent
            ChessPiece piece = chessBoard.board[toLine][toColumn];
            if (piece == null || !piece.getColor().equals(color)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                ChessPiece piece = board.board[i][j];
                if (piece != null && !piece.getColor().equals(color) && piece.canMoveToPosition(board, i, j, line, column)) {
                    return true;
                }
            }
        }
        return false;

    }
}