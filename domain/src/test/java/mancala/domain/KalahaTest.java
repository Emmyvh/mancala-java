package mancala.domain;

import  org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KalahaTest {

//Testing variables
    @Test
    public void WhenAGameStartsAKalahaHasZeroStones () {
        Kalaha kalaha = new Kalaha();
        assertEquals(0, kalaha.getStonesPerKalaha());
    }

    @Test
    public void WhenAGameMoveIsMadeYouCanAddAStoneToTheKalaha () {
        Kalaha kalaha = new Kalaha();
        kalaha.addOneStoneToACup();
        assertEquals(1, kalaha.getStonesPerKalaha());
    }

}
