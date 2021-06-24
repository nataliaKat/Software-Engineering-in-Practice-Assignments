package facades;

import com.sun.org.apache.bcel.internal.classfile.Unknown;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import sourcecodeanalyzers.*;
import sourcefilereaders.LocalLocation;
import sourcefilereaders.SourceFileReadMethod;
import sourcefilereaders.SourceFileReaderFactory;
import sourcefilereaders.SourceFileStringReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReadAndAnalyzeFacadeTest {

    ReadAndAnalyzeFacade readAndAnalyzeFacade = new ReadAndAnalyzeFacade();

    @Test
    public void testGetMetricRegex() throws IOException {
        String location = "local";
        String filepath = "src/test/resources/TestClass.java";
        String metric = "noc";
        String type = "regex";
        String code = "code as string";
        SourceCodeCalculator sourceCodeCalculator = mock(SourceCodeCalculator.class);
        SourceCodeAnalyzerFactory sourceCodeAnalyzerFactory =  mock(SourceCodeAnalyzerFactory.class);
        SourceFileReaderFactory sourceFileReaderFactory = mock(SourceFileReaderFactory.class);
        SourceFileReadMethod sourceFileReadMethod = mock(SourceFileStringReader.class);
        when(sourceFileReaderFactory.create("string", location, filepath))
                .thenReturn(new SourceFileStringReader(new LocalLocation(), filepath));
        when(sourceFileReadMethod.readFile()).thenReturn(code);
        when(sourceCodeAnalyzerFactory.create(metric, type, code)).thenReturn(new NOCCalculator(new RegexType(code)));

        when(sourceCodeCalculator.calculate()).thenReturn(3);


        assertEquals(3, readAndAnalyzeFacade.getMetric(filepath, type, location, metric));
    }

    @Test
    public void testGetMetricStrComp() throws IOException {
        String location = "local";
        String filepath = "src/test/resources/TestClass.java";
        String metric = "noc";
        String type = "strcomp";
        List<String> code = Arrays.asList(new String[]{"line 1", "line 2", "line 3"});
        SourceCodeCalculator sourceCodeCalculator = mock(SourceCodeCalculator.class);
        SourceCodeAnalyzerFactory sourceCodeAnalyzerFactory =  mock(SourceCodeAnalyzerFactory.class);
        SourceFileReaderFactory sourceFileReaderFactory = mock(SourceFileReaderFactory.class);
        when(sourceCodeCalculator.calculate()).thenReturn(3);
        when(sourceFileReaderFactory.create("string", location, filepath))
                .thenReturn(new SourceFileStringReader(new LocalLocation(), filepath));
        when(sourceCodeAnalyzerFactory.create(metric, type, code)).thenReturn(new NOCCalculator(new StringComparisonType(code)));
        assertEquals(readAndAnalyzeFacade.getMetric(filepath, type, location, metric), 3);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testGetMetricDefault() throws IOException {
        String location = "location";
        String filepath = "filepath";
        String metric = "noc";
        String type = "anything";

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Unknown analyzing type. Could not calculate NOC.");

        readAndAnalyzeFacade.getMetric(filepath, type, location, metric);
    }



}