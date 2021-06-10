package sourcefilereaders;

import org.junit.Test;
import static org.junit.Assert.*;

public class SourceFileReaderFactoryTest {

    SourceFileReaderFactory sourceFileReaderFactory = new SourceFileReaderFactory();

    SourceFileReadMethod sourceFileReadMethod;

    @Test
    public void testLocalList() {
        sourceFileReadMethod = sourceFileReaderFactory.create("list", "local", "somefilepath");
        assertTrue(sourceFileReadMethod instanceof SourceFileListReader);
        assertTrue(sourceFileReadMethod.getSourceFileLocation() instanceof LocalLocation);
    }

    @Test
    public void testLocalString() {
        sourceFileReadMethod = sourceFileReaderFactory.create("string", "local", "somefilepath");
        assertTrue(sourceFileReadMethod instanceof SourceFileStringReader);
        assertTrue(sourceFileReadMethod.getSourceFileLocation() instanceof LocalLocation);
    }

    @Test
    public void testWebList() {
        sourceFileReadMethod = sourceFileReaderFactory.create("list", "web", "somefilepath");
        assertTrue(sourceFileReadMethod instanceof SourceFileListReader);
        assertTrue(sourceFileReadMethod.getSourceFileLocation() instanceof WebLocation);
    }

    @Test
    public void testWebString() {
        sourceFileReadMethod = sourceFileReaderFactory.create("string", "web", "somefilepath");
        assertTrue(sourceFileReadMethod instanceof SourceFileStringReader);
        assertTrue(sourceFileReadMethod.getSourceFileLocation() instanceof WebLocation);
    }

    @Test
    public void testUnknownLocation() {
        sourceFileReadMethod = sourceFileReaderFactory.create("string", "web2", "somefilepath");
        assertTrue(sourceFileReadMethod instanceof SourceFileStringReader);
        assertTrue(sourceFileReadMethod.getSourceFileLocation() instanceof NullLocation);
    }

    @Test
    public void testUnknownMethod() {
        sourceFileReadMethod = sourceFileReaderFactory.create("t23gr4jhg43", "web", "somefilepath");
        assertTrue(sourceFileReadMethod instanceof SourceFileNullReader);
        assertTrue(sourceFileReadMethod.getSourceFileLocation() instanceof WebLocation);
    }

}