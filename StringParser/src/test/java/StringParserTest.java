import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringParserTest {

    @Test
    void validNormalString() {
        assertTrue(StringParser.checkStringFormat("1h5hello2hi"));
    }

    @Test
    void validEmptyString() {
        assertTrue(StringParser.checkStringFormat(""));
    }

    @Test
    void validDoubleDigitString() {
        assertTrue(StringParser.checkStringFormat("12heyhellohiog"));
    }

    @Test
    void invalid1() {
        assertFalse(StringParser.checkStringFormat("hey5hello2hi"));
    }

    @Test
    void invalid2() {
        assertFalse(StringParser.checkStringFormat("3hey5he2lo2hi"));
    }

    @Test
    void invalid3() {
        assertFalse(StringParser.checkStringFormat("2hi2"));
    }
}