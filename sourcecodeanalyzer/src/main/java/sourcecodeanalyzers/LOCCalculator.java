package sourcecodeanalyzers;

public class LOCCalculator extends SourceCodeCalculator {

    public LOCCalculator(AnalyzerType analyzerType) {
        super(analyzerType);
    }

    @Override
    public int calculate() {
        return analyzerType.calculateLOC();
    }
}
