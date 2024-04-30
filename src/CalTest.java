import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalTest {
    // Bruno Giacomini Volpe - 14651980
    // Guilherme Xavier - 14575641
    private Cal cal;

    @Before
    public void setUp() {
        cal = new Cal();
    }

    @Test
    public void testMonthStartingOnSunday() {
        String expected = " 1  2  3  4  5  6  7\n 8  9 10 11 12 13 14\n15 16 17 18 19 20 21\n22 23 24 25 26 27 28\n29 30 31            "
                .trim();
        Assert.assertEquals(expected, cal.cal(0, 31).trim());
    }

    @Test
    public void testCal19Dias() {
        Assert.assertEquals("1  2 14 15 16\n" +
                "17 18 19 20 21 22 23\n" +
                "24 25 26 27 28 29 30".trim(), cal.cal(1, 19).trim());
    }

    @Test
    public void testSpecialCaseSeptember1752() {
        String expected = "       1  2 14 15 16\n17 18 19 20 21 22 23\n24 25 26 27 28 29 30".trim();
        Assert.assertEquals(expected, cal.cal(6, 19).trim());
    }
}
