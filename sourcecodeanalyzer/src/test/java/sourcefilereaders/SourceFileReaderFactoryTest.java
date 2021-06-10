package sourcefilereaders;

import org.junit.Test;
import static org.junit.Assert.*;

public class SourceFileReaderFactoryTest {

    SourceFileReaderFactory sourceFileReaderFactory = new SourceFileReaderFactory();
    SourceFileReadMethod sourceFileReadMethod;
    private final static String FILEPATH = "somefilepath";

    @Test
    public void testCreateLocalList() {
        sourceFileReadMethod = sourceFileReaderFactory.create("list", "local", FILEPATH);
        assertTrue(sourceFileReadMethod instanceof SourceFileListReader);
        assertTrue(sourceFileReadMethod.getSourceFileLocation() instanceof LocalLocation);
    }

    @Test
    public void testCreateLocalString() {
        sourceFileReadMethod = sourceFileReaderFactory.create("string", "local", FILEPATH);
        assertTrue(sourceFileReadMethod instanceof SourceFileStringReader);
        assertTrue(sourceFileReadMethod.getSourceFileLocation() instanceof LocalLocation);
    }

    @Test
    public void testCreateWebList() {
        sourceFileReadMethod = sourceFileReaderFactory.create("list", "web", FILEPATH);
        assertTrue(sourceFileReadMethod instanceof SourceFileListReader);
        assertTrue(sourceFileReadMethod.getSourceFileLocation() instanceof WebLocation);
    }

    @Test
    public void testCreateWebString() {
        sourceFileReadMethod = sourceFileReaderFactory.create("string", "web", FILEPATH);
        assertTrue(sourceFileReadMethod instanceof SourceFileStringReader);
        assertTrue(sourceFileReadMethod.getSourceFileLocation() instanceof WebLocation);
    }

    @Test
    public void testCreateUnknownLocation() {
        sourceFileReadMethod = sourceFileReaderFactory.create("string", "web2", FILEPATH);
        assertTrue(sourceFileReadMethod instanceof SourceFileStringReader);
        assertTrue(sourceFileReadMethod.getSourceFileLocation() instanceof NullLocation);
    }

    @Test
    public void testCreateUnknownMethod() {
        sourceFileReadMethod = sourceFileReaderFactory.create("t23gr4jhg43", "web", FILEPATH);
        assertTrue(sourceFileReadMethod instanceof SourceFileNullReader);
        assertTrue(sourceFileReadMethod.getSourceFileLocation() instanceof WebLocation);
    }

    @Test
    public void testUnknownLocationAndMethod() {
        sourceFileReadMethod = sourceFileReaderFactory.create("unknown", "unknown", FILEPATH);
        assertTrue(sourceFileReadMethod instanceof SourceFileNullReader);
        assertTrue(sourceFileReadMethod.getSourceFileLocation() instanceof NullLocation);
    }

}