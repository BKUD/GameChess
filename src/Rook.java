public class Rook extends ChessPiece {
    public Rook(String color) {
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
        } else if (line == toLine || column == toColumn) {
            // check if path is clear
            int start, end;
            if (line == toLine) {
                start = Math.min(column, toColumn);
                end = Math.max(column, toColumn);
                for (int i = start + 1; i < end; i++) {
                    if (chessBoard.board[line][i] != null) {
                        return false;
                    }
                }
            } else {
                start = Math.min(line, toLine);
                end = Math.max(line, toLine);
                for (int i = start + 1; i < end; i++) {
                    if (chessBoard.board[i][column] != null) {
                        return false;
                    }
                }
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
        return "R";
    }
}