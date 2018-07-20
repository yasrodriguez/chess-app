package pieces;

import org.junit.Test;

import static org.junit.Assert.*;


public class PieceTest {

    @Test
    public void testCreate(){
        verifyCreation(Piece.createWhitePawn(), Piece.createBlackPawn(), Piece.Type.PAWN, Piece.PAWN_REPRESENTATION);
        verifyCreation(Piece.createWhiteRook(), Piece.createBlackRook(), Piece.Type.ROOK, Piece.ROOK_REPRESENTATION);
        verifyCreation(Piece.createWhiteBishop(), Piece.createBlackBishop(), Piece.Type.BISHOP, Piece.BISHOP_REPRESENTATION);
        verifyCreation(Piece.createWhiteKnight(), Piece.createBlackKnight(), Piece.Type.KNIGHT, Piece.KNIGHT_REPRESENTATION);
        verifyCreation(Piece.createWhiteQueen(), Piece.createBlackQueen(), Piece.Type.QUEEN, Piece.QUEEN_REPRESENTATION);
        verifyCreation(Piece.createWhiteKing(), Piece.createBlackKing(), Piece.Type.KING, Piece.KING_REPRESENTATION);

        Piece blank = Piece.noPiece();
        assertEquals('.', blank.getRepresentation());
        assertEquals(Piece.Type.NO_PIECE, blank.getType());
    }

    @Test
    public void testIsWhite(){
        Piece firstPiece = Piece.createWhiteRook();
        Piece secondPiece =  Piece.createBlackQueen();
        assertTrue(firstPiece.isWhite());
        assertFalse(secondPiece.isWhite());
    }

    @Test
    public void testIsBlack(){
        Piece firstPiece = Piece.createWhiteRook();
        Piece secondPiece =  Piece.createBlackQueen();
        assertFalse(firstPiece.isBlack());
        assertTrue(secondPiece.isBlack());
    }

    private static void verifyCreation(Piece whitePiece, Piece blackPiece, Piece.Type type, char representation){
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());
        assertEquals(representation, whitePiece.getRepresentation());

        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
        assertEquals(Character.toUpperCase(representation), blackPiece.getRepresentation());
    }
}
