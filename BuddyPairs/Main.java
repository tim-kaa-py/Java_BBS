package BuddyPairs;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        readInput();
    }

    public static void readInput() {
        //Create a tool for reading user input and name it scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Type a value for the start: ");
        int start = input.nextInt();
        Scanner input2 = new Scanner(System.in);
        System.out.print("Type a value for the limit: ");
        int limit = input2.nextInt();
        buddy(start, limit);
    }

    public static void buddy(int start ,int limit) {
        List<Integer> pair = new ArrayList<>();
        for (int n = start; n < limit; ++n) {
            for (int m = n+1; m < limit * limit; ++m) {
                if (getDivisorSum(m) == n + 1 && getDivisorSum(n) == m + 1) {
                    System.out.println(n);
                    System.out.println(m);
                    pair.add(n);
                    pair.add(m);
                }
            }
        }
        if (pair.isEmpty()){
            System.out.println("Nothing");
        }
        else {
            System.out.println(pair);
        }
    }

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
