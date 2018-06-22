package pieces;

import org.junit.Test;

import static org.junit.Assert.*;


public class PieceTest {

    @Test
    public void testCreate(){

        Piece firstPawn = Piece.create(Piece.WHITE,"pawn");
        assertEquals(Piece.WHITE, firstPawn.getColor());
        assertEquals(firstPawn.getIdentifier(), 'p');

        Piece secondPawn = Piece.create(Piece.BLACK, "pawn");
        assertEquals(Piece.BLACK, secondPawn.getColor());
        assertEquals(secondPawn.getIdentifier(), 'P');
    }

    @Test
    public void testIsWhite(){
        Piece firstPiece = Piece.create(Piece.WHITE, "rook");
        Piece secondPiece =  Piece.create(Piece.BLACK, "queen");
        assertTrue(firstPiece.isWhite());
        assertFalse(secondPiece.isWhite());
    }

    @Test
    public void testIsBlack(){
        Piece firstPiece = Piece.create(Piece.WHITE, "rook");
        Piece secondPiece =  Piece.create(Piece.BLACK, "queen");
        assertFalse(firstPiece.isBlack());
        assertTrue(secondPiece.isBlack());
    }
}
