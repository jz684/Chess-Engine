import javax.swing.*;
import java.awt.*;

public class ChessPanel extends JPanel {

    private ChessGame chessGame;

    private static int SCREEN_WIDTH = 600;
    private static int SCREEN_HEIGHT = 600;

    public ChessPanel() {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        chessGame = new ChessGame();
//        start();
    }

    public void drawBoard(Graphics g) {
        // If it starts on an odd num its black, else its green
        int currentX = 0;
        int currentY = 0;
        Color whiteSquare = new Color(255, 238, 176);
        Color blackSquare = new Color(128, 81, 37);

        int squareLength = SCREEN_WIDTH / 8; // 75

        for (int r = 0; r < SCREEN_HEIGHT / squareLength; r++) {
            currentX = 0;
            if (r % 2 == 0) {
                g.setColor(whiteSquare);
            }
            else {
                g.setColor(blackSquare);
            }
            for (int c = 0; c < SCREEN_WIDTH / squareLength; c++) {
                if (c != 0) {
                    if (g.getColor().equals(whiteSquare)) {
                        g.setColor(blackSquare);
                    }
                    else {
                        g.setColor(whiteSquare);
                    }
                }
                g.fillRect(currentX, currentY, squareLength, squareLength);
                currentX += squareLength;
            }
            currentY += squareLength;
        }
//        paintComponent(g);
    }

    public void start() {
//        chessGame.startGame();
//        drawBoard();
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        drawBoard(g);
    }
}
