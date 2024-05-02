import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testMainPrintsExpectedOutputForSpecificMonthAndYear() {
        String[] args = { "4", "2023" };
        Cal.main(args);
        String expectedOutputPart = "Abril 2023";
        assertTrue("The output should contain: " + expectedOutputPart,
                outContent.toString().contains(expectedOutputPart));
    }

    @Test
    public void testInvalidMonth() {
        String[] args = { "0", "2023" };
        Cal.main(args);
        assertTrue("Should print an error message for invalid month",
                errContent.toString().contains("mes invalido"));
    }

    @Test
    public void testInvalidYear() {
        String[] args = { "12", "10000" };
        Cal.main(args);
        assertTrue("Should print an error message for invalid year",
                errContent.toString().contains("ano invalido"));
    }

    @Test
    public void testInvalidYearWithNoMonth() {
        String[] args = { "10000" };
        Cal.main(args);
        assertTrue("Should print an error message for invalid year when no month is provided",
                errContent.toString().contains("ano invalido"));
    }

    @Test
    public void testMainWithNoArguments() {
        Cal.main(new String[] {});
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", new Locale("pt", "BR"));
        String formattedDate = currentDate.format(formatter);
        formattedDate = formattedDate.substring(0, 1).toUpperCase() + formattedDate.substring(1);
        assertTrue("The output should contain the current month and year.",
                outContent.toString().contains(formattedDate));
    }

    @Test
    public void testMainPrintsAllMonthsForGivenYear() {
        String[] args = { "2023" };
        Cal.main(args);
        String expectedMonths[] = {
                "Janeiro 2023", "Fevereiro 2023", "Março 2023", "Abril 2023",
                "Maio 2023", "Junho 2023", "Julho 2023", "Agosto 2023",
                "Setembro 2023", "Outubro 2023", "Novembro 2023", "Dezembro 2023"
        };

        for (String month : expectedMonths) {
            assertTrue("The output should contain: " + month, outContent.toString().contains(month));
        }
    }

    @Test
    public void testInvalidMonthLowerBound() {
        String[] args = { "0", "2023" }; // Mês é 0, definitivamente inválido
        Cal.main(args);
        assertTrue("Should print an error message for month less than 1",
                errContent.toString().contains("mes invalido"));
    }

    @Test
    public void testInvalidMonthUpperBound() {
        String[] args = { "13", "2023" }; // Mês é 13, definitivamente inválido
        Cal.main(args);
        assertTrue("Should print an error message for month greater than 12",
                errContent.toString().contains("mes invalido"));
    }

    @Test
    public void testInvalidYearLowerBound() {
        String[] args = { "4", "0" }; // Ano é 0, definitivamente inválido
        Cal.main(args);
        assertTrue("Should print an error message for year less than 1",
                errContent.toString().contains("ano invalido"));
    }

    @Test
    public void testInvalidYearUpperBound() {
        String[] args = { "4", "10000" }; // Ano é 10000, definitivamente inválido
        Cal.main(args);
        assertTrue("Should print an error message for year greater than 9999",
                errContent.toString().contains("ano invalido"));
    }

    @Test
    public void testInvalidYearSingleArgumentLowerBound() {
        String[] args = { "0" }; // Ano é 0, definitivamente inválido
        Cal.main(args);
        assertTrue("Should print an error message for year less than 1 when no month is provided",
                errContent.toString().contains("ano invalido"));
    }

    @Test
    public void testInvalidYearSingleArgumentUpperBound() {
        String[] args = { "10000" }; // Ano é 10000, definitivamente inválido
        Cal.main(args);
        assertTrue("Should print an error message for year greater than 9999 when no month is provided",
                errContent.toString().contains("ano invalido"));
    }

}
