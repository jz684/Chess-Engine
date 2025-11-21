import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ChessPanel extends JPanel {

    private ChessGame chessGame;

    private static final int SCREEN_WIDTH = 600;
    private static final int SCREEN_HEIGHT = 600;
    static final int SQUARE_LENGTH = 75;

    private boolean running;

    private BoardPosition highlightPosition = null;

//    private ChessBoard chessBoard;

    public ChessPanel(ChessGame chessGame) {
        this.chessGame = chessGame;
        this.setLayout(null);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        running = true;
//        start();
    }

    public BoardPosition coordsToPosition(int x, int y) {
        x = x / 75;
        y = Math.abs(y - 675); // Calculation to get normalized board layout
        int column = y / 75;

        char row = (char) (x + 97);
//        System.out.println(new BoardPosition(row, column));
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
        // TODO
        chessGame.turn(move);
        repaint();
    }

    public void listenForMove() {
        this.addMouseListener(new MouseAdapter() {
            private boolean pressed = false;

            private BoardPosition pressedOn = null;

            private BoardPosition firstPosition;

            @Override
            public void mousePressed(MouseEvent e) {
                if (!pressed) {
                    pressed = true;
                    pressedOn = coordsToPosition(e.getX(), e.getY());
//                    System.out.println("Pressed on: " + pressedOn);
                    highlightPosition = pressedOn;
                    repaint();

                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (pressed) {
                    pressed = false;
                    BoardPosition releasedOn = coordsToPosition(e.getX(), e.getY());
//                    System.out.println("Released on: " + releasedOn);
                    // If the piece you released on is not the same as the one you pressed on
                    if (!pressedOn.equals(releasedOn)) {
//                        System.out.println(pressedOn + " to " + releasedOn);
                        makeMove(new Move(pressedOn, releasedOn));
                        pressedOn = null;
                        firstPosition = null;

                    }
                    else if (firstPosition != null && !firstPosition.equals(releasedOn)) {
//                        System.out.println(firstPosition + " to " + releasedOn);
                        makeMove(new Move(firstPosition, releasedOn));
                        pressedOn = null;
                        firstPosition = null;
                        highlightPosition = null;
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
//        Color highlightedSquare = new Color(117, 143, 113);

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
//                    if (c == highlightPosition.column && r == highlightPosition.row)
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

        highlight(g);

//        paintComponent(g);
    }

    public void drawPossibleMoves(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        if (highlightPosition != null && chessGame.getChessBoard().getPieceAt(highlightPosition) != null) {
            ArrayList<BoardPosition> possiblePositions = chessGame.getChessBoard().getPieceAt(highlightPosition).getPossibleMoves();
            for (int r = 0; r < SCREEN_WIDTH / SQUARE_LENGTH; r++) {
                for (int c = 0; c < SCREEN_WIDTH / SQUARE_LENGTH; c++) {
                    BoardPosition position = new BoardPosition(c, r);
                    for (BoardPosition possiblePosition : possiblePositions) {
                        if (position.equals(possiblePosition) /*&& chessGame.getChessBoard().validMove(new Move(highlightPosition, possiblePosition))*/) {
//                            System.out.println("Drawing move at: " + position.toString());
                            g.fillOval(position.getX() + SQUARE_LENGTH / 3, position.getY() + SQUARE_LENGTH / 3, SQUARE_LENGTH / 3, SQUARE_LENGTH / 3);
                        }
                    }
                }
            }
        }
    }

    public void highlight(Graphics g) {
        // For Pressing on squares
        g.setColor(new Color(117, 143, 113));
        if (highlightPosition != null) {
            g.fillRect(highlightPosition.getX(), highlightPosition.getY(), SQUARE_LENGTH, SQUARE_LENGTH);
        }

        g.setColor(new Color(250, 93, 93));
        if (chessGame.getChessBoard().inCheck(chessGame.getChessBoard().blackKing)) {
            g.fillRect(chessGame.getChessBoard().blackKing.getX(), chessGame.getChessBoard().blackKing.getY(), SQUARE_LENGTH, SQUARE_LENGTH);
        }
        else if (chessGame.getChessBoard().inCheck(chessGame.getChessBoard().whiteKing)) {
            g.fillRect(chessGame.getChessBoard().whiteKing.getX(), chessGame.getChessBoard().whiteKing.getY(), SQUARE_LENGTH, SQUARE_LENGTH);
        }

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
        System.out.println("Winner :" + king.toString() + " " + king.color);
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
            return chessGame.getChessBoard().blackKing;
        }
        else {
            return chessGame.getChessBoard().whiteKing;
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
//            chessGame.printBoard();
            drawPieces();
            drawPossibleMoves(g);
        }
        else {
            System.out.println("End running");
            removeAll();
            System.out.println("Winner is :" + getWinner().toString());
            winScreen(getWinner());
        }


    }
}
