package metricsexporters;

import java.util.Map;

/**
 * Exports (writes) the metrics to a given JSON file.
 *
 * @author Natalia Katsiapi
 */
public class JsonExporter implements MetricsExporter {

    /**
     * Creates a JSON file with the given metrics. (Not yet implemented)
     * @param metrics a Map with the metric name as key and metric value as value
     * @param filepath the path of the file to be saved
     */
    @Override
    public void writeFile(Map<String, Integer> metrics, String filepath) {
        // Functionality not implemented yet
        // No need to implement it for the assignment
    }

}
