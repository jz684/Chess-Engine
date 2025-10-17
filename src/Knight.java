import java.util.ArrayList;

public class Knight extends ChessPiece{

    public Knight(BoardPosition position, int color) {
        super(position, color);
    }

    @Override
    public ArrayList<BoardPosition> findPossibleMoves(ChessBoard board) {
        // Hardcoding knight moves
        ArrayList<BoardPosition> possibleMoves = new ArrayList<>(); // Return

        BoardPosition currentPosition = this; // The current pos of the piece into a BoardPosition

        BoardPosition frontLeft = new BoardPosition((char) (currentPosition.column + 2), currentPosition.row - 1);
        if (board.isEmpty(frontLeft))
            possibleMoves.add(frontLeft);

        BoardPosition frontRight = new BoardPosition((char) (currentPosition.column + 2), currentPosition.row + 1);
        if (board.isEmpty(frontRight))
            possibleMoves.add(frontRight);

        BoardPosition rightUp = new BoardPosition((char) (currentPosition.column + 1), currentPosition.row + 2);
        if (board.isEmpty(rightUp))
            possibleMoves.add(rightUp);

        BoardPosition rightDown = new BoardPosition((char) (currentPosition.column - 1), currentPosition.row + 2);
        if (board.isEmpty(rightDown))
            possibleMoves.add(rightDown);

        BoardPosition backRight = new BoardPosition((char) (currentPosition.column - 2), currentPosition.row + 1);
        if (board.isEmpty(backRight))
            possibleMoves.add(backRight);

        BoardPosition backLeft = new BoardPosition((char) (currentPosition.column - 2), currentPosition.row - 1);
        if (board.isEmpty(backLeft))
            possibleMoves.add(backLeft);

        BoardPosition leftDown = new BoardPosition((char) (currentPosition.column - 1), currentPosition.row - 2);
        if (board.isEmpty(leftDown))
            possibleMoves.add(leftDown);

        BoardPosition leftUp = new BoardPosition((char) (currentPosition.column + 1), currentPosition.row - 2);
        if (board.isEmpty(leftUp))
            possibleMoves.add(leftUp);

        return possibleMoves;
    }

    public void setPossibleMoves() {

    }

    @Override
    public String getName() {
        return "Knight:" + this.color;
    }
}
