public class Main {

    public static void main(String[] args) {

        find_next_power(1245678, 6);
    }

    static void find_next_power(int val, int pow) {
        double end;
        do {

            end = Math.pow(val, 1 / (double) pow);
            val++;
        } while (!(((Math.round(end * 10000000000.0) / 10000000000.0) % 1) == 0));
//        while (!((end % 1) == 0));
        val--;

        System.out.println("result: " + val + " exponent: " + end);

    }
}
//        1419855 = 16.999997605391982
//
//        1419856 = 17.000000000000004
//
//        1419857 = 17.00000239460667

