package chess;

import org.junit.Before;
import org.junit.Test;
import pieces.Piece;
import util.StringUtil;

import static junit.framework.TestCase.assertEquals;

public class BoardTest {
    Board board;

    @Before
    public void setUp(){
        board = new Board();

    }

    @Test
    public void testCreate(){
        assertEquals(32, board.pieceCount());

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
    }

    @Test
    public void testNumberOfPieces(){
        Board board1 = new Board();
        assertEquals(8, board1.getNumberOfPieces(Piece.Color.WHITE, Piece.PAWN_REPRESENTATION));
        assertEquals(2, board1.getNumberOfPieces(Piece.Color.BLACK, Character.toUpperCase(Piece.BISHOP_REPRESENTATION)));
    }
}
