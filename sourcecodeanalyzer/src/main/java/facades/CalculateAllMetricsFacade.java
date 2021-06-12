package facades;

import metricsexporters.MetricsExporter;
import metricsexporters.MetricsExporterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Contains all client logic in order to calculate all metrics.
 *
 * @author Natalia Katsiapi
 */
public class CalculateAllMetricsFacade {

    /**
     * Calls all methods in order to calculate metrics.
     * @param filepath the path of the file with code
     * @param sourceCodeAnalyzerType can be either 'regex' or 'strcomp'
     * @param sourceFileLocation can be either 'local' or 'web'
     * @param outputFilePath the path of the file with the results
     * @param outputFileType can be either 'csv' or 'json'
     */
    public void calculateAllMetrics(String filepath, String sourceCodeAnalyzerType, String sourceFileLocation, String outputFilePath, String outputFileType) {
        ReadAndAnalyzeFacade readAndAnalyzeFacade = new ReadAndAnalyzeFacade();
        String[] metricNames = {"loc", "nom", "noc"};
        Map<String, Integer> metrics = new HashMap<>();

        try {
            for (String metric : metricNames) {
                int result = readAndAnalyzeFacade.getMetric(filepath, sourceCodeAnalyzerType,
                        sourceFileLocation, metric);
                metrics.put(metric, result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        MetricsExporterFactory exporterFactory = new MetricsExporterFactory();
        MetricsExporter metricsExporter = exporterFactory.createFileWriter(outputFileType);
        metricsExporter.writeFile(metrics, outputFilePath);
    }

}
