import org.junit.Test;
import static org.junit.Assert.*;

public class PiecesTest {

    /**
     * Tests pawn movement on board, if piece coordinates change,
     * if new space has the piece, if old space no longer has piece
     * Pawn isValidMove, Board movePiece, and Space takeSpace
     * Pawn tries to move 2 spaces after first move, should return as invalid
     */
    @Test
    public void movePawnTest(){
        Game testGame = new Game("David", "Goliath", 0);
        Board theboard = testGame.getBoard();
        Space startSpace = theboard.getSpace(0, 1);
        Piece thepawn = startSpace.getPiece();
        boolean success = theboard.movePiece(thepawn, 0, 3);
        assertTrue(success);
        Space endSpace = theboard.getSpace(0, 3);
        assertEquals(thepawn.getXcoord(), 0);
        assertEquals(thepawn.getYcoord(), 3);
        assertEquals(thepawn, endSpace.getPiece());
        assertEquals(null, startSpace.getPiece());
        boolean success2 = theboard.movePiece(thepawn, 0, 5);
        assertFalse(success2);
    }

    /**
     * Tests trying to make an invalid move, if new space remains empty,
     * if movePiece returns false, if starting space still has piece
     */
    @Test
    public void invalidPawnMoveTest(){
        Game testGame = new Game("David", "Goliath", 0);
        Board theboard = testGame.getBoard();
        Space startSpace = theboard.getSpace(0, 1);
        Piece thepawn = startSpace.getPiece();
        boolean success = theboard.movePiece(thepawn, 4, 2);
        assertFalse(success);
        Space endSpace = theboard.getSpace(4, 2);
        assertEquals(null, endSpace.getPiece());
        assertEquals(thepawn, startSpace.getPiece());
    }

    /**
     * Tests queen movement isValidMove
     * Tests Board movePiece
     * Tests Space takeSpace
     */
    @Test
    public void moveQueenTest(){
        Game testGame = new Game("David", "Goliath", 0);
        Board theboard = testGame.getBoard();
        Space startSpace = theboard.getSpace(1, 3);
        theboard.clearBoard();
        Piece queen = new Queen(1, 3, 0);
        startSpace.placePiece(queen, 1, 3);
        boolean success = theboard.movePiece(queen, 2, 4);
        assertTrue(success);
        Space endSpace = theboard.getSpace(2, 4);
        assertEquals(queen, endSpace.getPiece());
        assertEquals(null, startSpace.getPiece());
        assertEquals(queen.getXcoord(), 2);
        assertEquals(queen.getYcoord(), 4);
        success = theboard.movePiece(queen, 3, 6);
        assertFalse(success);
    }


}
