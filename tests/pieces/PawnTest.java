package pieces;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class PawnTest {

    @Test
    public void testCreate(){

        Pawn firstPawn = new Pawn(Pawn.WHITE);
        assertEquals(Pawn.WHITE, firstPawn.getColor());

        Pawn secondPawn = new Pawn(Pawn.BLACK);
        assertEquals(Pawn.BLACK, secondPawn.getColor());

        Pawn thirdPawn = new Pawn();
        assertEquals("white", thirdPawn.getColor());
    }
}
