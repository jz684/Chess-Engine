import java.util.ArrayList;

public abstract class ChessPiece extends BoardPosition{
    // 0: My Side
    // 1: Opponent Side
    int color;
    ArrayList<BoardPosition> possibleMoves;

    public ChessPiece() {
        super();
        this.color = 0;
    }

    public ChessPiece(BoardPosition position, int color) {
        super(position);
        this.color = color;
    }

    public void init(ChessBoard board) {
        possibleMoves = findPossibleMoves(board);
    }

    public ArrayList<BoardPosition> getPossibleMoves() {
        return possibleMoves;
    }

    public void setPossibleMoves(ArrayList<BoardPosition> positions) {
        this.possibleMoves = positions;
    }

    public abstract ArrayList<BoardPosition> findPossibleMoves(ChessBoard board);

    public abstract String getName();

    public void printPossibleMoves() {
        for (BoardPosition position : possibleMoves) {
            System.out.print(position.toString() + ", ");
        }
        System.out.println();
    }

}
