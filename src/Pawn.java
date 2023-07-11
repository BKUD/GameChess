public class Pawn extends ChessPiece {
    public Pawn(String color) {
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
        } else if (color.equals("White") && line == 1 && toLine == 3 && column == toColumn && chessBoard.board[2][column] == null) {
            // check if path is clear
            return true;
        } else if (color.equals("Black") && line == 6 && toLine == 4 && column == toColumn && chessBoard.board[5][column] == null) {
            // check if path is clear
            return true;
        } else if (color.equals("White") && toLine - line == 1 && column == toColumn) {
            // check if destination is empty
            ChessPiece piece = chessBoard.board[toLine][toColumn];
            if (piece == null) {
                return true;
            }
        } else if (color.equals("Black") && line - toLine == 1 && column == toColumn) {
            // check if destination is empty
            ChessPiece piece = chessBoard.board[toLine][toColumn];
            if (piece == null) {
                return true;
            }
        } else if (color.equals("White") && toLine - line == 1 && Math.abs(column - toColumn) == 1) {
            // check if destination is occupied by opponent
            ChessPiece piece = chessBoard.board[toLine][toColumn];
            if (piece != null && !piece.getColor().equals(color)) {
                return true;
            }
        } else if (color.equals("Black") && line - toLine == 1 && Math.abs(column - toColumn) == 1) {
            // check if destination is occupied by opponent
            ChessPiece piece = chessBoard.board[toLine][toColumn];
            if (piece != null && !piece.getColor().equals(color)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}