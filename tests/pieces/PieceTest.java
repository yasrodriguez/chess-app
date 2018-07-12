package pieces;

import org.junit.Test;

import static org.junit.Assert.*;


public class PieceTest {

    @Test
    public void testCreate(){

        Piece firstPawn = Piece.create(Piece.Color.WHITE,Piece.Type.PAWN);
        assertEquals(Piece.Color.WHITE, firstPawn.getColor());
        assertEquals(firstPawn.getRepresentation(), 'p');

        Piece secondPawn = Piece.create(Piece.Color.BLACK, Piece.Type.PAWN);
        assertEquals(Piece.Color.BLACK, secondPawn.getColor());
        assertEquals(secondPawn.getRepresentation(), 'P');
    }

    @Test
    public void testIsWhite(){
        Piece firstPiece = Piece.create(Piece.Color.WHITE, Piece.Type.ROOK);
        Piece secondPiece =  Piece.create(Piece.Color.BLACK, Piece.Type.QUEEN);
        assertTrue(firstPiece.isWhite());
        assertFalse(secondPiece.isWhite());
    }

    @Test
    public void testIsBlack(){
        Piece firstPiece = Piece.create(Piece.Color.WHITE,  Piece.Type.ROOK);
        Piece secondPiece =  Piece.create(Piece.Color.BLACK, Piece.Type.QUEEN);
        assertFalse(firstPiece.isBlack());
        assertTrue(secondPiece.isBlack());
    }
}
