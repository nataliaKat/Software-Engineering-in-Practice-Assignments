package sourcecodeanalyzers;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NOCCalculatorTest {

    @Test
    public void testCalculateRegex() {
        RegexType regexType = mock(RegexType.class);
        NOCCalculator calculator = new NOCCalculator(regexType);
        when(regexType.calculateNOC()).thenReturn(17);

        assertEquals(17, calculator.calculate());
    }

    @Test
    public void testCalculateStrComp() {
        StringComparisonType stringComparisonType = mock(StringComparisonType.class);
        NOCCalculator calculator = new NOCCalculator(stringComparisonType);
        when(stringComparisonType.calculateNOC()).thenReturn(8);

        assertEquals(8, calculator.calculate());
    }

}