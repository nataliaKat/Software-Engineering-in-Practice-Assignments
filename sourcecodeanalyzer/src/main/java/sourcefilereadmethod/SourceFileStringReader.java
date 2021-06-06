package sourcefilereadmethod;

import sourcefilelocation.SourceFileLocation;

import java.io.IOException;

public class SourceFileStringReader extends SourceFileReadMethod {
    public SourceFileStringReader(SourceFileLocation sourceFileLocation, String filePath) {
        super(sourceFileLocation, filePath);
    }

    @Override
    public void readFile() throws IOException {
        sourceFileLocation.readFileIntoString(filePath);
    }
}
