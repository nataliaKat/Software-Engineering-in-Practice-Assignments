package sourcecodeanalyzers;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.*;

public class StringComparisonTypeTest {

    private final static String TEST_CLASS = "src/test/resources/TestClass.java";
    private StringComparisonType stringComparisonType = new StringComparisonType(codeAsList);
    private static List<String> codeAsList;

    @BeforeClass
    public static void setUp() throws IOException {
        codeAsList = Files.readAllLines(new File(TEST_CLASS).toPath(), Charset.defaultCharset());
    }

    @Test
    public void testCalculateLOC() {
        assertEquals(7, stringComparisonType.calculateLOC());
    }

    @Test
    public void testCalculateNOM() {
        assertEquals(3, stringComparisonType.calculateNOM());
    }

    @Test
    public void testCalculateNOC() {
        assertEquals(3, stringComparisonType.calculateNOC());
    }
}