package SmallestPower;

import MessageValidator.MessageValidator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        readInput();

    }

    public static void readInput() {
        //Create a tool for reading user input and name it scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Type a value (>0): ");
        int value = input.nextInt();
        Scanner input2 = new Scanner(System.in);
        System.out.print("Type the power (>1): ");
        int power = input2.nextInt();
            output(value, power);
        }

    public static void output(int value ,int power) {
        if (value > 0 && power > 1) {
            int i = 1;
            double result = 0;
            while (Math.pow(i, power) <= value) {
                result = Math.pow(i, power);
                i++;
            }
            System.out.println("The smallest power value is: " + Math.pow(i, power));
        }
        else {
            System.out.println("Please restart and enter valid value!");
            System.exit(0);
        }
    }
}
