package sourcefilereaders;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;

public class SourceFileListReaderTest {

    @Test
    public void testReadFileLocal() throws IOException {
        LocalLocation localLocation = mock(LocalLocation.class);
        SourceFileListReader sourceFileListReader = new SourceFileListReader(localLocation, "whateverlocal");

        ArrayList<String> expected = new ArrayList<>();
        expected.add("line 1");
        expected.add("line 2");
        expected.add("line 3");
        when(localLocation.readFileIntoList("whateverlocal"))
                .thenReturn(expected);
        assertEquals(expected, sourceFileListReader.readFile());
    }

    @Test
    public void testReadFileWeb() throws IOException {
        WebLocation webLocation = mock(WebLocation.class);
        SourceFileListReader sourceFileListReader = new SourceFileListReader(webLocation, "whateverweb");

        ArrayList<String> expected = new ArrayList<>();
        expected.add("line 1");
        expected.add("line 2");
        expected.add("line 3");
        when(webLocation.readFileIntoList("whateverweb"))
                .thenReturn(expected);
        assertEquals(expected, sourceFileListReader.readFile());
    }

}