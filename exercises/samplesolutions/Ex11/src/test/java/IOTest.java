import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IOTest {

    @Test
    public void testPrintArray() {

    // set up testable input and output channels
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(out);
    // redirect the standard channels
        System.setOut(output);
    // call to method that does standard I/O
        IO.printArray(new int[] {1, 2, 3, 4});
        String string = out.toString();
        assertEquals("1 2 3 4 ", string);
    // redirect the standard channels back!
        System.setOut(System.out);
    }
}
