package sourcecodeanalyzers;

import java.util.List;

/**
 * Creates an object of <code>SourceCodeCalculator</code> class
 *
 * @author Natalia Katsiapi
 */
public class SourceCodeAnalyzerFactory {

    /**
     * Get SourceCodeCalculator according to the type of metric and analyzing type given.
     * @param calculator either 'loc' or 'noc' or 'nom'
     * @param type either 'regex' or 'strcomp'
     * @param sourceCode the source code as a list or string.
     * @return SourceCodeCalculator object
     */
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

    /**
     * Get AnalyzerType according to given String. Regex needs source code as a list,
     * while string comparison as a string.
     * @param type either 'regex' or 'strcomp'
     * @param sourceCode the source code as a list or string.
     * @return AnalyzerType object
     */
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
