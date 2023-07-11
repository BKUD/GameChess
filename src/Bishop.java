public class Bishop extends ChessPiece {
    public Bishop(String color) {
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
        } else if (Math.abs(line - toLine) == Math.abs(column - toColumn)) {
            // check if path is clear
            int x = line < toLine ? 1 : -1;
            int y = column < toColumn ? 1 : -1;
            int i = line + x;
            int j = column + y;
            while (i != toLine && j != toColumn) {
                if (chessBoard.board[i][j] != null) {
                    return false;
                }
                i += x;
                j += y;
            }
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
        return "B";
    }
}