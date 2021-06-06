package sourcefilereadmethod;

import sourcefilelocation.SourceFileLocation;

import java.io.IOException;

public class SourceFileListReader extends SourceFileReadMethod {

    public SourceFileListReader(SourceFileLocation sourceFileLocation, String filePath) {
        super(sourceFileLocation, filePath);
    }

    @Override
    public void readFile() throws IOException {
        sourceFileLocation.readFileIntoList(filePath);
    }
}
