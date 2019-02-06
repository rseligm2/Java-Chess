public class Piece {
    private int xcoord;
    private int ycoord;
    public boolean alive;
    public int color;

    public Piece(int x, int y, boolean isAlive){
        this.xcoord = x;
        this.ycoord = y;
        this.alive = isAlive;
    }

    public int getXcoord(){
        return this.xcoord;
    }

    public int getYcoord(){
        return this.ycoord;
    }

    public void setXcoord(int x){
        this.xcoord = x;
    }

    public void setYcoord(int y){
        this.ycoord = y;
    }

    public void killPiece(){
        this.alive = false;
    }

}

//https://codereview.stackexchange.com/questions/71790/design-a-chess-game-using-object-oriented-principles

