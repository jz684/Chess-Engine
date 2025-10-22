import javax.swing.*;
import java.awt.*;

public class ChessFrame extends JFrame {

    private ChessGame chessGame;

    public ChessFrame(ChessPanel chessPanel, ChessGame chessGame) {
        this.chessGame = chessGame;
        this.add(chessPanel);
        this.setTitle("Chess");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(createLogo());
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    // TODO
//    public MenuBar createMenu() {}

    public Image createLogo() {
        String path = "src/images/chessIcon.png";
        ImageIcon icon = new ImageIcon(path);
        return icon.getImage();
    }
}
