package sourcecodeanalyzers;

public class NOMCalculator extends SourceCodeCalculator {
    public NOMCalculator(AnalyzerType analyzerType) {
        super(analyzerType);
    }

    @Override
    public int calculate() {
        return analyzerType.calculateNOM();
    }
}
