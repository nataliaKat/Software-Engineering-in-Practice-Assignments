package sourcefilereaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads a web file as a string or list.
 *
 * @author Natalia Katsiapi
 */
public class WebLocation implements SourceFileLocation {

    /**
     * Reads the file's lines into a List.
     * @param filepath the path of thw web file
     * @return a List of the file lines as strings
     * @throws IOException
     */
    @Override
    public List<String> readFileIntoList(String filepath) throws IOException {
        List<String> lines = new ArrayList<>();
        URL url = new URL(filepath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    /**
     * Reads the file as a String.
     * @param filepath the path of thw web file
     * @return a string containing the file
     * @throws IOException
     */
    @Override
    public String readFileIntoString(String filepath) throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(filepath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        reader.close();
        return sb.toString();
    }

}
