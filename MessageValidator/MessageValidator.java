package MessageValidator;
//Introduce the scanner tool used for reading user input

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MessageValidator {
    public String read_input() {
        //Create a tool for reading user input and name it scanner
        Scanner input = new Scanner(System.in);
        //Print "Write a message: "
        System.out.print("Write a message: ");
        //Read the string written by the user, and assign it
        //to program memory "String message = (string that was given as input)"
        String message = input.nextLine();
        System.out.print("Your message is: ");
        System.out.print(message);
        return message;
    }
    public static boolean check_character(String message){
        if (message.length() == 0){
            return true;}
        // convert string to `char[]` array
        char[] chars = message.toCharArray();
        int charCounter = 0;
        boolean lastCharIsDigit = true;
        for (char ch: chars) {
            if (Character.isDigit(ch)){
                lastCharIsDigit = true;
                charCounter = charCounter*10 + Character.getNumericValue(ch);
            }
            else if (Character.isAlphabetic(ch)){
                lastCharIsDigit = false;
                charCounter--;
            }
            else{
                return false;}
            }
        return charCounter ==0;
    }

    }
