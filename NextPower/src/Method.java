import java.util.Scanner;
public class Method {
    public void find_next_power() {
        Scanner eingabe = new Scanner(System.in);
        System.out.print("Gib eine natuerliche Zahl ein:");
        int a = eingabe.nextInt();
        System.out.print("Gib eine Potenz ein (noch eine natuerliche Zahl):");
        int b = eingabe.nextInt();
        double d = Math.ceil(Math.pow(a, 1.0 / b));
        int c = (int) Math.pow(d, b); //rounding up b'th root of a and conv. to int
        if (c == a) {
            c = (int) Math.pow(d+1, b);
        }
        String str = String.format("find_next_power(%1$d;%2$d)="+c, a, b);
        System.out.println(str);
    }
}
