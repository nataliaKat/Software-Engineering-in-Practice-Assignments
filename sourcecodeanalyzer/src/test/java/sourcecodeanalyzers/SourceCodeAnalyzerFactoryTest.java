package sourcecodeanalyzers;

import org.junit.Test;
import sourcefilereaders.LocalLocation;
import sourcefilereaders.SourceFileListReader;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SourceCodeAnalyzerFactoryTest {

    private SourceCodeAnalyzerFactory sourceCodeAnalyzerFactory = new SourceCodeAnalyzerFactory();
    private SourceCodeCalculator sourceCodeCalculator;
    private static String SOURCE_CODE_AS_STRING = "source code goes here";
    private static List<String> SOURCE_CODE_AS_LIST =
            Arrays.asList(new String[]{"line1", "line2", "line3"});

    @Test
    public void testCreateRegexLOC() {
        sourceCodeCalculator = sourceCodeAnalyzerFactory.create("loc", "regex", SOURCE_CODE_AS_STRING);
        assertTrue(sourceCodeCalculator instanceof LOCCalculator);
        assertTrue(sourceCodeCalculator.getAnalyzerType() instanceof RegexType);
    }

    @Test
    public void testCreateRegexNOC() {
        sourceCodeCalculator = sourceCodeAnalyzerFactory.create("noc", "regex", SOURCE_CODE_AS_STRING);
        assertTrue(sourceCodeCalculator instanceof NOCCalculator);
        assertTrue(sourceCodeCalculator.getAnalyzerType() instanceof RegexType);
    }

    @Test
    public void testCreateRegexNOM() {
        sourceCodeCalculator = sourceCodeAnalyzerFactory.create("nom", "regex", SOURCE_CODE_AS_STRING);
        assertTrue(sourceCodeCalculator instanceof NOMCalculator);
        assertTrue(sourceCodeCalculator.getAnalyzerType() instanceof RegexType);
    }

    @Test
    public void testCreateStrCompLOC() {
        sourceCodeCalculator = sourceCodeAnalyzerFactory.create("loc", "strcomp", SOURCE_CODE_AS_LIST);
        assertTrue(sourceCodeCalculator instanceof LOCCalculator);
        assertTrue(sourceCodeCalculator.getAnalyzerType() instanceof StringComparisonType);
    }

    @Test
    public void testCreateStrCompNOC() {
        sourceCodeCalculator = sourceCodeAnalyzerFactory.create("noc", "strcomp", SOURCE_CODE_AS_LIST);
        assertTrue(sourceCodeCalculator instanceof NOCCalculator);
        assertTrue(sourceCodeCalculator.getAnalyzerType() instanceof StringComparisonType);
    }

    @Test
    public void testCreateStrCompNOM() {
        sourceCodeCalculator = sourceCodeAnalyzerFactory.create("nom", "strcomp", SOURCE_CODE_AS_LIST);
        assertTrue(sourceCodeCalculator instanceof NOMCalculator);
        assertTrue(sourceCodeCalculator.getAnalyzerType() instanceof StringComparisonType);
    }

    @Test
    public void testUnknownCalculator() {
        sourceCodeCalculator = sourceCodeAnalyzerFactory.create("unknown", "strcomp", SOURCE_CODE_AS_LIST);
        assertTrue(sourceCodeCalculator instanceof NullCalculator);
        assertTrue(sourceCodeCalculator.getAnalyzerType() instanceof StringComparisonType);
    }

    @Test
    public void testUnknownType() {
        sourceCodeCalculator = sourceCodeAnalyzerFactory.create("loc", "new-type", SOURCE_CODE_AS_LIST);
        assertTrue(sourceCodeCalculator instanceof LOCCalculator);
        assertTrue(sourceCodeCalculator.getAnalyzerType() instanceof NullType);
    }

    @Test
    public void testUnknownTypeAndCalculator() {
        sourceCodeCalculator = sourceCodeAnalyzerFactory.create("unknown", "unknown", SOURCE_CODE_AS_LIST);
        assertTrue(sourceCodeCalculator instanceof NullCalculator);
        assertTrue(sourceCodeCalculator.getAnalyzerType() instanceof NullType);
    }

}