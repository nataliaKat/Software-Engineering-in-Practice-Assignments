package facades;

import metricsexporters.MetricsExporter;
import metricsexporters.MetricsExporterFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateAllMetricsFacade {

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
