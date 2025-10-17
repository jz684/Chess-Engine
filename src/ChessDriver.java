public class ChessDriver {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        board.newBoard();
        board.updateBoard();
        board.printBoard();
        board.movePiece(board.getPieceAt(new BoardPosition('e', 2)), new BoardPosition('e', 4));
        board.printBoard();
        board.movePiece(board.getPieceAt(new BoardPosition('f', 1)), new BoardPosition('c', 4));
        board.printBoard();
//        board.getPieceAt(new BoardPosition('c', 4)).printPossibleMoves();
        board.movePiece(board.getPieceAt(new BoardPosition('b', 1)), new BoardPosition('c', 3));
        board.getPieceAt(new BoardPosition('c', 3)).printPossibleMoves();

    }

}
