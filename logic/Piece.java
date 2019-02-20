public class Piece {
    private int xcoord;
    private int ycoord;
    private boolean alive;
    public int color;

    /**
     * constructor for all pieces
     * @param x initial x coordinate of piece
     * @param y initial y coordinate of piece
     * alive default set to true
     */
    public Piece(int x, int y, int thecolor){
        this.xcoord = x;
        this.ycoord = y;
        this.alive = true;
        this.color = thecolor;
    }

    /**
     * Get method for x coordinate of piece
     * @return xcoord
     */
    public int getXcoord(){
        return this.xcoord;
    }

    /**
     * Get method for y coordinate of piece
     * @return ycoord
     */
    public int getYcoord(){
        return this.ycoord;
    }

    /**
     * Set method for x coordinate of piece
     * @param x coordinate to be set
     * @return nothing
     */
    public void setXcoord(int x){
        this.xcoord = x;
    }

    /**
     * Set method for y coordinate of piece
     * @param y coordinate to be set
     * @return nothing
     */
    public void setYcoord(int y){
        this.ycoord = y;
    }

    /**
     * Get method for alive value of piece
     * @return alive boolean of piece
     */
    public boolean getPieceStatus(){
        return this.alive;
    }

    /**
     * Method to be used be piece is to be taken off board
     * @return nothing
     */
    public void killPiece(){
        this.alive = false;
    }

    /**
     * Method to return whether another piece is the same color
     * @param checkPiece piece to be checked
     * @return true if same color, false if not
     */
    public boolean isFriendlyPiece(Piece checkPiece){
        if(this.color == checkPiece.color) {
            return true;
        } else{
            return false;
        }
    }

    /**
     * Method to check if new space is within boundaries and space
     * not already occupied by friendly piece
     * @param board takes in Board object
     * @param newX X coordinate of space being checked
     * @param newY Y coordinate of space being checked
     * @return true if space within board and not occupied by friendly piece, false otherwise
     */
    public boolean allValidMoveCheck(Board board, int newX, int newY) {
        if (newX > 7 || newX < 0 || newY > 7 || newY < 0) {
            return false;
        }
        Space nextSpace = board.getSpace(newX, newY);
        Piece checkPiece = nextSpace.getPiece();
        if (nextSpace.isOccupied()) {
            if (this.isFriendlyPiece(checkPiece)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Dummy Method, overridden in all specific piece classes
     * @param board
     * @param newX
     * @param newY
     * @return
     */
    public boolean isValidMove(Board board, int newX, int newY){
        return true;
    }


}

//https://codereview.stackexchange.com/questions/71790/design-a-chess-game-using-object-oriented-principles
//http://www.cs.unc.edu/~jasleen/Courses/Fall11/HW/HW4-functions-chessboard-simplified.pdf

