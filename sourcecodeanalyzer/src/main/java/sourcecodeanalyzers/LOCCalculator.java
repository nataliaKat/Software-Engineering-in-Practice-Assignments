package sourcecodeanalyzers;

/**
 * Calculates file's lines of code.
 *
 * @author Natalia Katsiapi
 */
public class LOCCalculator extends SourceCodeCalculator {

    public LOCCalculator(AnalyzerType analyzerType) {
        super(analyzerType);
    }

    /**
     * Calculate lines of code using the appropriate AnalyzerType.
     * @return the calculated metric
     */
    @Override
    public int calculate() {
        return analyzerType.calculateLOC();
    }
}
