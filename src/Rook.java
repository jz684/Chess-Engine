import java.util.ArrayList;

public class Rook extends ChessPiece{

    public Rook(BoardPosition position, int color) {
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
        return "Rook:" + this.color;
    }
}
