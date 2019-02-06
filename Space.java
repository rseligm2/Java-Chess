public class Space {
    private Piece piece;
    private boolean occupied;

    public Space(){
        this.piece = null;
        this.occupied = false;
    }

    public void takeSpace(Piece newpiece){
        if(this.piece == null) {
            this.piece = newpiece;
            this.occupied = true;
        }else{
            if(this.piece.color != newpiece.color){
                this.piece.alive = false;
                this.piece = newpiece;
            }
        }

    }

}

//https://codereview.stackexchange.com/questions/71790/design-a-chess-game-using-object-oriented-principles

