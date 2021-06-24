package sourcecodeanalyzers;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

public class NullCalculatorTest {

    private NullCalculator calculator;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCalculateRegex() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Unknown metric.");

        calculator = new NullCalculator(new RegexType("source code"));
        calculator.calculate();
    }

    @Test
    public void testCalculateStrComp() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Unknown metric.");

        calculator = new NullCalculator(new StringComparisonType(Arrays.asList(new String[] {"line 1", "line 2", "lin 3"})));
        calculator.calculate();
    }

}