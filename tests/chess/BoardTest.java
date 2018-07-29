package chess;

import org.junit.Before;
import org.junit.Test;
import pieces.Piece;
import util.StringUtil;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoardTest {
    Board board;

    @Before
    public void setUp(){
        board = new Board();
    }

    @Test
    public void testCreate(){
        assertEquals(0, board.pieceCount());

        String blankRank = StringUtil.appendNewLine("........");
        String expectedBoard =  StringUtil.appendNewLine("RNBQKBNR") +
                StringUtil.appendNewLine("PPPPPPPP") +
                blankRank +
                blankRank +
                blankRank +
                blankRank +
                StringUtil.appendNewLine("pppppppp") +
                StringUtil.appendNewLine("rnbqkbnr");

        board.initialize();

        assertEquals(expectedBoard, board.print());
        assertEquals(32, board.pieceCount());
    }

    @Test
    public void testNumberOfPieces(){
        board.initialize();
        assertEquals(8, board.getNumberOfPiecesForType(Piece.Color.WHITE, Piece.PAWN_REPRESENTATION));
        assertEquals(2, board.getNumberOfPiecesForType(Piece.Color.BLACK, Character.toUpperCase(Piece.BISHOP_REPRESENTATION)));
    }

    @Test
    public void testGetPiece(){
        board.initialize();

        Piece pieceRetrieved = board.getPieceAtLocation("a8");
        assertEquals(Piece.Type.ROOK, pieceRetrieved.getType());
        assertTrue(pieceRetrieved.isBlack());

        pieceRetrieved = board.getPieceAtLocation("e1");
        assertEquals(Piece.Type.KING, pieceRetrieved.getType());
        assertTrue(pieceRetrieved.isWhite());

        board.flip();

        pieceRetrieved = board.getPieceAtLocation("a8");
        assertEquals(Piece.Type.ROOK, pieceRetrieved.getType());
        assertTrue(pieceRetrieved.isWhite());

        pieceRetrieved = board.getPieceAtLocation("e1");
        assertEquals(Piece.Type.KING, pieceRetrieved.getType());
        assertTrue(pieceRetrieved.isBlack());
    }

    @Test
    public void testPlacePieces(){
        assertEquals(0, board.pieceCount());

        board.placePiece(Piece.Color.BLACK, Piece.Type.KING, "b6");
        board.placePiece(Piece.Color.BLACK, Piece.Type.ROOK, "b5");
        board.placePiece(Piece.Color.WHITE, Piece.Type.KING, "c4");

        String blankRank = StringUtil.appendNewLine("........");
        String expectedBoard =  blankRank +
                blankRank +
                StringUtil.appendNewLine(".K......") +
                StringUtil.appendNewLine(".R......") +
                StringUtil.appendNewLine("..k.....") +
                blankRank +
                blankRank +
                blankRank;

        assertEquals(3, board.pieceCount());
        assertEquals(expectedBoard, board.print());
    }
}
