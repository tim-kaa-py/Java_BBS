public class Main {

    public static void find_next_power(Integer input, Integer power){
        double result=0;
        int base=0;
        while (result < input) {
            result = Math.pow(base, power);
            base++;
        }
        int int_result = (int) result; //downcast double to int
        System.out.println("The next power of "+power+" above "+input+" (your input) is: "+int_result+".");
    }

    public static void main(String[] args) {
        find_next_power(12385, 3);
        find_next_power(1245678, 5);
    }
}