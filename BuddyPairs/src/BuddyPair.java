import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class BuddyPair {
    public void buddy() {
        Scanner eingabe = new Scanner(System.in);
        System.out.print("Gib eine natuerliche Startzahl ein:");
        int start = eingabe.nextInt();
        System.out.print("Gib eine natuerliche Grenzzahl ein:");
        int limit = eingabe.nextInt();
        Map dict = new LinkedHashMap();
        for (int n = start; n <= limit; n++) {
            int teilersumme = 0;
            for (int teiler = 2; teiler < n; teiler++) {
                if (n % teiler == 0) {
                    teilersumme += teiler;
                }
            }
            if (n < teilersumme) {
                dict.put(n, teilersumme);
            }
        }
        System.out.println(dict);

        int teilersumme1 = 0;
        int k = 0;
        for (int m = 0; m <= dict.size() - 1; m++) {
            k = (int) dict.values().toArray()[m];
            teilersumme1 = 0;
            for (int teiler = 2; teiler < k; teiler++) {
                if (k % teiler == 0) {
                    teilersumme1 += teiler;
                }
            }
            if (dict.containsKey(teilersumme1) == true) {
                if (teilersumme1 == (int) dict.get(teilersumme1)) {
                    break;
                }
            }
        }
        String str = String.format("body(%3$d;%4$d) returns [%1$d;%2$d]", teilersumme1, k, start, limit);
        System.out.println(str);

    }
}
