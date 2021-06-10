package sourcecodeanalyzers;

public abstract class SourceCodeCalculator {

    protected AnalyzerType analyzerType;

    public AnalyzerType getAnalyzerType() {
        return analyzerType;
    }

    public SourceCodeCalculator(AnalyzerType analyzerType) {
        this.analyzerType = analyzerType;
    }

    public abstract int calculate();

}
