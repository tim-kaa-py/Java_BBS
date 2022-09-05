import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void buddyTest() {
        assertEquals(Arrays.asList(48, 75), Main.buddy(1, 50));
    }

    @Test
    void buddyTest2() {
        assertEquals(Arrays.asList(48, 75), Main.buddy(48, 50));
    }

    @Test
    void buddyTest3() {
        assertEquals(Arrays.asList(75, 48), Main.buddy(50, 100));
    }

    @Test
    void buddyTest4() {
        assertEquals(Arrays.asList(140, 195), Main.buddy(100, 250));
    }

    @Test
    void buddyTest5() {
        assertEquals(Arrays.asList(195, 140), Main.buddy(150, 250));
    }

    @Test
    void buddyFail() {
        assertEquals(Arrays.asList(), Main.buddy(1, 40));
        //assertNull(Main.buddy(1, 40));
    }


}