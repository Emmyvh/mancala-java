package mancala.domain;
// Import our test dependencies. We import the Test-attribute
// and a set of assertions.
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CupTest {

//Testing variables
    @Test
    public void WhenAGameStartsACupHasFourStones () {
        Cup cupOne = new Cup();
        assertEquals(4, cupOne.getStonesPerCup());
    }

//Move related tests
    @Test
    public void WhenYouMakeAMoveYouAddAStone (){
        Cup cupOne = new Cup();
        cupOne.addOneStoneToACup();
        assertEquals (5,cupOne.getStonesPerCup());
    }

    @Test
    public void WhenYouMakeAMoveYouEmptyTheCup (){
        Cup cupOne = new Cup();
        cupOne.emptyACup();
        assertEquals(0, cupOne.getStonesPerCup());
    }
}