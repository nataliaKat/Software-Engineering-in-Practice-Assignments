package sourcecodeanalyzers;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NOMCalculatorTest {

    @Test
    public void testCalculateRegex() {
        RegexType regexType = mock(RegexType.class);
        NOMCalculator calculator = new NOMCalculator(regexType);
        when(regexType.calculateNOM()).thenReturn(17);

        assertEquals(17, calculator.calculate());
    }

    @Test
    public void testCalculateStrComp() {
        StringComparisonType stringComparisonType = mock(StringComparisonType.class);
        NOMCalculator calculator = new NOMCalculator(stringComparisonType);
        when(stringComparisonType.calculateNOM()).thenReturn(8);

        assertEquals(8, calculator.calculate());
    }


}