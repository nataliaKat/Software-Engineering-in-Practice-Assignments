package sourcecodeanalyzers;

/**
 * For the unknown analyzing types.
 *
 * @author Natalia Katsiapi
 */
public class NullType implements AnalyzerType{

    /**
     * Throws an exception for unknown analyzing type.
     */
    @Override
    public int calculateLOC() {
        throw new IllegalArgumentException("Unknown analyzing type. Could not calculate LOC.");
    }

    /**
     * Throws an exception for unknown analyzing type.
     */
    @Override
    public int calculateNOM() {
        throw new IllegalArgumentException("Unknown analyzing type. Could not calculate NOM.");
    }

    /**
     * Throws an exception for unknown analyzing type.
     */
    @Override
    public int calculateNOC() {
        throw new IllegalArgumentException("Unknown analyzing type. Could not calculate NOC.");
    }

}
