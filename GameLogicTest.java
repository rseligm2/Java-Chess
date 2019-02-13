import org.junit.Test;
import static org.junit.Assert.*;

public class GameLogicTest {

    /**
     * Tests if Board playerCheck works when a white Queen is in
     * front of a black King.
     * theboard.playerCheck() should return 1 because black King is in danger
     * Tests if Game isGameOver() works when black king is killed
     */
    @Test
    public void testCheck(){
        Game testGame = new Game("David", "Goliath", 0);
        Board theboard = testGame.getBoard();
        Space queenSpace = theboard.getSpace(2,2);
        Piece whiteQueen = theboard.getSpace(4,0).getPiece();
        Space kingSpace = theboard.getSpace(2, 5);
        Piece blackKing = theboard.getSpace(3, 7).getPiece();
        theboard.clearBoard();
        queenSpace.placePiece(whiteQueen, 2, 2);
        kingSpace.placePiece(blackKing, 2, 5);
        int check = theboard.playerCheck();
        assertEquals(1, check);
        theboard.movePiece(whiteQueen, 2, 5);
        boolean over = testGame.isGameOver();
        assertTrue(over);
        int gamesWon = testGame.getWhite().getGamesWon();
        assertEquals(1, gamesWon);
        int gamesLost = testGame.getBlack().getGamesLost();
        assertEquals(1, gamesLost);
    }

    /**
     * Tests of Board playerCheck works when pieces are at starting position
     * theboard.playerCheck() should return -1, as neither side has check
     */
    @Test
    public void testNoCheck(){
        Game testGame = new Game("David", "Goliath", 0);
        Board theboard = testGame.getBoard();
        int check = theboard.playerCheck();
        assertEquals(-1, check);
    }


}

