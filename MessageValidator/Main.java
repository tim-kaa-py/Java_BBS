package MessageValidator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String message;
        MessageValidator run = new MessageValidator();
        message = run.read_input().toLowerCase();
        System.out.println();
        System.out.println("check method:");
        System.out.println(run.check_character(message));

        System.out.println("regex method:");
        if (!Character.isDigit(message.charAt(0))){
            System.out.println("It is an invalid String.");
            System.exit(0);
        }
        Pattern p = Pattern.compile("[a-z]+|\\d+");
        Matcher m = p.matcher(message);
        ArrayList<String> allMatches = new ArrayList<>();
        while (m.find()) {
            allMatches.add(m.group());
        }
        System.out.println(allMatches);

        List<Integer> listNumber = new ArrayList<Integer>();
        List<Integer> listLength = new ArrayList<Integer>();

        for (String allMatch : allMatches) {
            try{
                int number = Integer.parseInt(allMatch);
                listNumber.add(number);//
            }
            catch (NumberFormatException ex){
                int length = allMatch.length();
                listLength.add(length);
                //ex.printStackTrace();
            }
        }
        System.out.println(listNumber);
        System.out.println(listLength);
        boolean result = false;
        if (listLength.size() != listNumber.size()){
            result= false;
            System.out.println("It is an invalid String.");
            System.exit(0);
        }

        for (int i = 0; i < listNumber.size(); i++) {
            if (listLength.get(i) == listNumber.get(i)){
                result = true;
                }
            else{
                result = false;
                System.out.println("It is an invalid String.");
                System.exit(0);
            }

        }
        System.out.println("It is a valid String.");
        System.out.println("Congratulation! You made it!");
        }
    }

