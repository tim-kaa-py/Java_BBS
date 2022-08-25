package BuddyPairs;

import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static int getDivisorSum(int n){
        List<Integer> divisors = new ArrayList<>();
        int sum = 0;
        for (int i = 1; i < n; ++i)
            if (n % i == 0){
                divisors.add(i);
                sum = sum + i;
            }
        return sum;
    }
}
