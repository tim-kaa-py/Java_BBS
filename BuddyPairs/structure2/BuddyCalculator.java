package BuddyPairs;

import java.util.ArrayList;
import java.util.List;

import static BuddyPairs.Helper.getDivisorSum;

public class BuddyCalculator implements IBuddyCalculator{
    @Override
    public List<Integer> method1(int start ,int limit) {
        List<Integer> pair = new ArrayList<>();
        for (int n = start; n < limit; ++n) {
            for (int m = n + 1; m < limit * limit; ++m) {
                if (getDivisorSum(m) == n + 1 && getDivisorSum(n) == m + 1) {
                    pair.add(n);
                    pair.add(m);
                }
            }
        }
        return pair;
    }

    @Override
    public List<Integer> method2 (int start, int limit){
        List<Integer> pair = new ArrayList<>();
        for (int n = start; n < limit; ++n) {
            int m = getDivisorSum(n) - 1;
            if (getDivisorSum(m) == n + 1 && m > n) {
                pair.add(n);
                pair.add(m);
            }
        }
        return pair;
    }
}