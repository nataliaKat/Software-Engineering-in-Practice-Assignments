package sourcecodeanalyzers;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RegexTypeTest {

    private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
    private RegexType regexType = new RegexType(codeAsString);
    private static String codeAsString;

    @BeforeClass
    public static void setUp() throws IOException {
        List<String> codeAsList = Files.readAllLines(new File(TEST_CLASS_LOCAL).toPath(), Charset.defaultCharset());
        codeAsString = String.join("\n", codeAsList) + "\n"; // transforms a list into a String (with 'new line' as delimiter)
    }

    @Test
    public void testCalculateLOC() {
        assertEquals(21, regexType.calculateLOC());
    }

    @Test
    public void testCalculateNOM() {
        assertEquals(3, regexType.calculateNOM());
    }

    @Test
    public void testCalculateNOC() {
        assertEquals(3, regexType.calculateNOC());
    }

}