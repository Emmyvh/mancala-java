package mancala.domain;

// Import our test dependencies. We import the Test-attribute
// and a set of assertions.

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CupTest {

    // Testing variables
    @Test
    public void whenGameStartsCupHasFourStones() {
        Cup cupOne = new Cup();
        assertEquals(4, cupOne.getStonesPerCup());
    }

    // Move related tests
    @Test
    public void whenYouMakeMoveYouAddStone() {
        Cup cupOne = new Cup();
        cupOne.addOneStoneToACup();
        assertEquals(5, cupOne.getStonesPerCup());
    }

    @Test
    public void whenYouMakeMoveYouEmptyCup() {
        Cup cupOne = new Cup();
        cupOne.emptyACup();
        assertEquals(0, cupOne.getStonesPerCup());
    }
}
