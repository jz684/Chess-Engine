import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;
import java.util.Timer;


public class ChessGame {
    private ChessBoard board;
    private Timer timer;
    private Player player1;
    private Player player2;
    private Player currentTurnsPlayer;
    private JLayeredPane layeredPane;

    public ChessGame() {
        board = new ChessBoard();
        board.newBoard();
        timer = new Timer();
        player1 = new Player("Player 1", 0);
        player2 = new Player("Player 2", 1);
        currentTurnsPlayer = player1;
    }

    public void startGame() throws MoveFormatException {
        initLayeredPane();
        ChessPanel panel = new ChessPanel(this);
        layeredPane.add(panel, JLayeredPane.DEFAULT_LAYER);
        ChessFrame frame = new ChessFrame(layeredPane);
        panel.start();
    }

    public void initLayeredPane() {
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 600));
        layeredPane.setVisible(true);
    }

    public void showWinScreen() {
        ChessGui gui = new ChessGui(this);
        gui.checkMate();
        layeredPane.add(gui);
    }

    public ChessBoard getChessBoard() {
        return board;
    }

    public ChessPiece[][] getBoard() {
        return board.getBoard();
    }

    public boolean checkMate(King king) {
//        System.out.print("King possibleMoves: ");
//        king.printPossibleMoves();
        return board.inCheck(king) && !board.anyValidMoves(king);
    }

    public void printBoard() {
        board.printBoard();
    }

    public boolean flipped() {
        return currentTurnsPlayer.getColor() == 1;
    }

    public Player getWinner() {
        if (checkMate(board.whiteKing)) {
            return player1;
        }
        else {
            return player2;
        }
    }

    public void turn(Move move) {
        if (board.getMoveColor(move) == currentTurnsPlayer.getColor()) {
            if (board.movePiece(move)) {
                currentTurnsPlayer = nextPlayer(currentTurnsPlayer);

            }

        }
        else {
            if (board.getMoveColor(move) != currentTurnsPlayer.getColor()) {
                System.out.println("Not ur turn buddy");
            }
            System.out.println("Invalid Move");
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
