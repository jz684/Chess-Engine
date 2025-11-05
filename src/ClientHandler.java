public class ClientHandler {
    private ChessBoard currentBoard;

    private Move requestedMove;

    public ClientHandler() {
        currentBoard = null;
        requestedMove = null;
    }

    public void setBoard(ChessBoard currentBoard) {
        this.currentBoard = currentBoard;
    }

    public void setRequestedMove(Move requestedMove) {
        this.requestedMove = requestedMove;
    }

    public ChessBoard getCurrentBoard() {return currentBoard;}

    public Move getRequestedMove() {return requestedMove;}

    public boolean currentBoardIsNull() {
        return currentBoard == null;
    }

    public boolean requestedMoveIsNull() {
        return requestedMove == null;
    }

}
