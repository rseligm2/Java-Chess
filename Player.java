public class Player {
    private int gamesWon;
    private int gamesLost;
    private String Name;
    public int color;

    public Player(String yourname, int yourcolor){
        this.Name = yourname;
        this.color = yourcolor;
        this.gamesWon = 0;
        this.gamesLost = 0;
    }

    public int getGamesWon(){
        return this.gamesWon;
    }

    public int getGamesLost(){
        return this.gamesLost;
    }

    public void addGameWon(){
        this.gamesWon++;
    }

    public void addGameLost(){
        this.gamesLost++;
    }

}

//https://codereview.stackexchange.com/questions/71790/design-a-chess-game-using-object-oriented-principles

