package facades;

import sourcecodeanalyzers.SourceCodeAnalyzerFactory;
import sourcecodeanalyzers.SourceCodeCalculator;
import sourcefilereaders.SourceFileReadMethod;
import sourcefilereaders.SourceFileReaderFactory;

import java.io.IOException;
import java.util.List;

/**
 * Reads the file and calculates a specific metric.
 *
 * @author Natalia Katsiapi
 */
public class ReadAndAnalyzeFacade {

    /**
     * Read the file into a list or string, based on whether the analyzer type is regex or string comparison.
     * Then, the metric is calculated.
     * @param filepath the path of the source code file
     * @param sourceCodeAnalyzerType either 'regex' or 'strcomp'
     * @param sourceFileLocation either 'web' or 'local'
     * @param metric either 'noc' or 'nom' or 'loc'
     * @return the calculated metric
     * @throws IOException
     */
    public int getMetric(String filepath, String sourceCodeAnalyzerType, String sourceFileLocation, String metric) throws IOException {
        SourceCodeAnalyzerFactory sourceCodeAnalyzerFactory = new SourceCodeAnalyzerFactory();
        SourceFileReaderFactory sourceFileReaderFactory =  new SourceFileReaderFactory();
        SourceCodeCalculator calculator;
        SourceFileReadMethod sourceFileReadMethod;
        switch (sourceCodeAnalyzerType) {
            case "regex":
                sourceFileReadMethod = sourceFileReaderFactory.create("string", sourceFileLocation, filepath);
                String codeAsString = sourceFileReadMethod.readFile();
                calculator = sourceCodeAnalyzerFactory.create(metric, sourceCodeAnalyzerType, codeAsString);
                break;
            case "strcomp":
                sourceFileReadMethod = sourceFileReaderFactory.create("list", sourceFileLocation, filepath);
                List<String> codeAsList = sourceFileReadMethod.readFile();
                calculator = sourceCodeAnalyzerFactory.create(metric, sourceCodeAnalyzerType, codeAsList);
                break;
            default:
                calculator = sourceCodeAnalyzerFactory.create(metric, sourceCodeAnalyzerType, null);
                break;
        }
        return calculator.calculate();
    }

}
