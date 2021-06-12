package sourcefilereaders;

/**
 * Creates an object of <code>SourceFileReadMethod</code> class
 *
 * @author Natalia Katsiapi
 */
public class SourceFileReaderFactory {

    /**
     * Get SourceFileReadMethod based on the given method and location.
     * @param method either 'list' or 'string'
     * @param location either 'local' or 'web'
     * @param filepath the path of the file
     * @return
     */
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

    /**
     * Get SourceFileLocation based on the given string.
     * @param location either 'local' or 'web'
     * @return SourceFileLocation object
     */
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
