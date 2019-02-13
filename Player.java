public class Player {
    private int gamesWon;
    private int gamesLost;
    private String Name;
    public int color;

    /**
     * Constructor for new player in game
     * @param yourname Name of new player
     * @param yourcolor Color of new player
     * Games won var and games lost var default start at 0
     */
    public Player(String yourname, int yourcolor){
        this.Name = yourname;
        this.color = yourcolor;
        this.gamesWon = 0;
        this.gamesLost = 0;
    }

    /**
     * Get method for number of games won
     * @return gamesWon of player
     */
    public int getGamesWon(){
        return this.gamesWon;
    }

    /**
     * Get method for number of games lost
     * @return gamesLost of player
     */
    public int getGamesLost(){
        return this.gamesLost;
    }

    /**
     * Increment method for player number of games won
     * @return nothing
     */
    public void addGameWon(){
        this.gamesWon++;
    }

    /**
     * Increment method for playre number of games lost
     * @return nothing
     */
    public void addGameLost(){
        this.gamesLost++;
    }

}

//https://codereview.stackexchange.com/questions/71790/design-a-chess-game-using-object-oriented-principles
//http://www.cs.unc.edu/~jasleen/Courses/Fall11/HW/HW4-functions-chessboard-simplified.pdf


