import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NumberOfDaysTest {

    private Cal cal;

    @Before
    public void setUp() {
        cal = new Cal();
    }

    @Test
    public void testMonthsWith31Days() {
        int[] monthsWith31Days = { 1, 3, 5, 7, 8, 10, 12 };
        for (int month : monthsWith31Days) {
            assertEquals(31, cal.numberOfDays(month, 2023));
        }
    }

    @Test
    public void testMonthsWith30Days() {
        int[] monthsWith30Days = { 4, 6, 9, 11 };
        for (int month : monthsWith30Days) {
            assertEquals(30, cal.numberOfDays(month, 2023));
        }
    }

    @Test
    public void testFebruaryInNonLeapYear() {
        assertEquals(28, cal.numberOfDays(2, 2023));
    }

    @Test
    public void testFebruaryInLeapYear() {
        assertEquals(29, cal.numberOfDays(2, 2024));
    }

    @Test
    public void testSpecialCaseOfSeptember1752() {
        assertEquals(19, cal.numberOfDays(9, 1752));
    }
}
