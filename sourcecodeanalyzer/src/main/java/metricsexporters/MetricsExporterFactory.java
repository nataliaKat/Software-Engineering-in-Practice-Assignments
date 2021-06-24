package metricsexporters;

/**
 * Creates a MetricsExporter object.
 * It hides the object creation logic from the client.
 *
 * @author Natalia Katsiapi
 */
public class MetricsExporterFactory {

    /**
     * Creates the object based on the given string.
     * @param outputType the object type to be created. Possible types: 'csv' and 'json'.
     * @return an object of the corresponding class and NullExporter for unknown types.
     */
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
