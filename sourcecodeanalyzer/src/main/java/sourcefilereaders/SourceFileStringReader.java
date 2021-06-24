package sourcefilereaders;

import java.io.IOException;

/**
 * Reads the file in a String according to its location.
 *
 * @author Natalia Katsiapi
 */
public class SourceFileStringReader extends SourceFileReadMethod {
    public SourceFileStringReader(SourceFileLocation sourceFileLocation, String filePath) {
        super(sourceFileLocation, filePath);
    }

    /**
     * Calls the appropriate method of the SourceFileLocation object.
     * @return a String with the lines of file
     * @throws IOException
     */
    @Override
    public String readFile() throws IOException {
        return sourceFileLocation.readFileIntoString(filePath);
    }
}
