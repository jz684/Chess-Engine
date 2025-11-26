import javax.swing.*;
import java.awt.*;

public class ChessGui extends JPanel {
    private final int SCREEN_WIDTH = 300;
    private final int SCREEN_HEIGHT = 200;

    private ChessGame chessGame;

    public ChessGui(ChessGame chessGame) {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.chessGame = chessGame;
    }

    public void checkMate() {
        this.setVisible(true);
        this.setBackground(Color.red);
        JLabel text = new JLabel("Checkmate!");
        text.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        text.setVisible(true);
        this.add(text);
    }
}
