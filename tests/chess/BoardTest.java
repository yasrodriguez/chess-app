package chess;

import org.junit.Before;
import org.junit.Test;
import pieces.Pawn;
import static junit.framework.TestCase.assertEquals;

public class BoardTest {
    Board board;

    @Before
    public void setUp(){
        board = new Board();

    }

    @Test
    public void testCreate(){
        assertEquals(0, board.getNumberOfPieces());
    }

    @Test
    public void addPawn(){
        Pawn blackPawn = new Pawn(Pawn.BLACK);
        board.add(blackPawn);
        assertEquals(1, board.getNumberOfPieces());
        assertEquals(Pawn.BLACK, board.getPieces(0).getColor());

        Pawn whitePawn = new Pawn(Pawn.WHITE);
        board.add(whitePawn);
        assertEquals(2, board.getNumberOfPieces());
        assertEquals(Pawn.WHITE, board.getPieces(1).getColor());
    }
}
