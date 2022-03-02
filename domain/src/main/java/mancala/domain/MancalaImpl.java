package mancala.domain;

public class MancalaImpl implements Mancala {

    private Player playerOne;
    private Player playerTwo;
    private Player activePlayer;
    private Board board;

    public MancalaImpl() {
        playerOne = new Player(new Kalaha());
        playerTwo = new Player(new Kalaha());
        board = new Board (playerOne, playerTwo);
        activePlayer = board.getActivePlayer();
    }

    @Override
    public boolean isPlayersTurn(int player) {
        if (player == PLAYER_ONE && activePlayer == playerOne) {
            return true;
        } else if (player == PLAYER_TWO && activePlayer == playerTwo) {
            return true;
        } else {
            return false;
        }
    }

    @Override
	public void playPit(int index) throws MancalaException {
        int reducedIndex = index % 7;
        board.playerMove(reducedIndex);
    }


    @Override
	public int getStonesForPit(int index) {
        int numberOfStones = 0;

        boolean isPlayerOneCup = index <= 6;
        int reducedIndex = index % 7;

        if (reducedIndex < 6) {
            numberOfStones = isPlayerOneCup ? board.getPlayerOne().getCups().get(reducedIndex).getStonesPerCup()
                                            : board.getPlayerTwo().getCups().get(reducedIndex).getStonesPerCup();
        } else {
            numberOfStones = isPlayerOneCup ? board.getPlayerOne().getScore() : board.getPlayerTwo().getScore();
        }
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
        }   else if (winner == playerTwo) {
                return PLAYER_TWO;
        }   else {
            return NO_PLAYERS;
        }
    }
}
