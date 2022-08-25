package BuddyPairs;

import java.util.List;

public class Printer {
    public static void printer(List<Integer> pair){
        if (pair.isEmpty()){
            System.out.println("There is no so-called buddyPair in the range you given");
        }
        else {
            System.out.println("The buddyPair is: " + pair);
        }
    }
}
