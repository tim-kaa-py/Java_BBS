import java.util.Scanner;
public class Method {
    public void find_next_power() {
        Scanner eingabe = new Scanner(System.in);
        System.out.print("Gib eine natuerliche Zahl ein:");
        int a = eingabe.nextInt();
        System.out.print("Gib eine Potenz ein (noch eine natuerliche Zahl):");
        int b = eingabe.nextInt();
        int c = (int) Math.pow(Math.ceil(Math.pow(a, 1.0 / b)), b); //rounding up b'th root of a and conv. to int
        if (c == a) {
            c = (int) Math.pow(a + 1.0, b);
        }
        System.out.println(String.format("find_next_power(%1$d;%2$d)="+c, a, b));
    }
}
