package sourcefilereaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads a local file as a string or list.
 *
 * @author Natalia Katsiapi
 */
public class LocalLocation implements SourceFileLocation {

    /**
     * Reads the file's lines into a List.
     * @param filepath the path of thw local file
     * @return a List of the file lines as strings
     * @throws IOException
     */
    @Override
    public List<String> readFileIntoList(String filepath) throws IOException {
        List<String> lines = new ArrayList();
        File file = new File(filepath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    /**
     * Reads the file as a String.
     * @param filepath the path of thw local file
     * @return a string containing the file
     * @throws IOException
     */
    @Override
    public String readFileIntoString(String filepath) throws IOException {
        StringBuilder sb = new StringBuilder();
        File file = new File(filepath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        reader.close();
        return sb.toString();
    }
}
