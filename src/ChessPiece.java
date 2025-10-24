import javax.swing.*;
import java.util.ArrayList;

public abstract class ChessPiece extends BoardPosition{
    // 0: My Side
    // 1: Opponent Side
    int color;
    ArrayList<BoardPosition> possibleMoves;
    ImageIcon pieceIcon;

    public ChessPiece() {
        super();
        this.color = 0;
        pieceIcon = null;
    }

    public ChessPiece(BoardPosition position, int color) {
        super(position);
        this.color = color;
        pieceIcon = null;
    }

    public void setImage(ImageIcon pieceIcon) {
        this.pieceIcon = pieceIcon;
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

    public ImageIcon getImage() {
        return pieceIcon;
    }

    public abstract ImageIcon findImage(int color);

    public abstract ArrayList<BoardPosition> findPossibleMoves(ChessBoard board);

    public abstract String getName();

    public void printPossibleMoves() {
        for (BoardPosition position : possibleMoves) {
            System.out.print(position.toString() + ", ");
        }
        System.out.println();
    }

}
