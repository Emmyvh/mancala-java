package mancala.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MancalaImplTest {

    @Test
    public void whenAGameStartsPlayerOneGoesFirst() {
        MancalaImpl mancala = new MancalaImpl();
        Boolean playerNumber = mancala.isPlayersTurn(1);
        assertEquals(true, playerNumber);
    }

    @Test
    public void whenAGameStartsPlayerTwoDoesNotGoFirst() {
        MancalaImpl mancala = new MancalaImpl();
        Boolean playerNumber = mancala.isPlayersTurn(2);
        assertEquals(false, playerNumber);
    }

    @Test
    public void whenAPlayerIsSwitchedAfterStartingTheGamePlayerTwoGetsToPlay() {
        MancalaImpl mancala = new MancalaImpl();
        mancala.getBoard().switchPlayer();
        mancala.setActivePlayer();
        Boolean playerNumber = mancala.isPlayersTurn(2);
        assertEquals(true, playerNumber);
    }

    @Test
    public void whenAMoveIsMadeStonesAreTakenFromAPit() throws MancalaException {
        MancalaImpl mancala = new MancalaImpl();
        mancala.playPit(1);
        assertEquals(0, mancala.getBoard().getPlayerOne().getCups().get(0).getStonesPerCup());
        assertEquals(5, mancala.getBoard().getPlayerOne().getCups().get(1).getStonesPerCup());
        assertEquals(5, mancala.getBoard().getPlayerOne().getCups().get(2).getStonesPerCup());
        assertEquals(5, mancala.getBoard().getPlayerOne().getCups().get(3).getStonesPerCup());
        assertEquals(5, mancala.getBoard().getPlayerOne().getCups().get(4).getStonesPerCup());
        assertEquals(4, mancala.getBoard().getPlayerOne().getCups().get(5).getStonesPerCup());
        assertEquals(0, mancala.getBoard().getPlayerOne().getScore());
    }

    @Test
    public void whenAPitIsSelectedForPlayerOneItsStonesAreReturned() throws MancalaException {
        MancalaImpl mancala = new MancalaImpl();
        mancala.getStonesForPit(1);
        int stonesInCupOne = mancala.getBoard().getActivePlayer().getCups().get(1).getStonesPerCup();
        assertEquals(4, stonesInCupOne);
    }

    @Test
    public void whenKalahaOneIsSelectedAScoreIsReturned() throws MancalaException {
        MancalaImpl mancala = new MancalaImpl();
        mancala.getStonesForPit(6);
        int stonesInKalaha = mancala.getBoard().getActivePlayer().getScore();
        assertEquals(0, stonesInKalaha);
    }

    @Test
    public void whenAPitIsSelectedForPlayerTwoItsStonesAreReturned() throws MancalaException {
        MancalaImpl mancala = new MancalaImpl();
        mancala.getBoard().switchPlayer();
        mancala.setActivePlayer();
        mancala.getStonesForPit(7);
        int stonesInCupOne = mancala.getBoard().getActivePlayer().getCups().get(1).getStonesPerCup();
        assertEquals(4, stonesInCupOne);
    }

    @Test
    public void whenKalahaTwoIsSelectedAScoreIsReturned() throws MancalaException {
        MancalaImpl mancala = new MancalaImpl();
        mancala.getBoard().switchPlayer();
        mancala.setActivePlayer();
        mancala.getStonesForPit(13);
        int stonesInKalaha = mancala.getBoard().getActivePlayer().getScore();
        assertEquals(0, stonesInKalaha);
    }

    @Test
    public void whenAGameIsStartedItHasNotEnded() {
        MancalaImpl mancala = new MancalaImpl();
        Boolean gameEnded = mancala.isEndOfGame();
        assertEquals(false, gameEnded);
    }

    @Test
    public void whenAGameIsStartedThereIsNoWinnerYet() {
        MancalaImpl mancala = new MancalaImpl();
        int winner = mancala.getWinner();
        assertEquals(0, winner);
    }

    @Test
    public void whenAPlayerOneHasHigherScoreAtGameEndTheyWin() throws MancalaException {
        MancalaImpl mancala = new MancalaImpl();
        mancala.playPit(3);
        mancala.getBoard().getPlayerOne().getCups().forEach(cup -> cup.emptyACup());
        int winner = mancala.getWinner();
        assertEquals(1, winner);
    }

    @Test
    public void whenAPlayerTwoHasHigherScoreAtGameEndTheyWin() throws MancalaException {
        MancalaImpl mancala = new MancalaImpl();
        mancala.getBoard().switchPlayer();
        mancala.setActivePlayer();
        mancala.playPit(3);
        mancala.getBoard().getPlayerTwo().getCups().forEach(cup -> cup.emptyACup());
        int winner = mancala.getWinner();
        assertEquals(2, winner);
    }

}
