package sourcecodeanalyzers;

/**
 * Calculates file's number of classes.
 *
 * @author Natalia Katsiapi
 */
public class NOCCalculator extends SourceCodeCalculator {
    public NOCCalculator(AnalyzerType analyzerType) {
        super(analyzerType);
    }

    /**
     * Calculate number of classes using the appropriate AnalyzerType.
     * @return the calculated metric
     */
    @Override
    public int calculate() {
        return analyzerType.calculateNOC();
    }
}
