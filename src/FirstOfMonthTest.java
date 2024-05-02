import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void testFirstOfMonth() {
        Cal cal = new Cal();
        int m = 10; // mês maior que 9
        int a = 1752; // ano igual a 1752
        int expected = 0; // valor esperado, ajuste conforme necessário
        int result = cal.firstOfMonth(m, a);
        assertEquals(expected, result);
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
