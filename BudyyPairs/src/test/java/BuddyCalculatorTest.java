import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BuddyCalculatorTest {
    
    @Test
    void buddyTest() {
        assertEquals(Arrays.asList(48, 75), BuddyCalculator.findPair2(1, 50));
    }

    @Test
    void buddyTest2() {
        assertEquals(Arrays.asList(48, 75), BuddyCalculator.findPair2(48, 50));
    }


    @Test
    void buddyTest4() {
        assertEquals(Arrays.asList(140, 195), BuddyCalculator.findPair2(100, 250));
    }
    

    @Test
    void buddyFail() {
        assertEquals(Arrays.asList(), BuddyCalculator.findPair2(1, 40));
    }
}