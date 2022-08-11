import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IHaveThePowerTest {

    @Test
    void basicTest() {
        assertEquals(IHaveThePower.find_next_power(12385, 3), 13824);
    }

    @Test
    void differentPower() {
        assertEquals(IHaveThePower.find_next_power(1245678, 5), 1419857);
    }
}