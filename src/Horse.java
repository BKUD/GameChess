public class Horse extends ChessPiece {
    public Horse(String color) {
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
        } else if (Math.abs(line - toLine) == 2 && Math.abs(column - toColumn) == 1) {
            // check if destination is empty or occupied by opponent
            ChessPiece piece = chessBoard.board[toLine][toColumn];
            if (piece == null || !piece.getColor().equals(color)) {
                return true;
            }
        } else if (Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 2) {
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
        return "H";
    }
}