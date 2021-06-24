package sourcefilereaders;

import java.io.IOException;
import java.util.List;

/**
 * Reads the file in a List according to its location.
 *
 * @author Natalia Katsiapi
 */
public class SourceFileListReader extends SourceFileReadMethod {

    public SourceFileListReader(SourceFileLocation sourceFileLocation, String filePath) {
        super(sourceFileLocation, filePath);
    }

    /**
     * Calls the appropriate method of the SourceFileLocation object.
     * @return a List with the lines of file
     * @throws IOException
     */
    @Override
    public List<String> readFile() throws IOException {
        return sourceFileLocation.readFileIntoList(filePath);
    }
}
