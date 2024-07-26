import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AboutMeTest {

  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @Test
  @DisplayName("At least 4 lines of output")
  public void testOutput() {
    System.setOut(new PrintStream(outputStreamCaptor));
    AboutMe.main(new String[]{});
    String actual = outputStreamCaptor.toString();
    System.setOut(standardOut);
    String[] lines = actual.split("\n");
    assertTrue(lines.length >= 4, "Program produces at least 4 lines of output.");

  }
}