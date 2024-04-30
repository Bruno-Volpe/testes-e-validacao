import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class IsLeapTest {

    private Cal cal;

    @Before
    public void setUp() {
        cal = new Cal();
    }

    @Test
    public void testLeapYearBefore1752() {
        assertTrue(cal.isLeap(1704));
        assertFalse(cal.isLeap(1703));
    }

    @Test
    public void testLeapYearAfter1752() {
        assertTrue(cal.isLeap(2000));
        assertFalse(cal.isLeap(1900));
        assertTrue(cal.isLeap(2004));
        assertFalse(cal.isLeap(2001));
    }

    @Test
    public void testNonLeapYear() {
        assertFalse(cal.isLeap(2100));
        assertFalse(cal.isLeap(2019));
    }
}
