package metricsexporters;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class NullExporterTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testWriteFile() {
        MetricsExporter metricsExporter = new NullExporter();
        // create an empty metrics content
        Map<String, Integer> metrics = new HashMap<>();
        String outputFilepath = "whatever-path";

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Unknown file type");
        metricsExporter.writeFile(metrics, outputFilepath);
    }

}
