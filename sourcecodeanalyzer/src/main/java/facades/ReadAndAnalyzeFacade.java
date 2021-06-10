package facades;

import sourcecodeanalyzers.SourceCodeAnalyzerFactory;
import sourcecodeanalyzers.SourceCodeCalculator;
import sourcefilereaders.SourceFileReadMethod;
import sourcefilereaders.SourceFileReaderFactory;

import java.io.IOException;
import java.util.List;

public class ReadAndAnalyzeFacade {

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
