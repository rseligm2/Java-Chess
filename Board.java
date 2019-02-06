public class Board {
    public final int BoardSize = 8;
    private Space[][] spaces = new Space[BoardSize][BoardSize];

    public Board(){
        for(int i = 0; i < spaces.length; i++){
            for(int j = 0; j < spaces.length; j++){
                this.spaces[i][j] = new Space();
            }
        }
    }

    public void movePiece(Piece movingpiece, int x, int y){
        spaces[x][y].takeSpace(movingpiece);
    }
}

//https://codereview.stackexchange.com/questions/71790/design-a-chess-game-using-object-oriented-principles
