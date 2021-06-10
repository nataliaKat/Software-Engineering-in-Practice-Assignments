package sourcefilereaders;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SourceFileNullReaderTest {

    private SourceFileNullReader sourceFileNullReader;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testReadFileWeb() {
        sourceFileNullReader = new SourceFileNullReader(new WebLocation(), "somefilepath");
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Unknown read method.");
        sourceFileNullReader.readFile();
    }

    @Test
    public void testReadFileLocal() {
        sourceFileNullReader = new SourceFileNullReader(new LocalLocation(), "somefilepath");
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Unknown read method.");
        sourceFileNullReader.readFile();
    }

}