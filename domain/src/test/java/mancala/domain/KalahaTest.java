package mancala.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class KalahaTest {

    // Testing variables
    @Test
    public void whenGameStartsKalahaHasZeroStones() {
        Kalaha kalaha = new Kalaha();
        assertEquals(0, kalaha.getStonesPerKalaha());
    }

    @Test
    public void whenGameMoveIsMadeYouCanAddStoneToKalaha() {
        Kalaha kalaha = new Kalaha();
        kalaha.addOneStoneToACup();
        assertEquals(1, kalaha.getStonesPerKalaha());
    }

}
