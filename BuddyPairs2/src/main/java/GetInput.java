import java.util.Scanner;

public class GetInput {
    public static int[] getStartLimit(){
        Scanner input = new Scanner(System.in);
        System.out.print("Type a value for the start: ");
        int start = input.nextInt();
        Scanner input2 = new Scanner(System.in);
        System.out.print("Type a value for the limit: ");
        int limit = input2.nextInt();
        int[] Pair = new int[]{start,limit};
        return Pair;
    }
}
