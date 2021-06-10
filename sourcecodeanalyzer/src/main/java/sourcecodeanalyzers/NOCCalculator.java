package sourcecodeanalyzers;

public class NOCCalculator extends SourceCodeCalculator {
    public NOCCalculator(AnalyzerType analyzerType) {
        super(analyzerType);
    }

    @Override
    public int calculate() {
        return analyzerType.calculateNOC();
    }
}
