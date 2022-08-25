public class IHaveThePower {
    /**
     * We have the number 12385. We want to know the value of the closest cube but higher than 12385. The answer will be 13824.
     * <p>
     * Now, another case. We have the number 1245678. We want to know the 5th power, closest and higher than that number. The value will be 1419857.
     * <p>
     * We need a function find_next_power that receives two arguments, a value val, and the exponent of the power, pow_, and outputs the
     * value that we want to find.
     */
    static double find_next_power(double number, double power) {
        if (number <= 0 | power <= 0) return 0;

        double counter = 1;
        do {
            final double result = Math.pow(counter, power);
            if (result > number) return result;
            counter++;
        } while (true);
    }
}