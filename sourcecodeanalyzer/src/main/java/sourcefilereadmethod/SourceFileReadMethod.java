package sourcefilereadmethod;

import sourcefilelocation.SourceFileLocation;

import java.io.IOException;

public abstract class SourceFileReadMethod {
    protected SourceFileLocation sourceFileLocation;
    protected String filePath;

    public SourceFileReadMethod(SourceFileLocation sourceFileLocation, String filePath) {
        this.sourceFileLocation = sourceFileLocation;
        this.filePath = filePath;
    }

    public abstract void readFile() throws IOException;
}
