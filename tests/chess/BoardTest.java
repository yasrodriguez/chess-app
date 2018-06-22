package chess;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class BoardTest {
    Board board;

    @Before
    public void setUp(){
        board = new Board();

    }

    @Test
    public void testCreate(){
        assertEquals(16, board.getNumberOfPieces());
        assertEquals("pppppppp", board.getSecondRank());
        assertEquals("PPPPPPPP", board.getSeventhRank());
    }
}
