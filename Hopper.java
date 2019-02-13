public class Hopper extends Piece {

    /**
     * Constructor for Hopper object uses Piece constructor
     * @param x initial x coordinate
     * @param y initial y coordinate
     */
    public Hopper(int x, int y, int color){
        super(x, y, color);
    }

    /**
     * Checks if a given location on board is valid for Hopper to move to
     * Hoper is able to jump exactly 2 spaces in any direction
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
        if(Math.abs(this.getXcoord() - newX) == 2 && Math.abs(this.getYcoord() - newY) == 2){
            return true;
        } else{
            return false;
        }
    }
}
