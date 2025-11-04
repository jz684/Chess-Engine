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
