public class Position {
    char x;
    int y;
    public Position() {
        this.x = 'a';
        this.y = 1;
    }

    public Position(char x, int y) {
        this.x = x;
        this.y = y;
    }

    public String printPosition() {
        System.out.println("" + x + y);
        return "" + x + y;
    }

}
