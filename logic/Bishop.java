public class Bishop extends Piece {

    /**
     * Constructor for Bishop object uses Piece constructor
     * @param x initial x coordinate
     * @param y initial y coordinate
     */
    public Bishop(int x, int y, int color){
        super(x, y, color);
    }

    /**
     * Checks if a given location on board is valid for Bishop to move to
     * @param board to get the space on the board
     * @param newX X coordinate of space being checked
     * @param newY Y coordinate of space being checked
     * @return true if space valid, false if not
     */
    @Override
    public boolean isValidMove(Board board, int newX, int newY) {
        if (!this.allValidMoveCheck(board, newX, newY)) {
            return false;
        }
        if (Math.abs(this.getXcoord() - newX) == Math.abs(this.getYcoord() - newY)) {
            return true;
        } else {
            return false;
        }
    }

}

//https://codereview.stackexchange.com/questions/71790/design-a-chess-game-using-object-oriented-principles
//http://www.cs.unc.edu/~jasleen/Courses/Fall11/HW/HW4-functions-chessboard-simplified.pdf