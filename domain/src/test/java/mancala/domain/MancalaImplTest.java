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
    public void whenAPitIsSelectedItsStonesAreReturned() throws MancalaException {
        MancalaImpl mancala = new MancalaImpl();
        mancala.getStonesForPit(1);
        int stonesInCupOne = mancala.getBoard().getActivePlayer().getCups().get(1).getStonesPerCup();
        assertEquals(4, stonesInCupOne);
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

}
