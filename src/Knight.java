import java.util.ArrayList;

public class Knight extends ChessPiece{

    public Knight(BoardPosition position, int color) {
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
        return "Knight:" + this.color;
    }
}
