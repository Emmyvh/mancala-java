package mancala.domain;

public class Kalaha implements StoneCollectors{

    private int currentNumberOfStonesInAKalaha;


    // Getter for Stones
    public int getStonesPerKalaha() {
        return currentNumberOfStonesInAKalaha;
    }

    // Adding stones
    public void addOneStoneToACup() {
        this.currentNumberOfStonesInAKalaha += 1;
    }

}
