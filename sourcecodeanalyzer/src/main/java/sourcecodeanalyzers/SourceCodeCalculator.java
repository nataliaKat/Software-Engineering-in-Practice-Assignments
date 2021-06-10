package sourcecodeanalyzers;

import sourcefilereaders.SourceFileReadMethod;

public abstract class SourceCodeCalculator {

    protected AnalyzerType analyzerType;

    public SourceCodeCalculator(AnalyzerType analyzerType) {
        this.analyzerType = analyzerType;
    }

    public abstract int calculate();

}
