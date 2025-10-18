import java.util.ArrayList;

public class King extends ChessPiece{

    public King(BoardPosition position, int color) {
        super(position, color);
    }

    @Override
    public ArrayList<BoardPosition> findPossibleMoves(ChessBoard board) {
        ArrayList<BoardPosition> possibleMoves = new ArrayList<>(); // Return

        BoardPosition currentPosition = this; // The current pos of the piece into a BoardPosition

        BoardPosition testPosition = new BoardPosition();

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                testPosition = new BoardPosition((char) (currentPosition.column - 1 + c), currentPosition.row - 1 + r);
                if (r != 1 && c != 1) {
                    if (board.isEmpty(testPosition)) {
                        possibleMoves.add(testPosition);
                    }
                    // Code to find the color at the next piece, and add it to the arraylist if it is the opposite color
                    else if (testPosition.isNotOutOfBounds() && !board.isEmpty(testPosition) && board.getPieceAt(testPosition).color != this.color) {
                        possibleMoves.add(testPosition);
                    }
                }
            }
        }


        return possibleMoves;
    }


    @Override
    public String getName() {
        return " King:" + this.color + " ";
    }
}
