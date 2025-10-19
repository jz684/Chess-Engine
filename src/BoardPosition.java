public class BoardPosition {
    char column;
    int row;

    public BoardPosition() {
        this.column = 'a';
        this.row = 1;
    }

    public BoardPosition(char column, int row) {
        this.column = column;
        this.row = row;
    }

    public BoardPosition(BoardPosition position) {
        this.column = position.column;
        this.row = position.row;
    }

    public BoardPosition(String positionStr) throws MoveFormatException {
        positionStr = testFormat(positionStr);
        this.column = positionStr.charAt(0);
        this.row = (int) positionStr.charAt(1) - 48;
    }

    //Inclusive
    public boolean validBounds(int tester, int lower, int upper) {
        return tester >= lower && tester <=upper;
    }

    public String testFormat(String positionStr) throws MoveFormatException{
        if (positionStr.length() != 2)
            throw new MoveFormatException("Invalid length");

        char positionCol = positionStr.charAt(0);
        int positionRow = positionStr.charAt(1) - 48;

//        System.out.println("debug 3");

        if (!validBounds(positionCol, 97, 104) || !validBounds(positionRow, 1, 8)) {
            throw new MoveFormatException("Invalid current position");
        }

        return positionStr;
    }

    public String toString() {
        return "" + column + row;
    }

    public boolean equals(BoardPosition position) {
        return position.row == row && position.column == column;
    }

    public boolean isNotOutOfBounds() {
        return (column >= 'a' && column <= 'h') && (row >= 1 && row <= 8);
    }

    public void move(BoardPosition pos) {
        this.column = pos.column;
        this.row = pos.row;
    }
}
