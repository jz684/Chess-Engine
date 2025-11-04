import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChessPanel extends JPanel {

    private ChessGame chessGame;

    private static final int SCREEN_WIDTH = 600;
    private static final int SCREEN_HEIGHT = 600;
    private static final int SQUARE_LENGTH = 75;

    private boolean running;

    public ChessPanel() {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        chessGame = new ChessGame();
        running = true;
        start();
    }

    public BoardPosition coordsToPosition(int x, int y) {
        x = x / 75;
        y = Math.abs(y - 675); // Calculation to get normalized board layout
        int column = y / 75;

        char row = (char) (x + 97);
        System.out.println(new BoardPosition(row, column));
        return new BoardPosition(row, column);
    }

    public void drawPieces() {
        ChessPiece[][] board = chessGame.getBoard();

        for (int r = 0; r < SCREEN_HEIGHT / SQUARE_LENGTH; r++) {
            for (int c = 0; c < SCREEN_WIDTH / SQUARE_LENGTH; c++) {
                if (board[r][c] != null) {
//                    System.out.println(board[r][c].getName());
                    Image image = board[r][c].pieceIcon.getImage();
                    ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH)); // Resize
                    JLabel testImg = new JLabel(imageIcon);
                    testImg.setVisible(true);
                    testImg.setBounds(c * SQUARE_LENGTH,r * SQUARE_LENGTH, imageIcon.getIconWidth(), imageIcon.getIconHeight());
                    this.add(testImg);
                }
            }
        }


    }

    public void makeMove(Move move) {
        System.out.println(move.toString());
        chessGame.turn(move);
        repaint();
    }

    public void listenForMove() {
        this.addMouseListener(new MouseAdapter() {

            private boolean pressed;
            private BoardPosition pressedOn = null;

            private BoardPosition firstPosition;

            @Override
            public void mousePressed(MouseEvent e) {
                pressed = true;
                pressedOn = coordsToPosition(e.getX(), e.getY());
                System.out.println("Pressed on: " + pressedOn);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (pressed) {
                    pressed = false;
                    BoardPosition releasedOn = coordsToPosition(e.getX(), e.getY());
                    System.out.println("Released on: " + releasedOn);
                    if (!pressedOn.equals(releasedOn)) {
                        System.out.println(pressedOn + " to " + releasedOn);
                        makeMove(new Move(pressedOn, releasedOn));
                        pressedOn = null;
                        firstPosition = null;
                    }
                    else if (firstPosition != null && !firstPosition.equals(releasedOn)) {
                        System.out.println(firstPosition + " to " + releasedOn);
                        makeMove(new Move(firstPosition, releasedOn));
                        pressedOn = null;
                        firstPosition = null;
                    }
                    else {
                        firstPosition = pressedOn;
                        pressedOn = null;
                    }


                }
            }
        });
    }

    public void drawBoard(Graphics g) {
        // If it starts on an odd num its black, else its green
        int currentX = 0;
        int currentY = 0;
        Color whiteSquare = new Color(255, 238, 176);
        Color blackSquare = new Color(128, 81, 37);

        for (int r = 0; r < SCREEN_HEIGHT / SQUARE_LENGTH; r++) {
            currentX = 0;
            if (r % 2 == 0) {
                g.setColor(whiteSquare);
            }
            else {
                g.setColor(blackSquare);
            }
            for (int c = 0; c < SCREEN_WIDTH / SQUARE_LENGTH; c++) {
                if (c != 0) {
                    if (g.getColor().equals(whiteSquare)) {
                        g.setColor(blackSquare);
                    }
                    else {
                        g.setColor(whiteSquare);
                    }
                }
                g.fillRect(currentX, currentY, SQUARE_LENGTH, SQUARE_LENGTH);
                currentX += SQUARE_LENGTH;
            }
            currentY += SQUARE_LENGTH;
        }
//        paintComponent(g);
    }

    public void start() {
//        chessGame.startGame();
//        drawBoard();
        listenForMove();
        repaint();
    }

    // TODO
    public void winScreen(King king) {
        String color;
        if (king.color == 0)
            color = "White";
        else
            color = "Black";
        JLabel winText = new JLabel(color + " King Wins!");
        winText.setBounds(0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
        winText.setVisible(true);
        this.add(winText);
    }

    public King getWinner() {
        if (chessGame.checkMate(chessGame.getChessBoard().whiteKing)) {
            return chessGame.getChessBoard().whiteKing;
        }
        else {
            return chessGame.getChessBoard().blackKing;
        }
    }

    public boolean checkForMate() {
        if (chessGame.checkMate(chessGame.getChessBoard().whiteKing) || chessGame.checkMate(chessGame.getChessBoard().blackKing)) {
            System.out.println("CheckMate");
            return true;
        }
        return false;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        running = !checkForMate();

        if (running) {
            removeAll();
            drawBoard(g);
            chessGame.printBoard();
            drawPieces();
        }
        else {
            System.out.println("End running");
            removeAll();
            winScreen(getWinner());
        }


    }
}
