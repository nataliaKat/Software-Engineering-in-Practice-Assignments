package sourcefilereaders;

import java.io.IOException;
import java.util.List;

public class SourceFileListReader extends SourceFileReadMethod {

    public SourceFileListReader(SourceFileLocation sourceFileLocation, String filePath) {
        super(sourceFileLocation, filePath);
    }

    @Override
    public List<String> readFile() throws IOException {
        List<String> res = sourceFileLocation.readFileIntoList(filePath);
        return res;
    }
}
