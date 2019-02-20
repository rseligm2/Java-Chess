public class KnightRook extends Piece {

    /**
     * Constructor for Hopper object uses Piece constructor
     * @param x initial x coordinate
     * @param y initial y coordinate
     */
    public KnightRook(int x, int y, int color){
        super(x, y, color);
    }

    /**
     * Checks if a given location on board is valid for KnightRook to move to
     * KnightRook is able to move as if it were a knight and a rook
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
        if((Math.abs(this.getXcoord() - newX) == 1 && Math.abs(this.getYcoord() - newY) == 2) || (Math.abs(this.getXcoord() - newX) == 2 && Math.abs(this.getYcoord() - newY) == 1)) {
            return true;
        } else if(this.getXcoord() == newX || this.getYcoord() == newY){
            return true;
        } else{
            return false;
        }
    }

}
