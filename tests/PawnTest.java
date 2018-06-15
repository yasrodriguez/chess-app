import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PawnTest {

    @Test
    public void testCreate(){
        final String FIRST_PAWN_COLOR = "white";
        Pawn firstPawn = new Pawn(FIRST_PAWN_COLOR);
        assertEquals(FIRST_PAWN_COLOR, firstPawn.getColor());

        final String SECOND_PAWN_COLOR = "black";
        Pawn secondPawn = new Pawn(SECOND_PAWN_COLOR);
        assertEquals(SECOND_PAWN_COLOR, secondPawn.getColor());
    }
}
