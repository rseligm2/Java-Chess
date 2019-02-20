public class Space {
    private Piece piece;
    private boolean occupied;

    /**
     * Constructor for Space object that represents space on board
     * piece default set to null, as no piece is initially on space
     * occupied defualt set to false, no piece initially on space
     */
    public Space(){
        this.piece = null;
        this.occupied = false;
    }

    /**
     * Method to execute when one piece moves to a space,
     * checks if space is empty or if a piece occupies the space already
     * and if piece is enemy piece then it is killed
     * @param newPiece piece to be moved to new spot
     * @return boolean if newpiece was able to move to space
     */
    public boolean takeSpace(Piece newPiece){
        if(this.piece == null) {
            this.piece = newPiece;
            this.occupied = true;
            return true;
        } else{
            if(this.piece.color != newPiece.color) {
                this.piece.killPiece();
                this.piece = newPiece;
                return true;
            } else{
                return false;
            }
        }

    }

    /**
     * Method to remove a piece from a space on board
     */
    public void leaveSpace(){
        this.piece = null;
        this.occupied = false;
    }

    /**
     * Get method for piece occupying space
     * @return piece on space, could be NULL
     */
    public Piece getPiece(){
        return this.piece;
    }

    /**
     * Get method for if space contains a piece
     * @return true if contains piece, false if doesn't
     */
    public boolean isOccupied(){
        return this.occupied;
    }

    /**
     * Method for testing purposes, places a piece directly into space
     * @param newPiece to be placed
     */
    public void placePiece(Piece newPiece, int x, int y){
        this.piece = newPiece;
        this.piece.setXcoord(x);
        this.piece.setYcoord(y);
        this.occupied = true;
    }

}

//https://codereview.stackexchange.com/questions/71790/design-a-chess-game-using-object-oriented-principles
//http://www.cs.unc.edu/~jasleen/Courses/Fall11/HW/HW4-functions-chessboard-simplified.pdf


