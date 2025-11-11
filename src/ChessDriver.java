public class ChessDriver {
    public static void main(String[] args) {
//        ChessBoard board = new ChessBoard();
//        board.newBoard();
//        board.updateBoard();
//        board.printBoard();
//        board.movePiece(board.getPieceAt(new BoardPosition('e', 2)), new BoardPosition('e', 4));
//        board.printBoard();
//        board.movePiece(board.getPieceAt(new BoardPosition('f', 1)), new BoardPosition('c', 4));
//        board.printBoard();
////        board.getPieceAt(new BoardPosition('c', 4)).printPossibleMoves();
//        board.movePiece(board.getPieceAt(new BoardPosition('b', 1)), new BoardPosition('c', 3));
//        board.getPieceAt(new BoardPosition('c', 3)).printPossibleMoves();
//        board.getPieceAt(new BoardPosition('e', 4)).printPossibleMoves();
//        board.getPieceAt(new BoardPosition('a', 2)).printPossibleMoves();
//
//        board.movePiece(board.getPieceAt(new BoardPosition('h', 2)), new BoardPosition('h', 4));
//        board.getPieceAt(new BoardPosition('h', 1)).printPossibleMoves();
//        board.movePiece(board.getPieceAt(new BoardPosition('h', 1)), new BoardPosition('h' , 3));
//        board.getPieceAt(new BoardPosition('h', 3)).printPossibleMoves();
//        board.printBoard();
//
//        board.movePiece(new BoardPosition('d', 7), new BoardPosition('d', 5));
//        board.printBoard();
//        board.getPieceAt(new BoardPosition('e', 4)).printPossibleMoves();
//        board.getPieceAt(new BoardPosition('d', 5)).printPossibleMoves();
//
//        board.movePiece(new BoardPosition('e', 4), new BoardPosition('e', 6));
//        board.printBoard();
//
//        System.out.println();
//        board.movePiece(new BoardPosition('c', 4), new BoardPosition('b', 5));
//        board.printBoard();
//        board.getPieceAt(new BoardPosition('b', 5)).printPossibleMoves();
//        System.out.println();
//        System.out.println(board.wouldPutInCheck(board.blackKing));
//        board.movePiece(new BoardPosition('e', 7), new BoardPosition('e', 6));
//        board.printBoard();
//        board.getPieceAt(new BoardPosition('b', 5)).printPossibleMoves();
//
//        board.printBoard();
//        System.out.println();
//        board.movePiece(new BoardPosition('b', 8), new BoardPosition('d', 7));
//        board.printBoard();
//        System.out.println(board.wouldPutInCheck(board.blackKing));
        try {
        ChessGame game = new ChessGame();
        game.startGame();

        } catch (MoveFormatException e) {
            throw new RuntimeException(e);
        }


    }

}
