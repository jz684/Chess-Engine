import java.util.ArrayList;

public class ChessBoard {
    private ChessPiece[][] board;

    King blackKing;
    King whiteKing;

    public ChessBoard() {
        blackKing = new King(new BoardPosition('e', 8), 0);
        whiteKing = new King(new BoardPosition('e', 1), 1);
        this.board = newBoard();
    }

    public ChessBoard(ChessPiece[][] board) {
        this.board = board;
    }

    public boolean validMove(ChessPiece piece, BoardPosition position) {
        ArrayList<BoardPosition> possibleMoves = piece.findPossibleMoves(this);

        for (BoardPosition move : possibleMoves) {
            if (move.equals(position)) {
                return true;
            }
        }
        return false;
    }

    // boolean inCheck(King k) is used for telling if you are in check at this moment
    public boolean inCheck(King king) {
        for (int r = 0; r < board.length; r++) {

            for (int c = 0; c <board[0].length; c++) {

                if (board[r][c] != null && board[r][c].color == king.color) {

//                    System.out.println(board[r][c].getName());
//                    System.out.println(board[r][c].toString());
//                    board[r][c].printPossibleMoves();
//                    System.out.println(king.toString());
                    ArrayList<BoardPosition> possibleMoves = board[r][c].getPossibleMoves();
                    for (BoardPosition move : possibleMoves) {
                        if (move.equals(king)) {
                            return true;
                        }
                    }
                }
            }
        }
        System.out.println("In check inCheck(king)");
        return false;
    }

    // boolean inChecking(ChessPiece p, BoardPosition pos) is used for if moving will put you in check.
    public boolean inCheck(ChessPiece piece, BoardPosition position) {
        // Index through every piece on the board that isn't yours. if one of their possible moves

        // A temp board to test if this move would put my king in check.
        ChessBoard testBoard = this;
        ChessPiece[][] board = testBoard.board;
        King king = findKing(piece);

        testBoard.tryMovePiece(piece, position);

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c <board[0].length; c++) {
                if (board[r][c] != null) {
                    ArrayList<BoardPosition> possibleMoves = board[r][c].getPossibleMoves();
                    for (BoardPosition move : possibleMoves) {
                        if (move.equals(king)) {
                            return true;
                        }
                    }
                }

            }
        }
        return false;


    }

    // Simple function to find which king is being played based on the piece it was given
    public King findKing(ChessPiece piece) {
        if (piece.color == 0)
            return whiteKing;
        else
            return blackKing;
    }

    // TODO write the boolean valid move that checks for checks and valid moves.

    public void movePiece(BoardPosition piecePosition, BoardPosition targetPosition) {
        movePiece(getPieceAt(piecePosition), targetPosition);
    }

    public void tryMovePiece(ChessPiece piece, BoardPosition position) {

        // if it is a valid move and the king is not in check.
//            System.out.println("Twas a valid move");
        board[Math.abs(piece.row - 8)][piece.column - 97] = null;
        board[Math.abs(position.row - 8)][position.column - 97] = piece;

        piece.move(position);
        updateBoard();

    }

    public void movePiece(ChessPiece piece, BoardPosition position) {

        // if it is a valid move and the king is not in check.
//            System.out.println("Twas a valid move");
        if (validMove(piece, position)){
            if (!inCheck(piece, position)){
                board[Math.abs(piece.row - 8)][piece.column - 97] = null;
                board[Math.abs(position.row - 8)][position.column - 97] = piece;

                piece.move(position);
                updateBoard();

                // TODO switchSides() that swaps who can move pieces after each move

            }
            else
                System.out.println("In check: " + piece.getName() + " " + piece.toString() + " - " + position.toString());
        }
        else {
            System.out.println("Invalid Move!");
        }
    }

    public ChessPiece getPieceAt(BoardPosition position) {
        return board[Math.abs(position.row - 8)][position.column - 97];
    }

    public void updateBoard() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] != null) {
                    board[r][c].init(this);
                }
            }
        }
    }

    public boolean isEmpty(BoardPosition position) {
        try {
            return board[Math.abs(position.row - 8)][position.column - 97] == null &&
                    (position.row > 0 && position.row < 9) && (position.column > 96 && position.column < 105);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }


    }

    public void printBoard() {
        for (ChessPiece[] pieces : board) {
            for (ChessPiece piece : pieces) {
                if (piece == null) {
                    System.out.print("[  null  ]");
                }
                else {
                    System.out.print("[" + piece.getName() + "]");
                }
            }
            System.out.println();
        }
    }

    public ChessPiece[][] newBoard() {
        ChessPiece[][] board = new ChessPiece[8][8];
        board[0] = new ChessPiece[]{new Rook(new BoardPosition('a', 8), 1),
                new Knight(new BoardPosition('b', 8), 1),
                new Bishop(new BoardPosition('c', 8), 1),
                new Queen(new BoardPosition('d', 8), 1),
                whiteKing,
                new Bishop(new BoardPosition('f', 8), 1),
                new Knight(new BoardPosition('g', 8), 1),
                new Rook(new BoardPosition('h', 8), 1)};

        board[1] = new ChessPiece[]{new Pawn(new BoardPosition('a', 7), 1),
                new Pawn(new BoardPosition('b', 7), 1),
                new Pawn(new BoardPosition('c', 7), 1),
                new Pawn(new BoardPosition('d', 7), 1),
                new Pawn(new BoardPosition('e', 7), 1),
                new Pawn(new BoardPosition('f', 7), 1),
                new Pawn(new BoardPosition('g', 7), 1),
                new Pawn(new BoardPosition('h', 7), 1)};

        board[6] = new ChessPiece[]{new Pawn(new BoardPosition('a', 2), 0),
                new Pawn(new BoardPosition('b', 2), 0),
                new Pawn(new BoardPosition('c', 2), 0),
                new Pawn(new BoardPosition('d', 2), 0),
                new Pawn(new BoardPosition('e', 2), 0),
                new Pawn(new BoardPosition('f', 2), 0),
                new Pawn(new BoardPosition('g', 2), 0),
                new Pawn(new BoardPosition('h', 2), 0)};

        board[7] = new ChessPiece[]{new Rook(new BoardPosition('a', 1), 0),
                new Knight(new BoardPosition('b', 1), 0),
                new Bishop(new BoardPosition('c', 1), 0),
                new Queen(new BoardPosition('d', 1), 0),
                blackKing,
                new Bishop(new BoardPosition('f', 1), 0),
                new Knight(new BoardPosition('g', 1), 0),
                new Rook(new BoardPosition('h', 1), 0)};

        return board;
    }


}
