import javax.swing.*;

public class ChessFrame extends JFrame {

    public ChessFrame(JPanel panel) {
        this.add(panel);
        this.setTitle("Chess");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
