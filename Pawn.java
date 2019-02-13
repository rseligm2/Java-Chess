public class Pawn extends Piece{
    private boolean hasMoved;
    /**
     * Constructor for Pawn object uses Piece constructor
     * @param x initial x coordinate
     * @param y initial y coordinate
     */
    public Pawn(int x, int y, int color){
        super(x, y, color);
        this.hasMoved = false;
    }

    /**
     * Checks if a given location on board is valid for Pawn to move to
     * Pawn can only move down or up depending on color
     * Pawn can move two spaces if it is the piece's first move
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
        if(this.color == 0) {
            if(this.hasMoved) {
                if (this.getXcoord() == newX && newY - this.getYcoord() == 1) {
                    return true;
                } else {
                    return false;
                }
            } else{
                if (this.getXcoord() == newX && (newY - this.getYcoord() <= 2 && newY - this.getYcoord() > 0)){
                    this.hasMoved = true;
                    return true;
                } else {
                    return false;
                }
            }
        } else{
            if(this.hasMoved) {
                if (this.getXcoord() == newX && this.getYcoord() - newY == 1) {
                    return true;
                } else {
                    return false;
                }
            } else{
                if(this.getXcoord() == newX && (this.getYcoord() - newY <= 2 && this.getYcoord() - newY > 0)){
                    this.hasMoved = true;
                    return true;
                } else{
                    return false;
                }
            }
        }
    }
}

//https://codereview.stackexchange.com/questions/71790/design-a-chess-game-using-object-oriented-principles
//http://www.cs.unc.edu/~jasleen/Courses/Fall11/HW/HW4-functions-chessboard-simplified.pdf