package mancala.domain;

public class MancalaImpl implements Mancala {

    private Player playerOne;
    private Player playerTwo;
    private Player activePlayer;
    private Board board;

    public MancalaImpl(Player namePlayerOne, Player namePlayerTwo) {
        playerOne = namePlayerOne;
        playerTwo = namePlayerTwo;
        activePlayer = playerOne;
        board = new Board (playerOne, playerTwo);
    }

    @Override
    public boolean isPlayersTurn(int player) {
        if (player == PLAYER_ONE && activePlayer == playerOne) {
            return true;
        }else if (player == PLAYER_TWO && activePlayer == playerTwo) {
            return true;
        }else {return false;
        }
    }

    @Override
	public void playPit(int index) throws MancalaException {
        board.playerMove(index);
    }
	
	@Override
	public int getStonesForPit(int index) {
        int numberOfStones = board.getActivePlayer().getCups().get(index).getStonesPerCup();
        return numberOfStones;
    }

	@Override
	public boolean isEndOfGame() {
        boolean endGameCheck = board.gameEnded();
            return endGameCheck;
    }

	@Override
	public int getWinner() {
        Player winner = board.winnerCheck();
        if (winner == playerOne) { 
        return PLAYER_ONE;
        } else if (winner == playerTwo){
            return PLAYER_TWO;
        } else {return NO_PLAYERS;
        }
    }
}