package sourcecodeanalyzers;

/**
 * An abstraction of the different metrics that exist.
 *
 * @author Natalia Katsiapi
 */
public abstract class SourceCodeCalculator {

    /**
     * The analyzer (method-way to calculate metrics).
     */
    protected AnalyzerType analyzerType;

    public AnalyzerType getAnalyzerType() {
        return analyzerType;
    }

    public SourceCodeCalculator(AnalyzerType analyzerType) {
        this.analyzerType = analyzerType;
    }

    /**
     * Specifies which method to call from AnalyzerTypes.
     * @return the calculated metric
     */
    public abstract int calculate();

}
