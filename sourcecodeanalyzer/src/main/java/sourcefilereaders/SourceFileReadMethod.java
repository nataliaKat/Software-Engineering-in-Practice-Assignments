package sourcefilereaders;

import java.io.IOException;

/**
 * An abstraction of the different reading methods.
 *
 * @author Natalia Katsiapi
 */
public abstract class SourceFileReadMethod {

    /**
     * The location of the file.
     */
    protected SourceFileLocation sourceFileLocation;

    /**
     * The path to the file.
     */
    protected String filePath;

    public SourceFileReadMethod(SourceFileLocation sourceFileLocation, String filePath) {
        this.sourceFileLocation = sourceFileLocation;
        this.filePath = filePath;
    }

    public SourceFileLocation getSourceFileLocation() {
        return sourceFileLocation;
    }

    /**
     * Specifies which method to call from SourceFileLocation.
     * @param <T> the type into witch the file will be read e.g. String.
     * @return the read source file
     * @throws IOException
     */
    public abstract <T> T readFile() throws IOException;
}
