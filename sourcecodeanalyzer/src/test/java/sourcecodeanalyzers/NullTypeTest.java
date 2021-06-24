package sourcecodeanalyzers;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class NullTypeTest {

    NullType nullType = new NullType();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCalculateLOC() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Unknown analyzing type. Could not calculate LOC.");
        nullType.calculateLOC();
    }

    @Test
    public void testCalculateNOC() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Unknown analyzing type. Could not calculate NOC.");
        nullType.calculateNOC();
    }

    @Test
    public void testCalculateNOM() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Unknown analyzing type. Could not calculate NOM.");
        nullType.calculateNOM();
    }

}