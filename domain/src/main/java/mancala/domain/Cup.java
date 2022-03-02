package mancala.domain;

public class Cup implements StoneCollectors {

    //variables
    private int currentNumberOfStonesInACup;

    // constructor for cups
    public Cup() {
        currentNumberOfStonesInACup = 4;
    }

    //Setters and Getters
    public int getStonesPerCup() {
        return currentNumberOfStonesInACup;
    }

    //Move associated code
    public void emptyACup() {
        this.currentNumberOfStonesInACup = 0;
    }

    public void addOneStoneToACup() {
        this.currentNumberOfStonesInACup += 1;
    }
}
