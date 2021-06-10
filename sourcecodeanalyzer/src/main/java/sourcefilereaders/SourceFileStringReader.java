package sourcefilereaders;


import java.io.IOException;
import java.util.List;

public class SourceFileStringReader extends SourceFileReadMethod {
    public SourceFileStringReader(SourceFileLocation sourceFileLocation, String filePath) {
        super(sourceFileLocation, filePath);
    }

    @Override
    public String readFile() throws IOException {
        return sourceFileLocation.readFileIntoString(filePath);
    }
}
