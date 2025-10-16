public abstract class ChessPiece extends BoardPosition{
    // 0: My Side
    // 1: Opponent Side
    private int color;
    private BoardPosition[] possibleMoves;

    public ChessPiece() {
        super();
        this.color = 0;
    }

    public ChessPiece(BoardPosition position, int color) {
        super(position);
        this.color = color;
    }

    public BoardPosition[] getPossibleMoves() {
        return possibleMoves;
    }

    public abstract void setPossibleMoves();
}
