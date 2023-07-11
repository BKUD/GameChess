public class Queen extends ChessPiece {
    public Queen(String color) {
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
        } else if (line == toLine || column == toColumn || Math.abs(line - toLine) == Math.abs(column - toColumn)) {
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
            } else if (column == toColumn) {
                start = Math.min(line, toLine);
                end = Math.max(line, toLine);
                for (int i = start + 1; i < end; i++) {
                    if (chessBoard.board[i][column] != null) {
                        return false;
                    }
                }
            } else {
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
        return "Q";
    }
}