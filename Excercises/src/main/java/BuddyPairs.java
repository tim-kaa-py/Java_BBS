import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuddyPairs {
    public static List<Long> buddy(long start, long limit) {

        for (long i = start; i < limit; i++) {
            final List<Long> divisors = calculateDivisors(i);
            final long sumDivisors = divisors.stream().mapToLong(Long::longValue).sum();
            final List<Long> buddy = calculateDivisors(sumDivisors - 1);
            final long sumBuddy = buddy.stream().mapToLong(Long::longValue).sum();
            if (i == sumBuddy - 1) {
                return Arrays.asList(i, sumDivisors - 1);
            }
        }
        return null;
    }

    private static List<Long> calculateDivisors(Long number) {
        final ArrayList<Long> divisors = new ArrayList<>();
        for (long i = 1L; i < number; i++) {
            if (number % i == 0) divisors.add(i);
        }
        return divisors;
    }
}
