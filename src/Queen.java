import java.util.ArrayList;

public class Queen extends ChessPiece{

    public Queen(BoardPosition position, int color) {
        super(position, color);
    }

    @Override
    public ArrayList<BoardPosition> findPossibleMoves(ChessBoard board) {

        // Just the Rook code + the Bishop code
        ArrayList<BoardPosition> possibleMoves = new ArrayList<>(); // Return
        BoardPosition currentPosition = this;
        BoardPosition testPosition = new BoardPosition();

        int index = 1;
        // Forward
        testPosition = new BoardPosition(currentPosition.column, currentPosition.row + index);
        while (testPosition.isNotOutOfBounds() && board.isEmpty(testPosition)) {
            possibleMoves.add(testPosition);
            index++;
            testPosition = new BoardPosition(currentPosition.column, currentPosition.row + index);
        }
        if (testPosition.isNotOutOfBounds() && !board.isEmpty(testPosition) && board.getPieceAt(testPosition).color != this.color) {
            possibleMoves.add(testPosition);
        }

        index = 1;
        // Rightward
        testPosition = new BoardPosition(currentPosition.column, currentPosition.row + index);
        while (board.isEmpty(testPosition)) {
            possibleMoves.add(testPosition);
            index++;
            testPosition = new BoardPosition(currentPosition.column, currentPosition.row + index);
        }
        testPosition = new BoardPosition(currentPosition.column, currentPosition.row + index);
        if (testPosition.isNotOutOfBounds() && !board.isEmpty(testPosition) && board.getPieceAt(testPosition).color != this.color) {
            possibleMoves.add(testPosition);
        }

        index = 1;
        // Backward
        testPosition = new BoardPosition(currentPosition.column, currentPosition.row + index);
        while (board.isEmpty(testPosition)) {
            possibleMoves.add(testPosition);
            index++;
            testPosition = new BoardPosition(currentPosition.column, currentPosition.row + index);
        }
        testPosition = new BoardPosition(currentPosition.column, currentPosition.row + index);
        if (testPosition.isNotOutOfBounds() && !board.isEmpty(testPosition) && board.getPieceAt(testPosition).color != this.color) {
            possibleMoves.add(testPosition);
        }

        index = 1;
        // Leftward
        testPosition = new BoardPosition(currentPosition.column, currentPosition.row + index);
        while (board.isEmpty(testPosition)) {
            possibleMoves.add(testPosition);
            index++;
            testPosition = new BoardPosition(currentPosition.column, currentPosition.row + index);
        }
        testPosition = new BoardPosition(currentPosition.column, currentPosition.row + index);
        if (testPosition.isNotOutOfBounds() && !board.isEmpty(testPosition) && board.getPieceAt(testPosition).color != this.color) {
            possibleMoves.add(testPosition);
        }

        int xDiff = -1;
        int yDiff = 1;

        // While the position is empty, keep checking till it comes up
        testPosition = new BoardPosition((char) (currentPosition.column - xDiff), currentPosition.row - yDiff);
        while (testPosition.isNotOutOfBounds() && board.isEmpty(testPosition)){
            possibleMoves.add(testPosition);
            xDiff--;
            yDiff++;
            testPosition = new BoardPosition((char) (currentPosition.column - xDiff), currentPosition.row - yDiff);
        }

        // Code to find the color at the next piece, and add it to the arraylist if it is the opposite color
        testPosition = new BoardPosition((char) (currentPosition.column - xDiff), currentPosition.row - yDiff);
        if (testPosition.isNotOutOfBounds() && !board.isEmpty(testPosition) && board.getPieceAt(testPosition).color != this.color) {
            possibleMoves.add(testPosition);
        }
        xDiff = 1;
        yDiff = 1;

        // While the position is empty, keep checking till it comes up
        testPosition = new BoardPosition((char) (currentPosition.column - xDiff), currentPosition.row - yDiff);
        while (testPosition.isNotOutOfBounds() && board.isEmpty(testPosition)){
            possibleMoves.add(testPosition);
            xDiff++;
            yDiff++;
            testPosition = new BoardPosition((char) (currentPosition.column - xDiff), currentPosition.row - yDiff);
        }

        // Code to find the color at the next piece, and add it to the arraylist if it is the opposite color
        testPosition = new BoardPosition((char) (currentPosition.column - xDiff), currentPosition.row - yDiff);
        if (testPosition.isNotOutOfBounds() && !board.isEmpty(testPosition) && board.getPieceAt(testPosition).color != this.color) {
            possibleMoves.add(testPosition);
        }
        xDiff = 1;
        yDiff = -1;

        // While the position is empty, keep checking till it comes up
        testPosition = new BoardPosition((char) (currentPosition.column - xDiff), currentPosition.row - yDiff);
        while (testPosition.isNotOutOfBounds() && board.isEmpty(testPosition)){
            possibleMoves.add(testPosition);
            xDiff++;
            yDiff--;
            testPosition = new BoardPosition((char) (currentPosition.column - xDiff), currentPosition.row - yDiff);
        }

        // Code to find the color at the next piece, and add it to the arraylist if it is the opposite color
        testPosition = new BoardPosition((char) (currentPosition.column - xDiff), currentPosition.row - yDiff);
        if (testPosition.isNotOutOfBounds() && !board.isEmpty(testPosition) && board.getPieceAt(testPosition).color != this.color) {
            possibleMoves.add(testPosition);
        }
        xDiff = -1;
        yDiff = -1;

        // While the position is empty, keep checking till it comes up
        testPosition = new BoardPosition((char) (currentPosition.column - xDiff), currentPosition.row - yDiff);
        while (testPosition.isNotOutOfBounds() && board.isEmpty(testPosition)){
            possibleMoves.add(testPosition);
            xDiff--;
            yDiff--;
            testPosition = new BoardPosition((char) (currentPosition.column - xDiff), currentPosition.row - yDiff);
        }

        // Code to find the color at the next piece, and add it to the arraylist if it is the opposite color
        testPosition = new BoardPosition((char) (currentPosition.column - xDiff), currentPosition.row - yDiff);
        if (testPosition.isNotOutOfBounds() && !board.isEmpty(testPosition) && board.getPieceAt(testPosition).color != this.color) {
            possibleMoves.add(testPosition);
        }

        return possibleMoves;
    }

    @Override
    public String getName() {
        return "Queen:" + this.color;
    }
}
