package metricsexporters;

import org.junit.Test;

import static org.junit.Assert.*;

public class MetricsExporterFactoryTest {

    MetricsExporterFactory exporterFactory = new MetricsExporterFactory();

    @Test
    public void testCreateFileWriterCsv() {
        assertTrue(exporterFactory.createFileWriter("csv") instanceof CsvExporter);
    }

    @Test
    public void testCreateFileWriterJson() {
        assertTrue(exporterFactory.createFileWriter("json") instanceof JsonExporter);
    }

    @Test
    public void testCreateFileWriterNull() {
        assertTrue(exporterFactory.createFileWriter("wauofwe fr") instanceof NullExporter);
    }

    @Test
    public void testCreateFileWriterEmpty() {
        assertTrue(exporterFactory.createFileWriter("") instanceof NullExporter);
    }
}
