package sourcefilereaders;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SourceFileStringReaderTest {

    @Test
    public void testReadFileLocal() throws IOException {
        LocalLocation localLocation = mock(LocalLocation.class);
        SourceFileStringReader sourceFileStringReader = new SourceFileStringReader(localLocation, "whateverlocal");

        String expected = "test string";
        when(localLocation.readFileIntoString("whateverlocal"))
                .thenReturn(expected);
        assertEquals(expected, sourceFileStringReader.readFile());
    }

    @Test
    public void testReadFileWeb() throws IOException {
        WebLocation webLocation = mock(WebLocation.class);
        SourceFileStringReader sourceFileStringReader = new SourceFileStringReader(webLocation, "whateverweb");

        String expected = "test string";

        when(webLocation.readFileIntoString("whateverweb"))
                .thenReturn(expected);
        assertEquals(expected, sourceFileStringReader.readFile());
    }

}