import java.util.Objects;

public class StringParser {

    /**
     * Checks if the string has a specific format
     * example "3hey5hello2hi" should be split into 3, hey, 5, hello, 2, hi and the function should return true, because "hey" is 3 characters, "hello" is 5, and "hi" is 2; as the numbers and the
     * character counts match, the result is true
     *
     * @param s String to check
     * @return true, if String is valid
     */
    public static boolean checkStringFormat(String s) {
        Objects.requireNonNull(s, "String must not be null");
        if (s.length() == 0) return true;

        int charCounter = 0;
        boolean lastCharWasDigit = true;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (!lastCharWasDigit && charCounter != 0) return false;
                lastCharWasDigit = true;
                charCounter = charCounter * 10 + Character.getNumericValue(c);
            } else if (charCounter > 0) {
                lastCharWasDigit = false;
                charCounter--;
            } else {
                return false;
            }
        }
        return charCounter == 0;
    }
}

