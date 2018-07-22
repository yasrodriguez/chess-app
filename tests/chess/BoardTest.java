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
        board.initialize();
        String blankRank = StringUtil.appendNewLine("........");
        String expectedBoard =  StringUtil.appendNewLine("RNBQKBNR") +
                                StringUtil.appendNewLine("PPPPPPPP") +
                                blankRank +
                                blankRank +
                                blankRank +
                                blankRank +
                                StringUtil.appendNewLine("pppppppp") +
                                StringUtil.appendNewLine("rnbqkbnr");
        assertEquals(expectedBoard, board.print());
        assertEquals(32, board.pieceCount());
    }

    @Test
    public void testNumberOfPieces(){
        board.initialize();
        assertEquals(8, board.getNumberOfPieces(Piece.Color.WHITE, Piece.PAWN_REPRESENTATION));
        assertEquals(2, board.getNumberOfPieces(Piece.Color.BLACK, Character.toUpperCase(Piece.BISHOP_REPRESENTATION)));
    }

    @Test
    public void testGetPiece(){
        board.initialize();

        Piece pieceRetrieved = board.getPiece("a8");
        assertEquals(Piece.Type.ROOK, pieceRetrieved.getType());
        assertTrue(pieceRetrieved.isBlack());

        pieceRetrieved = board.getPiece("e1");
        assertEquals(Piece.Type.KING, pieceRetrieved.getType());
        assertTrue(pieceRetrieved.isWhite());

        board.flip();

        pieceRetrieved = board.getPiece("a8");
        assertEquals(Piece.Type.ROOK, pieceRetrieved.getType());
        assertTrue(pieceRetrieved.isWhite());

        pieceRetrieved = board.getPiece("e1");
        assertEquals(Piece.Type.KING, pieceRetrieved.getType());
        assertTrue(pieceRetrieved.isBlack());
    }
}
