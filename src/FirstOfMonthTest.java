import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FirstOfMonthTest {

    private Cal cal;

    @Before
    public void setUp() {
        cal = new Cal();
    }

    @Test
    public void testMonthInNonLeapYear() {
        int expectedDayOfWeek = 3;
        Assert.assertEquals(expectedDayOfWeek, cal.firstOfMonth(3, 2023));
    }

    @Test
    public void testMonthInLeapYearAfterFebruary() {
        int expectedDayOfWeek = 5;
        Assert.assertEquals(expectedDayOfWeek, cal.firstOfMonth(3, 2024));
    }

    @Test
    public void testJanuaryInLeapYear() {
        int expectedDayOfWeek = 1;
        Assert.assertEquals(expectedDayOfWeek, cal.firstOfMonth(1, 2024));
    }

    @Test
    public void testJanuaryInNonLeapYear() {
        int expectedDayOfWeek = 0;
        Assert.assertEquals(expectedDayOfWeek, cal.firstOfMonth(1, 2023));
    }

    @Test
    public void testSpecialCaseOfYear1752() {
        int expectedDayOfWeek = 2;
        Assert.assertEquals(expectedDayOfWeek, cal.firstOfMonth(9, 1752));
    }
}
