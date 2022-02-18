package mancala.domain;

import  org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void WhenAGameStartsThereAreTwoPlayers (){
        Player playerOne = new Player (new Kalaha());
        Player playerTwo = new Player (new Kalaha());
        Board mancala = new Board (playerOne, playerTwo);
        assertEquals(playerOne, mancala.getPlayerOne());
        assertEquals(playerTwo, mancala.getPlayerTwo());
    }

    @Test
    public void WhenAPlayerHasStonesLeftAGameDoesNotEnd () {
        Player playerOne = new Player(new Kalaha());
        Player playerTwo = new Player(new Kalaha());
        Board mancala = new Board(playerOne, playerTwo);
        assertFalse(mancala.gameEnded());
    }

    @Test
    public void WhenAPlayerHasNoStonesLeftAGameEnds () {
        Player playerOne = new Player(new Kalaha());
        Player playerTwo = new Player(new Kalaha());
        Board mancala = new Board(playerOne, playerTwo);
        mancala.getPlayerOne().getCups().forEach(Cup::emptyACup);
        assertTrue(mancala.gameEnded());
    }

    @Test
    public void WhenAGameStartsPlayerOneIsTheActivePlayer () {
        Player playerOne = new Player(new Kalaha());
        Player playerTwo = new Player(new Kalaha());
        Board mancala = new Board(playerOne, playerTwo);
        assertEquals(playerOne, mancala.getActivePlayer());
    }

    @Test
    public void WhenATurnEndsThePlayerIsSwitched () {
        Player playerOne = new Player(new Kalaha());
        Player playerTwo = new Player(new Kalaha());
        Board mancala = new Board(playerOne, playerTwo);
        mancala.switchPlayer();
        assertEquals(playerTwo, mancala.getActivePlayer());
    }

    @Test
    public void WhenMakingAMoveWithCupThreeTheNumberOfStonesInCupsChange (){
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
    public void WhenMakingAMoveWithCupSixTheActivePlayerIsSwitched (){
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
    public void WhenMakingAMoveWithCupSixTheActivePlayerIsSwitchedAndPlayerTwoGetsToMakeAMove (){
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
    public void WhenAllCupsOnOneSideAreEmptyAWinnerIsDeclared (){
        Player playerOne = new Player(new Kalaha());
        Player playerTwo = new Player(new Kalaha());
        Board mancala = new Board(playerOne, playerTwo);

        mancala.getActivePlayer().getCups().forEach(cup -> cup.emptyACup());

        assertEquals(null, mancala.winnerCheck());
    }

}
