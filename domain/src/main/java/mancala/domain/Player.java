package mancala.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    private Kalaha kalaha;
    private List<Cup> cups;
    private StoneCollectors activeElement = null;

    //Defining the variables. Each player has their own cups, a kalaha, and opponent cups.
    public Player(Kalaha playerKalaha) {
        this.kalaha = playerKalaha;
        cups = Arrays.asList(new Cup(), new Cup(), new Cup(), new Cup(), new Cup(), new Cup());
    }

    //Getters for score, total number of stones for this player, list Cups, and List opponent Cups.
    public int getScore() {
        return kalaha.getStonesPerKalaha();
    }

    public List<Cup> getCups() {
        return cups;
    }

    public int getNumberOfStonesPerPlayer() {
        int numberOfStonesInAllCups = getCups().get(0).getStonesPerCup() + getCups().get(1).getStonesPerCup() + getCups().get(2).getStonesPerCup() + getCups().get(3).getStonesPerCup() + getCups().get(4).getStonesPerCup() + getCups().get(5).getStonesPerCup();
        return numberOfStonesInAllCups;
    }

    //Checking if a cup has stones left.
    public boolean hasStonesLeft() {
        if (getNumberOfStonesPerPlayer() > 0) {
            return true;
        } else {
            return false;
        }
    }

    //Move making method
    public StoneCollectors makeMove(int selectedCupNumber, List<Cup> opponentCups) {
        List<StoneCollectors> stoneCollectors = new ArrayList<>(getCups());
        stoneCollectors.add(kalaha);
        stoneCollectors.addAll(opponentCups);

        //Declare a variable as the selected cup and declare a variable with its number of stones.
        Cup selectedCup = getCups().get(selectedCupNumber - 1);
        int numberOfStonesSelectedCup = selectedCup.getStonesPerCup();

        selectedCup.emptyACup();

        //Assign an Empty variable by declaring it null. This throws an exception if not used in the for loop.
        for (int i = selectedCupNumber; i < selectedCupNumber + numberOfStonesSelectedCup; i++) {
            activeElement = stoneCollectors.get(i % stoneCollectors.size());
            activeElement.addOneStoneToACup();
        }

        if (activeElement instanceof Kalaha) {
            return activeElement;
        }

        Cup lastCup = (Cup) activeElement;
        if (getCups().contains(lastCup) && lastCup.getStonesPerCup() == 1) {
            lastCup.emptyACup();
            kalaha.addOneStoneToACup();
            Cup opponentsCup = opponentCups.get(5 - getCups().indexOf(lastCup));
            for (int i = 0; i < opponentsCup.getStonesPerCup(); i++) {
                kalaha.addOneStoneToACup();
            }
            opponentsCup.emptyACup();
        }
        return activeElement;
    }

}
