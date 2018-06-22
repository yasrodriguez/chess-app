package pieces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PawnTest {

    @Test
    public void testCreate(){

        Pawn firstPawn = new Pawn(Pawn.WHITE, 'p');
        assertEquals(Pawn.WHITE, firstPawn.getColor());
        assertEquals(firstPawn.getIdentifier(), 'p');

        Pawn secondPawn = new Pawn(Pawn.BLACK, 'P');
        assertEquals(Pawn.BLACK, secondPawn.getColor());
        assertEquals(secondPawn.getIdentifier(), 'P');

        Pawn thirdPawn = new Pawn();
        assertEquals("white", thirdPawn.getColor());
        assertEquals(thirdPawn.getIdentifier(), 'p');
    }
}
