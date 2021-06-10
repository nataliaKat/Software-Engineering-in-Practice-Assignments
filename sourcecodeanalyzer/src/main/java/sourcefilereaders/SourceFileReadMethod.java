package sourcefilereaders;

import java.io.IOException;
import java.util.List;

public abstract class SourceFileReadMethod {
    protected SourceFileLocation sourceFileLocation;
    protected String filePath;

    public SourceFileReadMethod(SourceFileLocation sourceFileLocation, String filePath) {
        this.sourceFileLocation = sourceFileLocation;
        this.filePath = filePath;
    }

    public SourceFileLocation getSourceFileLocation() {
        return sourceFileLocation;
    }

    public abstract <T> T readFile() throws IOException;
}
