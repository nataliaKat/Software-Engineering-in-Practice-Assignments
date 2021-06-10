package sourcefilereaders;

import java.io.IOException;
import java.util.List;

/**
 *
 *
 */
public interface SourceFileLocation {

    List<String> readFileIntoList(String filepath) throws IOException;
    String readFileIntoString(String filepath) throws IOException;

}
