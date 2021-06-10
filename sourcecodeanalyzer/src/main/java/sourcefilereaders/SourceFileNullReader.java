package sourcefilereaders;

import java.io.IOException;

/**
 * For the unknown read methods.
 *
 * @author Natalia Katsiapi
 */
public class SourceFileNullReader extends SourceFileReadMethod {

    public SourceFileNullReader(SourceFileLocation sourceFileLocation, String filePath) {
        super(sourceFileLocation, filePath);
    }

    /**
     * Throws an exception for unknown read method.
     */
    @Override
    public <T> T readFile() {
        throw new IllegalArgumentException("Unknown read method.");
    }
}
