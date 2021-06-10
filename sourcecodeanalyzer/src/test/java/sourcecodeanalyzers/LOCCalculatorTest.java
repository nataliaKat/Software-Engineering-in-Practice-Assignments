package sourcecodeanalyzers;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LOCCalculatorTest {

    @Test
    public void testCalculateRegex() {
        RegexType regexType = mock(RegexType.class);
        LOCCalculator calculator = new LOCCalculator(regexType);
        when(regexType.calculateLOC()).thenReturn(17);

        assertEquals(17, calculator.calculate());
    }

    @Test
    public void testCalculateStrComp() {
        StringComparisonType stringComparisonType = mock(StringComparisonType.class);
        LOCCalculator calculator = new LOCCalculator(stringComparisonType);
        when(stringComparisonType.calculateLOC()).thenReturn(8);

        assertEquals(8, calculator.calculate());
    }

}