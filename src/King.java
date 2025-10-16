import java.util.ArrayList;

public class King extends ChessPiece{

    public King(BoardPosition position, int color) {
        super(position, color);
    }

    @Override
    public ArrayList<BoardPosition> findPossibleMoves(ChessBoard board) {
        return null;
    }

    public void setPossibleMoves() {

    }

    @Override
    public String getName() {
        return "King:" + this.color;
    }
}
