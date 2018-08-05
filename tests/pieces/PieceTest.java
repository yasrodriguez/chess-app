package pieces;

import chess.Board;
import mocks.BoardStub;
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

    @Test
    public void testGetRepresentationForType(){
        Piece piece = Piece.createWhiteRook();
        assertEquals(Piece.ROOK_REPRESENTATION, piece.getRepresentationForTypeAndColor( piece.getColor(), piece.getType()));

        Piece secondPiece = Piece.createBlackQueen();
        assertEquals(Character.toUpperCase(Piece.QUEEN_REPRESENTATION), secondPiece.getRepresentationForTypeAndColor(secondPiece.getColor(), secondPiece.getType()));
    }

    @Test
    public void testPieceStrength(){
        Board boardStub = new BoardStub().getSampleBoard();
        boardStub.calculateStrength(Piece.Color.WHITE);
        boardStub.calculateStrength(Piece.Color.BLACK);

        Piece whiteRook = boardStub.getPieceAtLocation("c8");
        assertEquals(Piece.ROOK_STRENGTH, whiteRook.getStrength(), 0);

        Piece whiteQueen = boardStub.getPieceAtLocation("g4");
        assertEquals(Piece.QUEEN_STRENGTH, whiteQueen.getStrength(), 0);

        Piece whiteKnight = boardStub.getPieceAtLocation("f4");
        assertEquals(Piece.KNIGHT_STRENGTH, whiteKnight.getStrength(), 0);

        Piece blackKing = boardStub.getPieceAtLocation("b8");
        assertEquals(Piece.KING_STRENGTH, blackKing.getStrength(), 0);

        Piece blackBishop = boardStub.getPieceAtLocation("d7");
        assertEquals(Piece.BISHOP_STRENGTH, blackBishop.getStrength(), 0);

        //TODO: Calculate pawn strength
//        Piece whitePawn = boardStub.getPieceAtLocation("f3");
//        assertEquals(Piece.MULTIPLE_PAWN_STRENGTH, whitePawn.getStrength(), 0);
//
//        Piece blackPawn = boardStub.getPieceAtLocation("b6");
//        assertEquals(Piece.LONE_PAWN_STRENGTH, blackPawn.getStrength(), 0);
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
