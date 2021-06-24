package sourcecodeanalyzers;

/**
 * Calculates file's number of methods.
 *
 * @author Natalia Katsiapi
 */
public class NOMCalculator extends SourceCodeCalculator {
    public NOMCalculator(AnalyzerType analyzerType) {
        super(analyzerType);
    }

    /**
     * Calculate number of methods using the appropriate AnalyzerType.
     * @return the calculated metric
     */
    @Override
    public int calculate() {
        return analyzerType.calculateNOM();
    }
}
