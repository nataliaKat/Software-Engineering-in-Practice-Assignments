package metricsexporters;

import java.util.Map;

/**
 * Exports (writes) the metrics to a given output.
 * The output can be CSV or JSON files.
 * Part of strategy design pattern.
 *
 * @author Natalia Katsiapi
 */
public interface MetricsExporter {

    /**
     * Creates a file with the given metrics
     * @param metrics a Map with the metric name as key and metric value as value
     * @param filepath the path of the file to be saved
     */
    void writeFile(Map<String, Integer> metrics, String filepath);

}
