package sourcefilereaders;

public class SourceFileReaderFactory {

    public SourceFileReadMethod create(String method, String location, String filepath) {
        SourceFileReadMethod sourceFileReadMethod;
        SourceFileLocation sourceFileLocation = getLocation(location);

        switch (method) {
            case "list":
                sourceFileReadMethod = new SourceFileListReader(sourceFileLocation, filepath);
                break;
            case "string":
                sourceFileReadMethod = new SourceFileStringReader(sourceFileLocation, filepath);
                break;
            default:
                sourceFileReadMethod = new SourceFileNullReader(sourceFileLocation, filepath);
                break;
        }

        return sourceFileReadMethod;
    }

    private SourceFileLocation getLocation(String location) {
        SourceFileLocation sourceFileLocation;
        switch (location) {
            case "web":
                sourceFileLocation = new WebLocation();
                break;
            case "local":
                sourceFileLocation = new LocalLocation();
                break;
            default:
                sourceFileLocation = new NullLocation();
                break;
        }
        return sourceFileLocation;
    }


}
