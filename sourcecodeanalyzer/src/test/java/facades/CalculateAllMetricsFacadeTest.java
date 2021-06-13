package facades;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class CalculateAllMetricsFacadeTest {

    /**
     * Simulates an integration test
     * @throws IOException
     */
    @Test
    public void testCalculateAllMetrics() throws IOException {
        String filepath = "src/test/resources/TestClass.java";
        String analyzerType = "strcomp";
        String location = "local";
        String path = "src/test/resources/filefromfacadetest";
        String outputFileType = "csv";

        CalculateAllMetricsFacade calculateAllMetricsFacade = new CalculateAllMetricsFacade();
        calculateAllMetricsFacade.calculateAllMetrics(filepath, analyzerType, location,
                path, outputFileType);

        File expected = new File("src/test/resources/expected-output.csv");
        File actual = new File("src/test/resources/filefromfacadetest.csv");
        boolean isTwoEqual = FileUtils.contentEquals(expected, actual);
        assertEquals(isTwoEqual, true);
        actual.delete();
    }


}