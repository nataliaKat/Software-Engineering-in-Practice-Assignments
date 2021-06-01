package metricsexporters;

import java.util.Map;

/**
 * For the unknown file types.
 *
 * @author Natalia Katsiapi
 */
public class NullExporter implements MetricsExporter {

    /**
     * Throws an exception for unknown file type.
     * @param metrics a Map with the metric name as key and metric value as value
     * @param filepath the path of the file to be saved
     */
    @Override
    public void writeFile(Map<String, Integer> metrics, String filepath) {
        throw new IllegalArgumentException("Unknown file type");
    }
}
