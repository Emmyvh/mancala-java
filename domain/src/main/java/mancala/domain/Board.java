package mancala.domain;

public class Board {

    // Setting up 2 player objects
    private Player playerOne;
    private Player playerTwo;
    private Player activePlayer;

    public Board(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.activePlayer = playerOne;
    }

    // Getters for the two players
    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public Player getOpponent() {
        if (activePlayer == playerOne) {
            return playerTwo;
        } else {
            return playerOne;
        }
    }

    // Check if the game has ended and if there is a winner.
    public boolean gameEnded() {
        if (playerOne.hasStonesLeft() && playerTwo.hasStonesLeft()) {
            return false;
        } else {
            return true;
        }
    }

    public Player winnerCheck() {
        if (!gameEnded()) {
            return null;
        } else if (playerOne.getScore() > playerTwo.getScore()) {
            return playerOne;
        } else {
            if (playerTwo.getScore() > playerOne.getScore()) {
                return playerTwo;
            } else {
                return null;
            }
        }
    }

    public void switchPlayer() {
        if (activePlayer == playerOne) {
            activePlayer = playerTwo;
        } else {
            activePlayer = playerOne;
        }
    }

    public void playerMove(int cupNumber) {
        this.winnerCheck();
        StoneCollectors activeElement = getActivePlayer().makeMove(cupNumber, getOpponent().getCups());
        if (!(activeElement instanceof Kalaha)) {
            this.switchPlayer();
        }
    }
}
