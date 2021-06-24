package sourcecodeanalyzers;

/**
 * For the unknown metrics.
 *
 * @author Natalia Katsiapi
 */
public class NullCalculator extends SourceCodeCalculator{
    public NullCalculator(AnalyzerType analyzerType) {
        super(analyzerType);
    }

    /**
     * Throws an exception for unknown metric.
     */
    @Override
    public int calculate() {
        throw new IllegalArgumentException("Unknown metric.");
    }
}
