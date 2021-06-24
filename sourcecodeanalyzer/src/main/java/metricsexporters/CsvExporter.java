package metricsexporters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Exports (writes) the metrics to a given CSV file.
 *
 * @author Natalia Katsiapi
 */
public class CsvExporter implements MetricsExporter {

    /**
     * Creates a CSV file with the given metrics
     * @param metrics a Map with the metric name as key and metric value as value
     * @param filepath the path of the file to be saved
     */
    @Override
    public void writeFile(Map<String, Integer> metrics, String filepath) {
        File outputFile = new File(filepath + ".csv");
        StringBuilder metricsNames = new StringBuilder();
        StringBuilder metricsValues = new StringBuilder();

        for (Map.Entry<String, Integer> entry : metrics.entrySet()) {
            metricsNames.append(entry.getKey() + ",");
            metricsValues.append(entry.getValue()+",");
        }

        try {
            FileWriter writer = new FileWriter(outputFile);
            writer.append(metricsNames + "\n");
            writer.append(metricsValues + "\n");
            writer.close();
            System.out.println("Metrics saved in " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
