import java.util.ArrayList;

public class Bishop extends ChessPiece{

    public Bishop(BoardPosition position, int color) {
        super(position, color);

    }

    public ArrayList<BoardPosition> findPossibleMoves(ChessBoard board) {
        ArrayList<BoardPosition> possibleMoves = new ArrayList<>();

        BoardPosition currentPosition = this;
        int xDiff = -1;
        int yDiff = 1;

        // While the position is empty, keep checking till it comes up
        while (board.isEmpty(new BoardPosition((char) (currentPosition.column - xDiff), currentPosition.row - yDiff))){
            possibleMoves.add(new BoardPosition((char) (currentPosition.column - xDiff), currentPosition.row - yDiff));
            xDiff--;
            yDiff++;
        }
        xDiff = 1;
        yDiff = 1;

        // While the position is empty, keep checking till it comes up
        while (board.isEmpty(new BoardPosition((char) (currentPosition.column - xDiff), currentPosition.row - yDiff))){
            possibleMoves.add(new BoardPosition((char) (currentPosition.column - xDiff), currentPosition.row - yDiff));
            xDiff++;
            yDiff++;
        }
        xDiff = 1;
        yDiff = -1;

        // While the position is empty, keep checking till it comes up
        while (board.isEmpty(new BoardPosition((char) (currentPosition.column - xDiff), currentPosition.row - yDiff))){
            possibleMoves.add(new BoardPosition((char) (currentPosition.column - xDiff), currentPosition.row - yDiff));
            xDiff++;
            yDiff--;
        }
        xDiff = -1;
        yDiff = -1;

        // While the position is empty, keep checking till it comes up
        while (board.isEmpty(new BoardPosition((char) (currentPosition.column - xDiff), currentPosition.row - yDiff))){
            possibleMoves.add(new BoardPosition((char) (currentPosition.column - xDiff), currentPosition.row - yDiff));
            xDiff--;
            yDiff--;
        }
        return possibleMoves;
    }

    @Override
    public String getName() {
        return "Bishop:" + this.color;
    }
}
