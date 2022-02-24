package mancala.domain;

import  org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void WhenMakingANewPlayerHeHasSixCups () {
        Player player = new Player(new Kalaha());
        List<Cup> cups = player.getCups();
        assertEquals (6, cups.size());
    }

    @Test
    public void WhenStartingAPlayerHasTwentyFourStones () {
        Player player = new Player(new Kalaha());
        assertEquals(24, player.getNumberOfStonesPerPlayer());
    }

    @Test
    public void WhenPickingTheFirstBowlTheNumberOfStonesDecreases() {
        Player player = new Player(new Kalaha());
        Cup cup = player.getCups().get(0);
        cup.emptyACup();
        assertEquals(20, player.getNumberOfStonesPerPlayer());
    }

    @Test
    public void WhenStartingAGameThePlayerScoreIsZero () {
        Player player = new Player(new Kalaha());
        assertEquals (0, player.getScore());
    }

    @Test
    public void WhenAddingAStoneToTheKalahaScoreIsOne () {
        Kalaha kalaha = new Kalaha ();
        Player player = new Player(kalaha);
        kalaha.addOneStoneToACup();
        assertEquals(player.getScore(), kalaha.getStonesPerKalaha());
    }

    @Test
    public void WhenAllCupsAreEmptyAPlayerHasNoStonesLeft() {
        Player player = new Player(new Kalaha());
        player.getCups().forEach(cup -> cup.emptyACup());
        assertFalse(player.hasStonesLeft());
    }

    @Test
    public void whenNotAllCupsAreEmptyAPlayerHasStonesLeft() {
        Player player = new Player(new Kalaha());
        Cup cup = player.getCups().get(0);
        cup.emptyACup();
        assertTrue(player.hasStonesLeft());
    }

    @Test
    public void WhenPickingACupTheCupIsEmpty(){
        Player player = new Player(new Kalaha());
        player.makeMove(1, new ArrayList<>());
        assertEquals(0, player.getCups().get(0).getStonesPerCup());
    }

    @Test
    public void whenPickingCupOneItsStonesAreDistributed() {
        Player player = new Player(new Kalaha());
        var opponentCups = Arrays.asList(new Cup(), new Cup(), new Cup(), new Cup(), new Cup(), new Cup());
        player.makeMove(1, opponentCups);

        assertEquals(0, player.getCups().get(0).getStonesPerCup());
        assertEquals(5, player.getCups().get(1).getStonesPerCup());
        assertEquals(5, player.getCups().get(2).getStonesPerCup());
        assertEquals(5, player.getCups().get(3).getStonesPerCup());
        assertEquals(5, player.getCups().get(4).getStonesPerCup());
        assertEquals(4, player.getCups().get(5).getStonesPerCup());
        assertEquals(0, player.getScore());
    }

    @Test
    public void whenPickingCupThreeItsStonesAreDistributed() {
        Player player = new Player(new Kalaha());
        var opponentCups = Arrays.asList(new Cup(), new Cup(), new Cup(), new Cup(), new Cup(), new Cup());
        player.makeMove(3, opponentCups);

        assertEquals(4, player.getCups().get(0).getStonesPerCup());
        assertEquals(4, player.getCups().get(1).getStonesPerCup());
        assertEquals(0, player.getCups().get(2).getStonesPerCup());
        assertEquals(5, player.getCups().get(3).getStonesPerCup());
        assertEquals(5, player.getCups().get(4).getStonesPerCup());
        assertEquals(5, player.getCups().get(5).getStonesPerCup());
        assertEquals(1, player.getScore());

    }

    @Test
    public void whenPickingCupSixItsStonesAreDistributed() {
        Player player = new Player(new Kalaha());
        var opponentCups = Arrays.asList(new Cup(), new Cup(), new Cup(), new Cup(), new Cup(), new Cup());
        player.makeMove(6, opponentCups);

        assertEquals(4, player.getCups().get(0).getStonesPerCup());
        assertEquals(4, player.getCups().get(1).getStonesPerCup());
        assertEquals(4, player.getCups().get(2).getStonesPerCup());
        assertEquals(4, player.getCups().get(3).getStonesPerCup());
        assertEquals(4, player.getCups().get(4).getStonesPerCup());
        assertEquals(0, player.getCups().get(5).getStonesPerCup());

        assertEquals(1, player.getScore());

        assertEquals(5, opponentCups.get(0).getStonesPerCup());
        assertEquals(5, opponentCups.get(1).getStonesPerCup());
        assertEquals(5, opponentCups.get(2).getStonesPerCup());
        assertEquals(4, opponentCups.get(3).getStonesPerCup());
        assertEquals(4, opponentCups.get(4).getStonesPerCup());
        assertEquals(4, opponentCups.get(5).getStonesPerCup());
    }

    @Test
    public void WhenTheLastStoneLandsInAnEmptyBowlTheOpponentsStonesAreAddedToTheKahala() {
        var player = new Player(new Kalaha());
        player.getCups().get(4).emptyACup();
        var opponentCups = Arrays.asList(new Cup(), new Cup(), new Cup(), new Cup(), new Cup(), new Cup());
        player.makeMove(1, opponentCups);

        assertEquals(0, opponentCups.get(1).getStonesPerCup());
        assertEquals(5, player.getScore());
    }

}
