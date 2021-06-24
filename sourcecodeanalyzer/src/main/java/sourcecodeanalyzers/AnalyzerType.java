package sourcecodeanalyzers;

/**
 * The code analysis types.
 *
 * @author Natalia Katsiapi
 */
public interface AnalyzerType {

    int calculateLOC();
    int calculateNOM();
    int calculateNOC();

}
