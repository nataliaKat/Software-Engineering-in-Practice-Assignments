package sourcecodeanalyzers;

import java.util.List;

/**
 * Calculates metrics according to the StringComparisonType.
 *
 * @author Natalia Katsiapi
 */
public class StringComparisonType implements AnalyzerType {

    /**
     * The source code to be examined as list.
     */
    private List<String> sourceCode;

    public StringComparisonType(List<String> sourceCode) {
        this.sourceCode = sourceCode;
    }

    /**
     * Counts lines of code excluding comments or plain { or }.
     * @return lines of code
     */
    @Override
    public int calculateLOC() {
        int nonCodeLinesCounter = 0;
        for (String line : sourceCode) {
            line = line.trim(); //clear all leading and trailing white spaces
            if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{") || line.equals("}") || line.equals(""))
                nonCodeLinesCounter++;
        }
        int loc = sourceCode.size() - nonCodeLinesCounter;
        return loc;
    }

    /**
     * Counts number of methods.
     * @return number of methods
     */
    @Override
    public int calculateNOM() {
        int methodCounter = 0;
        for (String line : sourceCode) {
            line = line.trim(); //clear all leading and trailing white spaces
            if ( ((line.contains("public") || line.contains("private") || line.contains("protected"))
                    || line.contains("void") || line.contains("int") || line.contains("String"))
                    && line.contains("(") && line.contains(")") && line.contains("{") )
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
        int classCounter = 0;
        for (String line : sourceCode) {
            line = line.trim(); //remove leading and trailing white spaces
            if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
                classCounter++;
            }
        }
        return classCounter;     }
}
