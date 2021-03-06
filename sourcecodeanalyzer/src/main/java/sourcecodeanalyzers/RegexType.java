package sourcecodeanalyzers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Calculates metrics according to the RegexType.
 *
 * @author Natalia Katsiapi
 */
public class RegexType implements AnalyzerType {

    /**
     * The source code to be examined as string.
     */
    private String sourceCode;

    public RegexType(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    /**
     * Counts lines of code including comments.
     * @return lines of code
     */
    @Override
    public int calculateLOC() {
        Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
        Matcher nonCodeLinesMatcher = pattern.matcher(sourceCode);

        int nonCodeLinesCounter = 0;
        while (nonCodeLinesMatcher.find()) {
            nonCodeLinesCounter++;
        }

        int sourceFileLength = sourceCode.split("\n").length;
        int loc =  sourceFileLength - nonCodeLinesCounter;

        return loc;
    }

    /**
     * Counts number of methods.
     * @return number of methods
     */
    @Override
    public int calculateNOM() {
        Pattern pattern = Pattern.compile(".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*");
        Matcher methodSignatures = pattern.matcher(sourceCode);

        int methodCounter = 0;
        while (methodSignatures.find()) {
            methodCounter++;
        }
        return methodCounter;
    }

    /**
     * Counts number of classes.
     * @return number of classes
     */
    @Override
    public int calculateNOC() {
        Pattern pattern = Pattern.compile(".*\\s*class\\s+.*");
        Matcher classSignatures = pattern.matcher(sourceCode);

        int classCounter = 0;
        while (classSignatures.find()) {
            classCounter++;
        }
        return classCounter;
    }
}
