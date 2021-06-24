package sourcefilereaders;

import java.io.IOException;
import java.util.List;

/**
 * For the unknown file types.
 *
 * @author Natalia Katsiapi
 */
public class NullLocation implements SourceFileLocation {

    /**
     * Throws an exception for unknown file location.
     * @param filepath the path of the file to be saved
     */
    @Override
    public List<String> readFileIntoList(String filepath) throws IOException {
        throw new IllegalArgumentException("Unknown file location. Could not read into List.");
    }

    /**
     * Throws an exception for unknown file location.
     * @param filepath the path of the file to be saved
     */
    @Override
    public String readFileIntoString(String filepath) throws IOException {
        throw new IllegalArgumentException("Unknown file location. Could not read into String.");
    }
}
