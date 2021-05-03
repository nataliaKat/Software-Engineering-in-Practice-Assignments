package math;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * The ArithmeticOperationsTest provides testing methods for ArithmeticOperations.
 *
 * @author Natalia Katsiapi
 */
public class ArithmeticOperationsTest {

    ArithmeticOperations arithmeticOperations = new ArithmeticOperations();

    /**
     * Tests divide() with both numerator and denominator as doubles.
     */
    @Test
    public void testDivideDouble() {
        assertEquals(2.4427480916030534351145038167939,
                arithmeticOperations.divide(12.8, 5.24), 0.000000001);
    }

    /**
     * Tests divide() with both numerator as int and denominator as double.
     */
    @Test
    public void testDivideIntWithDouble() {
        assertEquals(6.5789473684210526315789473684211,
                arithmeticOperations.divide(25, 3.8), 0.000000001);
    }

    /**
     * Tests divide() with numerator as zero.
     */
    @Test
    public void testDivideNumeratorZero() {
        assertEquals(0, arithmeticOperations.divide(0, 10), 0);
    }

    /**
     * Tests divide() with both arguments as zero.
     */
    @Test (expected = ArithmeticException.class)
    public void testDivideBothZero() {
        arithmeticOperations.divide(0, 0);
    }

    /**
     * Tests divide() with denominator as zero.
     */
    @Test (expected = ArithmeticException.class)
    public void testDivideDenominatorZeroException() {
        arithmeticOperations.divide(10, 0);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Tests multiply() with x < 0.
     */
    @Test
    public void testMultiplyXNegative() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        arithmeticOperations.multiply(-5, 8);
    }

    /**
     * Tests multiply() with y < 0.
     */
    @Test
    public void testMultiplyYNegative() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        arithmeticOperations.multiply(5, -8);
    }

    /**
     * Tests multiply() with both ints negative.
     */
    @Test
    public void testMultiplyBothNegative() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        arithmeticOperations.multiply(-342, -8);
    }

    /**
     * Tests multiply() with both ints positive.
     */
    @Test
    public void testMultiplyNormal() {
        assertEquals(72, arithmeticOperations.multiply(9, 8));
    }

    /**
     * Tests multiply() with x = 0.
     */
    @Test
    public void testMultiplyxZero() {
        assertEquals(0, arithmeticOperations.multiply(0, 9));
    }

    /**
     * Tests multiply() with y = 0.
     */
    @Test
    public void testMultiplyyZero() {
        thrown.expect(ArithmeticException.class);
        arithmeticOperations.multiply(54, 0);
    }

    /**
     * Tests multiply() with x as a large number.
     */
    @Test
    public void testMultiplyxHuge() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The product does not fit in an Integer variable");
        arithmeticOperations.multiply(Integer.MAX_VALUE, 9);
    }

    /**
     * Tests multiply() with y as a large number.
     */
    @Test
    public void testMultiplyyHuge() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The product does not fit in an Integer variable");
        arithmeticOperations.multiply(9, Integer.MAX_VALUE);
    }
}
