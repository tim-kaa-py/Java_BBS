import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BuddyPairsTest {

    @Test
    void buddyTest() {
        assertEquals(Arrays.asList(48L, 75L), BuddyPairs.buddy(1L, 50L));
    }

    @Test
    void buddyTest2() {
        assertEquals(Arrays.asList(48L, 75L), BuddyPairs.buddy(48L, 50L));
    }

    @Test
    void buddyTest3() {
        assertNull(BuddyPairs.buddy(50L, 100L));
    }

    @Test
    void buddyTest4() {
        assertEquals(Arrays.asList(140L, 195L), BuddyPairs.buddy(100L, 250L));
    }

    @Test
    void buddyTest5() {
        assertNull(BuddyPairs.buddy(50L, 100L));
    }

    @Test
    void buddyFail() {
        assertNull(BuddyPairs.buddy(1L, 40L));
    }
}