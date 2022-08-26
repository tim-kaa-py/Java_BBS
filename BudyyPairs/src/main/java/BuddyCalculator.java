import java.util.ArrayList;
import java.util.List;

//import static Helper.getDivisorSum;

public class BuddyCalculator{
    public List<Integer> findPair(int start , int limit) {
        List<Integer> pair = new ArrayList<>();
        for (int n = start; n < limit; ++n) {
            for (int m = n + 1; m < limit * limit; ++m) {
                if (Helper.getDivisorSum(m) == n + 1 && Helper.getDivisorSum(n) == m + 1) {
                    pair.add(n);
                    pair.add(m);
                }
            }
        }
        return pair;
    }

    public static List<Integer> findPair2(int start, int limit){
        List<Integer> pair = new ArrayList<>();
        for (int n = start; n < limit; ++n) {
            int m = Helper.getDivisorSum(n) - 1;
            if (Helper.getDivisorSum(m) == n + 1 && m > n) {
                pair.add(n);
                pair.add(m);
            }
        }
        return pair;
    }
}