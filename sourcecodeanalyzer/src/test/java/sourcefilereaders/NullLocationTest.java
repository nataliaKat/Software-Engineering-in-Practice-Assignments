package sourcefilereaders;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static org.junit.Assert.*;

public class NullLocationTest {

    NullLocation location = new NullLocation();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testReadFileIntoList() throws IOException {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Unknown file location. Could not read into List.");
        location.readFileIntoList("whateverpath");
    }

    @Test
    public void testReadFileIntoString() throws IOException {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Unknown file location. Could not read into String.");
        location.readFileIntoString("whateverpath");
    }

}