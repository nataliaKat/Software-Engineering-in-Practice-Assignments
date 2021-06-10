package sourcecodeanalyzers;

import java.util.List;

public class SourceCodeAnalyzerFactory {

    public SourceCodeCalculator create(String calculator, String type, Object sourceCode) {
        SourceCodeCalculator sourceCodeCalculator;
        AnalyzerType analyzerType = getType(type, sourceCode);

        switch (calculator) {
            case "loc":
                sourceCodeCalculator = new LOCCalculator(analyzerType);
                break;
            case "noc":
                sourceCodeCalculator = new NOCCalculator(analyzerType);
                break;
            case "nom":
                sourceCodeCalculator = new NOMCalculator(analyzerType);
                break;
            default:
                sourceCodeCalculator = new NullCalculator(analyzerType);
                break;
        }

        return sourceCodeCalculator;
    }

    private AnalyzerType getType(String type, Object sourceCode) {
        AnalyzerType analyzerType;
        switch (type) {
            case "regex":
                analyzerType = new RegexType((String)sourceCode);
                break;
            case "strcomp":
                analyzerType = new StringComparisonType((List<String>)sourceCode);
                break;
            default:
                analyzerType = new NullType();
                break;
        }
        return analyzerType;
    }
}
