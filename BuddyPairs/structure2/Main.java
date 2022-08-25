package BuddyPairs;
import java.util.List;

import static BuddyPairs.GetInput.getStartLimit;
import static BuddyPairs.Printer.printer;

public class Main {
    public static void main(String[] args) {
        int[] StartLimitPair = getStartLimit();
        IBuddyCalculator buddyCalculator = new BuddyCalculator();
        List<Integer> buddyPair = buddyCalculator.method1(StartLimitPair[0],StartLimitPair[1]);
        printer(buddyPair);
    }
}

