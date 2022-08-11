

public class Main {
    public static void main(String[] args) {

        Validator run = new Validator();
        run.read_input();
        run.check_preconditions();
        boolean result = run.check();
        System.out.println(result);
    }
}