public class Game {
    private Board board;
    private Player white;
    private Player black;
    private int whoseTurn;

    /**
     * Constructor for the whole game on start
     * @param name1 Name of first player
     * @param name2 NAme of second player
     * @param startTurn Initialized as 0 or 1 depending on which player starts first
     */
    public Game(String name1, String name2, int startTurn){
        this.white = new Player(name1, 0);
        this.black = new Player(name2, 1);
        this.whoseTurn = startTurn;
        this.board = new Board();
    }

    /**
     * Get board method to return board object of game
     * @return board of Game object
     */
    public Board getBoard(){
        return this.board;
    }

    /**
     * Get method to get Player object white
     * @return white Player of Game object
     */
    public Player getWhite(){
        return this.white;
    }

    /**
     * Get method to get Player object black
     * @return black Player of Game object
     */
    public Player getBlack(){
        return this.black;
    }

    /**
     * Get method for which player's turn it is, always either 0 or 1
     * @return whoseTurn of Game object
     */
    public int getTurn(){
        return this.whoseTurn;
    }

    /**
     * Method to change which player's turn it is
     * @return nothing
     */
    public void changeTurn(){
        if(this.whoseTurn == 1)
            this.whoseTurn = 0;
        else
            this.whoseTurn = 1;
    }

    /**
     * Check if either King is dead, and increment GamesWon/Lost appropriately
     * @return boolean true if game over, false if not
     */
    public boolean isGameOver(){
        if(this.board.isKingDead() == 0){
            this.black.addGameWon();
            this.white.addGameLost();
            return true;
        }
        if(this.board.isKingDead() == 1){
            this.white.addGameWon();
            this.black.addGameLost();
            return true;
        }
        return false;
    }

    /**
     * Player chooses to forfeit,
     * @param quitter
     * @return true if forfeit successful, false if bad input
     */
    public boolean forfeit(Player quitter){
        if(quitter.equals(this.black)){
            this.white.addGameWon();
            this.black.addGameLost();
            return true;
        } else if(quitter.equals(this.white)){
            this.black.addGameWon();
            this.white.addGameLost();
            return true;
        } else{
            return false;
        }
    }


}

//https://codereview.stackexchange.com/questions/71790/design-a-chess-game-using-object-oriented-principles
//http://www.cs.unc.edu/~jasleen/Courses/Fall11/HW/HW4-functions-chessboard-simplified.pdf

