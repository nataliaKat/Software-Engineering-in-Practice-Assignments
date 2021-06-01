package metricsexporters;

/**
 * Creates a MetricsExporter object.
 * It hides the object creation logic from the client.
 *
 * @author Natalia Katsiapi
 */
public class MetricsExporterFactory {

    public MetricsExporter createFileWriter(String outputType) {
        MetricsExporter writer;

        if (outputType.equals("csv")) {
            writer = new CsvExporter();
        } else if (outputType.equals("json")) {
            writer = new JsonExporter();
        } else {
            writer = new NullExporter();
        }
        return writer;
    }
}
