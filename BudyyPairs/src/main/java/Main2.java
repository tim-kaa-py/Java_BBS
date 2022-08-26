import java.util.List;

//import static GetInput.getStartLimit;
//import static Printer.printer;

public class Main2 {
    public static void main(String[] args) {
        int[] startLimitPair = GetInput.getStartLimit();
        BuddyCalculator buddyCalculator = new BuddyCalculator();
        List<Integer> buddyPair = buddyCalculator.findPair2(startLimitPair[0],startLimitPair[1]);
        Printer.printer(buddyPair);
    }
}

