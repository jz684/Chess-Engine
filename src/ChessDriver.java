public class ChessDriver {
    public static void main(String[] args) {
        try {
            ChessGame game = new ChessGame();
            game.startGame();

        } catch (MoveFormatException e) {
            throw new RuntimeException(e);
        }

    }

}
