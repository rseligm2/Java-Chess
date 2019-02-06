public class Game {
    private Board board = new Board();
    private Player white;
    private Player black;
    private int whoseTurn;

    public Game(String name1, String name2, int startTurn){
        this.white = new Player(name1, 0);
        this.black = new Player(name2, 1);
        this.whoseTurn = startTurn;
    }

    public Board getBoard(){
        return this.board;
    }

    public Player getWhite(){
        return this.white;
    }

    public Player getBlack(){
        return this.black;
    }

    public int getTurn(){
        return this.whoseTurn;
    }

    public void changeTurn(){
        if(this.whoseTurn == 1)
            this.whoseTurn = 0;
        else
            this.whoseTurn = 1;
    }
}

//https://codereview.stackexchange.com/questions/71790/design-a-chess-game-using-object-oriented-principles
