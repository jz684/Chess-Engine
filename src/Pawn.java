import java.util.ArrayList;

public class Pawn extends ChessPiece{

    public Pawn() {
        super();
    }

    public Pawn(BoardPosition position, int color) {
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
        return "Pawn:" + this.color;
    }
}
