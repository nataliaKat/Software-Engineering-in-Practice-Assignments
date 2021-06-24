package metricsexporters;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CsvExporterTest {

    MetricsExporter metricsExporter = new CsvExporter();

    @Test
    public void testWriteFile() {
        // create the metrics content
        Map<String, Integer> metrics = new HashMap<>();
        metrics.put("loc",30);
        metrics.put("nom",5);
        metrics.put("noc",2);

        // generate and write the output file
        String outputFilepath = "src/test/resources/output_metrics";
		metricsExporter.writeFile(metrics, outputFilepath);

        // evaluate that the file exists
        File outputFile = new File(outputFilepath + ".csv");
        Assert.assertTrue(outputFile.exists());

        // delete the generated file
        outputFile.delete();
    }

}