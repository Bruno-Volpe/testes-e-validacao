import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertTrue;

public class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainPrintsExpectedOutputForSpecificMonthAndYear() {
        String[] args = { "4", "2023" };
        Cal.main(args);
        String expectedOutputPart = "Abril 2023";
        assertTrue("A saída deveria conter: " + expectedOutputPart, outContent.toString().contains(expectedOutputPart));
    }
}
