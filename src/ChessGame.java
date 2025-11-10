import java.util.Scanner;
import java.util.Timer;


// Dear Jackson, Your code is ass and needs fixing Immediately.

public class ChessGame {
    private ChessBoard board;
    private Timer timer;
    private Player player1;
    private Player player2;
    private Player currentTurnsPlayer;

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
    }

    public void startGame() throws MoveFormatException {
        ChessPanel panel = new ChessPanel(this);
        ChessFrame frame = new ChessFrame(panel);
        panel.start();
    }

    public ChessBoard getChessBoard() {
        return board;
    }

    public ChessPiece[][] getBoard() {
        return board.getBoard();
    }

    public void playGame() throws MoveFormatException {
        while (!checkMate(board.whiteKing) && !checkMate(board.blackKing)) {
            turn();
        }

        if (checkMate(board.whiteKing)) {
            win(board.blackKing);
        }
        else {
            win(board.whiteKing);
        }

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
        System.out.print("King possibleMoves: ");
        king.printPossibleMoves();
        return board.inCheck(king) && !board.anyValidMoves(king);
    }

    public void printBoard() {
        board.printBoard();
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

    public void turn(Move move) {
        if (board.getMoveColor(move) == currentTurnsPlayer.getColor() && board.movePiece(move)) {

            currentTurnsPlayer = nextPlayer(currentTurnsPlayer);
        }
        else {
            if (board.getMoveColor(move) != currentTurnsPlayer.getColor()) {
                System.out.println("Not ur turn buddy");
            }
            System.out.println("Invalid Move");
        }
    }

    //TODO delete
    public void turn() throws MoveFormatException {
        board.printBoard();
        System.out.println(currentTurnsPlayer.getName() + "\'s turn.\nPlease enter a move in this format [e2 e4]:");
        String moveString = scan.nextLine();
        Move move = new Move(moveString);
        // if the move is a valid move, and the piece being moved is the same as the current players move
        if (board.getMoveColor(move) == currentTurnsPlayer.getColor() && board.movePiece(move)) {

            currentTurnsPlayer = nextPlayer(currentTurnsPlayer);
        }
        else {
//            System.out.println(board.getMoveColor(move));
            System.out.println("Invalid move, try again");
            turn();
        }
    }

    public Player nextPlayer(Player player) {
        // Returns the other player when one player is inputted.
        if (player.equals(player1)) {
            return player2;
        }
        else {
            return player1;
        }
    }


}
