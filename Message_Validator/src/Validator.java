import java.util.Scanner;

public class Validator {

    String message=null;
    String precondition_check_result=null;

    public boolean check() {

        if (message.isEmpty()) {
            System.out.println("The message you entered was empty (but valid).");
            return true;
        }

        if (precondition_check_result.equals("invalid")) {
            System.out.println("The message you entered was invalid. Please enter a string only containing if numbers AND letters without spaces.");
            return false;
        }



        String[] strArr = message.split("(?<=\\D)(?=\\d)");
        for (String split_message_part : strArr) {
            //System.out.println(i);
            //System.out.println(strArr[i]);
            String[] sub_strArr = split_message_part.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
            int supposed_length;
            try {
                //Fails if a letter string is used here which means the order of letters and numbers was wrong (Tim3 instead of 3Tim)
                supposed_length = Integer.parseInt(sub_strArr[0]);
            } catch (Exception e) {
                System.out.println("The message you entered was invalid.");
                return false;
            }
            int actual_length;
            try {
                //Fails if string contains uneven number of letters and number blocks so e.g. 2hi2
                actual_length = sub_strArr[1].length();
            } catch (Exception e) {
                System.out.println("The message you entered was invalid.");
                return false;
            }

            if (supposed_length != actual_length) {
                System.out.println("The message you entered was invalid.");
                return false;
            }


        }

        System.out.println("The message you entered was valid.");
        return true;
    }
    public void check_preconditions() {



        if (message.matches("[a-zA-Z0-9]+")) { //only mix of numbers and letters, no other character

            precondition_check_result="valid";

            if (message.matches("[0-9]+")) { //only numbers
                precondition_check_result="invalid";

            }

            if (message.matches("[a-zA-Z]+")) {//only letters
                precondition_check_result="invalid";

            }

        }
        else if(message.isEmpty()){
                //Allow empty strings to pass because they would be filtered by the else condition
                precondition_check_result="valid";
        }
        else{
            precondition_check_result="invalid";
        }


    }

    public void read_input() {
        Scanner sc= new Scanner(System.in);  //System.in is a standard input stream
        System.out.print("Enter a message (without spaces): ");
        message= sc.nextLine();   //reads string before the space
        System.out.print("You have entered: "+message+"\n");
    }



}


