import java.util.Scanner;
import java.util.Timer;

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

    public void startGame() {
        System.out.println("Welcome to Chess!\nWritten by Jackson Lee\n");
        playGame();
    }

    public void playGame() {
        while (true) {
            turn();
        }
    }

    public void turn() {
        board.printBoard();
        System.out.println(currentTurnsPlayer.getName() + "\'s turn.\nPlease enter a move in this format [e2 e4]:");
        String move = scan.nextLine();
        // if the move is a valid move, and the piece being moved is the same as the current players move
        if (board.getMoveColor(move) == currentTurnsPlayer.getColor() && board.movePiece(move)) {

            currentTurnsPlayer = nextPlayer(currentTurnsPlayer);
        }
        else {
            System.out.println(board.getMoveColor(move));
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
