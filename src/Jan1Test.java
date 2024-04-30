import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Jan1Test {

    private Cal cal;

    @Before
    public void setUp() {
        cal = new Cal();
    }

    @Test
    public void testGregorianCalendarPost1752() {
        int expectedDayOfWeek = 6;
        Assert.assertEquals("1º de janeiro em um ano após 1752", expectedDayOfWeek, cal.jan1(2000));
    }

    @Test
    public void testYearOfCalendarChangeover() {
        int expectedDayOfWeek = 3;
        Assert.assertEquals("1º de janeiro de 1752", expectedDayOfWeek, cal.jan1(1752));
    }

    @Test
    public void testJulianCalendarPre1752() {
        int expectedDayOfWeek = 1;
        Assert.assertEquals("1º de janeiro em um ano antes de 1752", expectedDayOfWeek, cal.jan1(1700));
    }
}
