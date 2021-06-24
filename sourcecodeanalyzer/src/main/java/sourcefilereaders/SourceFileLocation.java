package sourcefilereaders;

import java.io.IOException;
import java.util.List;

/**
 * The read methods.
 *
 * @author Natalia Katsiapi
 */
public interface SourceFileLocation {

    List<String> readFileIntoList(String filepath) throws IOException;
    String readFileIntoString(String filepath) throws IOException;

}
