import java.util.ArrayList;

public class Queen extends ChessPiece{

    public Queen(BoardPosition position, int color) {
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
        return "Queen:" + this.color;
    }
}
