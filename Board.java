public class Board {
    public final int BOARDSIZE = 8;  //Constant for size of board
    private Space[][] spaces = new Space[BOARDSIZE][BOARDSIZE];  //Array of Space objects to make up full board
    private Piece[] whitePieces = new Piece[16];
    private Piece[] blackPieces = new Piece[16];
    private boolean whiteCheck;
    private boolean blackCheck;

    /**
     * Constructor for Board object
     * Creates Space objects for entire spaces array
     * Puts pieces on spaces array
     */
    public Board(){
        for(int i = 0; i < spaces.length; i++){
            for(int j = 0; j < spaces.length; j++){
                this.spaces[i][j] = new Space();
            }
        }
        //create white and black pawns
        for(int j = 0; j < 8; j++){
            whitePieces[j] = new Pawn(j, 1, 0);
            blackPieces[j] = new Pawn(j, 6, 1);
        }
        //finish creating white pieces
        whitePieces[8] = new Rook(0,0,0);
        whitePieces[9] = new Knight(1,0, 0);
        whitePieces[10] = new Bishop(2, 0, 0);
        whitePieces[11] = new King(3, 0, 0);
        whitePieces[12] = new Queen(4, 0, 0);
        whitePieces[13] = new Bishop(5,0,0);
        whitePieces[14] = new Knight(6, 0, 0);
        whitePieces[15] = new Rook(7, 0, 0);

        //finish creating black pieces
        blackPieces[8] = new Rook(0,7,1);
        blackPieces[9] = new Knight(1,7, 1);
        blackPieces[10] = new Bishop(2, 7, 1);
        blackPieces[11] = new King(3, 7, 1);
        blackPieces[12] = new Queen(4, 7, 1);
        blackPieces[13] = new Bishop(5,7,1);
        blackPieces[14] = new Knight(6, 7, 1);
        blackPieces[15] = new Rook(7, 7, 1);

        //place all pieces on board
        for(int k = 0; k < 16; k++){
            this.spaces[whitePieces[k].getXcoord()][whitePieces[k].getYcoord()].takeSpace(whitePieces[k]);
            this.spaces[blackPieces[k].getXcoord()][blackPieces[k].getYcoord()].takeSpace(blackPieces[k]);
        }

        //initialize if player's king in danger as false
        this.blackCheck = false;
        this.whiteCheck = false;
    }

    /**
     * Method to move a piece from one part of the board to another
     * Only able to move piece if takeSpace is successful
     * @param movingpiece Piece object being moved
     * @param x Coordinate of destination Space
     * @param y Coordinate of destination Space
     * @return true if piece moved, false if invalid
     */
    public boolean movePiece(Piece movingpiece, int x, int y){
        int oldX = movingpiece.getXcoord();
        int oldY = movingpiece.getYcoord();
        if(movingpiece.isValidMove(this, x, y)) {
            boolean successful = this.spaces[x][y].takeSpace(movingpiece);
            if (successful) {
                this.spaces[oldX][oldY].leaveSpace();
                movingpiece.setXcoord(x);
                movingpiece.setYcoord(y);
                return true;
            } else {
                return false;
            }
        } else{
            return false;
        }
    }

    /**
     * Checks if white or black's king is dead
     * @return 0 if white king dead, 1 if black king dead, -1 if both alive
     */
    public int isKingDead(){
        if(!this.whitePieces[11].getPieceStatus()) {
            return 0;
        } else if(!this.blackPieces[11].getPieceStatus()){
            return 1;
        } else{
            return -1;
        }
    }

    /**
     * Method that goes through every move on board and checks if an enemy King can be attacked
     * @return 1 if black player check, 0 if white player check, -1 if neither
     */
    public int playerCheck(){
        boolean validMoveWhite;
        boolean validMoveBlack;
        for(int i = 0; i < 16; i++){
            for(int x = 0; x < 8; x++) {
                for (int y = 0; y <8; y++){
                    validMoveWhite = this.whitePieces[i].isValidMove(this, x, y);
                    if(validMoveWhite && this.spaces[x][y].getPiece() instanceof King && this.spaces[x][y].getPiece().color == 1){
                        this.blackCheck = true;
                        return 1;
                    }
                    validMoveBlack = this.blackPieces[i].isValidMove(this, x, y);
                    if(validMoveBlack && this.spaces[x][y].getPiece() instanceof King && this.spaces[x][y].getPiece().color == 0){
                        this.whiteCheck = true;
                        return 0;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Get method for Space object on board
     * @param x Coordinate of Space on board
     * @param y Coordinate of Space on board
     * @return Space object accessed
     */
    public Space getSpace(int x, int y){
        return this.spaces[x][y];
    }

    /**
     * Method used to clear entire board for testing purposes
     */
    public void clearBoard(){
        for(int i = 0; i < BOARDSIZE; i++){
            for(int j = 0; j < BOARDSIZE; j++){
                this.spaces[i][j].leaveSpace();
            }
        }
    }
}

//https://codereview.stackexchange.com/questions/71790/design-a-chess-game-using-object-oriented-principles
//http://www.cs.unc.edu/~jasleen/Courses/Fall11/HW/HW4-functions-chessboard-simplified.pdf

