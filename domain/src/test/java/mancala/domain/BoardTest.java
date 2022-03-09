package mancala.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void whenGameStartsThereAreTwoPlayers() {
        Player playerOne = new Player(new Kalaha());
        Player playerTwo = new Player(new Kalaha());
        Board mancala = new Board(playerOne, playerTwo);
        assertEquals(playerOne, mancala.getPlayerOne());
        assertEquals(playerTwo, mancala.getPlayerTwo());
    }

    @Test
    public void whenPlayerHasStonesLeftGameDoesNotEnd() {
        Player playerOne = new Player(new Kalaha());
        Player playerTwo = new Player(new Kalaha());
        Board mancala = new Board(playerOne, playerTwo);
        assertFalse(mancala.gameEnded());
    }

    @Test
    public void whenPlayerHasNoStonesLeftGameEnds() {
        Player playerOne = new Player(new Kalaha());
        Player playerTwo = new Player(new Kalaha());
        Board mancala = new Board(playerOne, playerTwo);
        mancala.getPlayerOne().getCups().forEach(Cup::emptyACup);
        assertTrue(mancala.gameEnded());
    }

    @Test
    public void whenGameStartsPlayerOneIsActivePlayer() {
        Player playerOne = new Player(new Kalaha());
        Player playerTwo = new Player(new Kalaha());
        Board mancala = new Board(playerOne, playerTwo);
        assertEquals(playerOne, mancala.getActivePlayer());
    }

    @Test
    public void whenTurnEndsPlayerIsSwitched() {
        Player playerOne = new Player(new Kalaha());
        Player playerTwo = new Player(new Kalaha());
        Board mancala = new Board(playerOne, playerTwo);
        mancala.switchPlayer();
        assertEquals(playerTwo, mancala.getActivePlayer());
    }

    @Test
    public void whenAPlyerIsSwitchedTwicePlayerOneHasTheTurn() {
        Player playerOne = new Player(new Kalaha());
        Player playerTwo = new Player(new Kalaha());
        Board mancala = new Board(playerOne, playerTwo);
        mancala.switchPlayer();
        mancala.switchPlayer();
        assertEquals(playerOne, mancala.getActivePlayer());
    }

    @Test
    public void whenMakingMoveWithCupThreeNumberOfStonesInCupsChange() {
        Player playerOne = new Player(new Kalaha());
        Player playerTwo = new Player(new Kalaha());
        Board mancala = new Board(playerOne, playerTwo);
        mancala.playerMove(3);
        assertEquals(4, playerOne.getCups().get(0).getStonesPerCup());
        assertEquals(4, playerOne.getCups().get(1).getStonesPerCup());
        assertEquals(0, playerOne.getCups().get(2).getStonesPerCup());
        assertEquals(5, playerOne.getCups().get(3).getStonesPerCup());
        assertEquals(5, playerOne.getCups().get(4).getStonesPerCup());
        assertEquals(5, playerOne.getCups().get(5).getStonesPerCup());

        assertEquals(1, playerOne.getScore());

        assertEquals(playerOne, mancala.getActivePlayer());
    }

    @Test
    public void whenMakingMoveWithCupSixTheActivePlayerIsSwitched() {
        Player playerOne = new Player(new Kalaha());
        Player playerTwo = new Player(new Kalaha());
        Board mancala = new Board(playerOne, playerTwo);
        mancala.playerMove(6);
        assertEquals(4, playerOne.getCups().get(0).getStonesPerCup());
        assertEquals(4, playerOne.getCups().get(1).getStonesPerCup());
        assertEquals(4, playerOne.getCups().get(2).getStonesPerCup());
        assertEquals(4, playerOne.getCups().get(3).getStonesPerCup());
        assertEquals(4, playerOne.getCups().get(4).getStonesPerCup());
        assertEquals(0, playerOne.getCups().get(5).getStonesPerCup());

        assertEquals(1, playerOne.getScore());

        assertEquals(5, playerTwo.getCups().get(0).getStonesPerCup());
        assertEquals(5, playerTwo.getCups().get(1).getStonesPerCup());
        assertEquals(5, playerTwo.getCups().get(2).getStonesPerCup());
        assertEquals(4, playerTwo.getCups().get(3).getStonesPerCup());
        assertEquals(4, playerTwo.getCups().get(4).getStonesPerCup());
        assertEquals(4, playerTwo.getCups().get(5).getStonesPerCup());

        assertEquals(playerTwo, mancala.getActivePlayer());
    }

    @Test
    public void whenMakingMoveWithCupSixTheActivePlayerIsSwitchedAndPlayerTwoCanPlay() {
        Player playerOne = new Player(new Kalaha());
        Player playerTwo = new Player(new Kalaha());
        Board mancala = new Board(playerOne, playerTwo);
        mancala.playerMove(6);
        assertEquals(4, playerOne.getCups().get(0).getStonesPerCup());
        assertEquals(4, playerOne.getCups().get(1).getStonesPerCup());
        assertEquals(4, playerOne.getCups().get(2).getStonesPerCup());
        assertEquals(4, playerOne.getCups().get(3).getStonesPerCup());
        assertEquals(4, playerOne.getCups().get(4).getStonesPerCup());
        assertEquals(0, playerOne.getCups().get(5).getStonesPerCup());

        assertEquals(1, playerOne.getScore());

        assertEquals(5, playerTwo.getCups().get(0).getStonesPerCup());
        assertEquals(5, playerTwo.getCups().get(1).getStonesPerCup());
        assertEquals(5, playerTwo.getCups().get(2).getStonesPerCup());
        assertEquals(4, playerTwo.getCups().get(3).getStonesPerCup());
        assertEquals(4, playerTwo.getCups().get(4).getStonesPerCup());
        assertEquals(4, playerTwo.getCups().get(5).getStonesPerCup());
        assertEquals(playerTwo, mancala.getActivePlayer());

        mancala.playerMove(2);

        assertEquals(5, playerTwo.getCups().get(0).getStonesPerCup());
        assertEquals(0, playerTwo.getCups().get(1).getStonesPerCup());
        assertEquals(6, playerTwo.getCups().get(2).getStonesPerCup());
        assertEquals(5, playerTwo.getCups().get(3).getStonesPerCup());
        assertEquals(5, playerTwo.getCups().get(4).getStonesPerCup());
        assertEquals(5, playerTwo.getCups().get(5).getStonesPerCup());

        assertEquals(1, playerTwo.getScore());

        assertEquals(4, playerOne.getCups().get(0).getStonesPerCup());
        assertEquals(4, playerOne.getCups().get(1).getStonesPerCup());
        assertEquals(4, playerOne.getCups().get(2).getStonesPerCup());
        assertEquals(4, playerOne.getCups().get(3).getStonesPerCup());
        assertEquals(4, playerOne.getCups().get(4).getStonesPerCup());
        assertEquals(0, playerOne.getCups().get(5).getStonesPerCup());
        assertEquals(playerTwo, mancala.getActivePlayer());
    }

    @Test
    public void whenAllCupsOnOneSideAreEmptyWinnerIsDeclared() {
        Player playerOne = new Player(new Kalaha());
        Player playerTwo = new Player(new Kalaha());
        Board mancala = new Board(playerOne, playerTwo);

        mancala.getActivePlayer().getCups().forEach(cup -> cup.emptyACup());

        assertEquals(null, mancala.winnerCheck());
    }

}
