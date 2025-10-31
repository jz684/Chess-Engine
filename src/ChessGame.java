import java.util.Scanner;
import java.util.Timer;


// Dear Jackson, Your code is ass and needs fixing Immediately.
// Heard you loud and clear Lee, Will start immediately.

public class ChessGame {
    private ChessBoard board;
    private Timer timer;
    private Player player1;
    private Player player2;
    private Player currentTurnsPlayer;

    private ChessFrame frame;
    private ChessPanel panel;

    // Temp
    private Scanner scan;

    public ChessGame() {
        board = new ChessBoard();
        board.newBoard();
        timer = new Timer();
        scan = new Scanner(System.in);
        player1 = new Player("Player 1", 0);
        player2 = new Player("Player 2", 1);
        currentTurnsPlayer = player1;

        panel = new ChessPanel();
        frame = new ChessFrame(panel);
    }

    public void startGame() throws MoveFormatException {
        System.out.println("Welcome to Chess!\nWritten by Jackson Lee\n");
        playGame();
    }

    public ChessBoard getChessBoard() {
        return board;
    }

    public ChessPiece[][] getBoard() {
        return board.getBoard();
    }

    public void playGame() throws MoveFormatException {
        panel.repaint();
        panel.drawPieces(board);
//        while (stillRunning() && currentTurnsPlayer == player1) {
////            turn();
//            System.out.println("Getting stuck");
//            panel.waitingForMove(true);
//            if (panel.getMyMove() != null) {
//                turn(panel.getMyMove());
//                panel.repaint();
//                panel.drawPieces(board);
//            }
//        }
        if (stillRunning() && currentTurnsPlayer.equals(player1)) {
            panel.waitingForMove(true);
            if (panel.getMyMove() != null) {
                turn(panel.getMyMove());
                panel.repaint();
                panel.drawPieces(board);
            }
        }

        if (checkMate(board.whiteKing)) {
            win(board.blackKing);
        }
        else if (checkMate(board.blackKing)){
            win(board.whiteKing);
        }
        else {
            draw();
        }
    }

    public void draw() {
        System.out.println("DRAW: you guys suck");
    }

    /**
     * Check if there's no checkMate or stalemate
     * @return if the game is still running.
     */
    public boolean stillRunning() {
        return (!checkMate(board.whiteKing) && !checkMate(board.blackKing)) && (!staleMate(board.whiteKing) && !staleMate(board.blackKing));
    }

    /**
     * To check if there's a stalemate
     * @param king
     * @return
     */
    public boolean staleMate(King king) {
        // TODO
        return false;
    }

    public void win(King king) {
        scan.close();
        if (king.color == 0) {
            System.out.println("White King Wins! (Player 1)");
        }
        else {
            System.out.println("Black king Wins! (Player 2)");
        }
    }

    public boolean checkMate(King king) {
//        System.out.println(king.color + " : Color");
//        System.out.println(board.inCheck(king));
//        System.out.println(!board.anyValidMoves(king));
        System.out.print("King possibleMoves: ");
        king.printPossibleMoves();
        return board.inCheck(king) && !board.anyValidMoves(king);
    }

    public void printBoard() {
        board.printBoard();
    }

    public void turn(String moveString) throws MoveFormatException {
        BoardPosition position = new BoardPosition(moveString.substring(0, 2));
        BoardPosition move = new BoardPosition(moveString.substring(3, 5));
        if (board.getMoveColor(position) == currentTurnsPlayer.getColor() && board.movePiece(position, move)) {

            currentTurnsPlayer = nextPlayer(currentTurnsPlayer);
        }
        else {
            if (board.getMoveColor(position) != currentTurnsPlayer.getColor()) {
                System.out.println("Not ur turn buddy");
            }
            System.out.println("Invalid Move");
        }
    }

    public void turn(BoardPosition position, BoardPosition move) {
        if (board.getMoveColor(position) == currentTurnsPlayer.getColor() && board.movePiece(position, move)) {

            currentTurnsPlayer = nextPlayer(currentTurnsPlayer);
        }
        else {
            if (board.getMoveColor(position) != currentTurnsPlayer.getColor()) {
                System.out.println("Not ur turn buddy");
            }
            System.out.println("Invalid Move");
        }
    }

//    public void turn() {
//        board.printBoard();
//        System.out.println(currentTurnsPlayer.getName() + "\'s turn.\nPlease enter a move in this format [e2 e4]:");
//        String move = scan.nextLine();
//        // if the move is a valid move, and the piece being moved is the same as the current players move
//        if (board.getMoveColor(move) == currentTurnsPlayer.getColor() && board.movePiece(move)) {
//
//            currentTurnsPlayer = nextPlayer(currentTurnsPlayer);
//        }
//        else {
////            System.out.println(board.getMoveColor(move));
//            System.out.println("Invalid move, try again");
//            turn();
//        }
//    }

    public Player nextPlayer(Player player) {
        // Returns the other player when one player is inputted.
        if (player.equals(player1)) {
            return player2;
        }
        else {
            return player1;
        }
    }

    public King getWinner() {
        if (checkMate(board.whiteKing)) {
            return board.whiteKing;
        }
        else {
            return board.blackKing;
        }
    }

    public boolean checkForMate() {
        if (checkMate(board.whiteKing) || checkMate(board.blackKing)) {
            System.out.println("CheckMate");
            return true;
        }
        return false;
    }

}
