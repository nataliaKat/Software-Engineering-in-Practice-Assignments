package math;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * MyMathTest provides testing methods for MyMath class.
 *
 * @author Natalia Katsiapi
 */
public class MyMathTest {

    MyMath myMath = new MyMath();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Tests factorial() for negative values.
     */
    @Test
    public void testFactorialMinusOne() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("n should be >= 0 and < 12");
        myMath.factorial(-1);
    }

    /**
     * Tests factorial() for > 12 values.
     */
    @Test
    public void testFactorialThirteen() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("n should be >= 0 and < 12");
        myMath.factorial(13);
    }

    /**
     * Tests isPrime() with a prime argument(31).
     */
    @Test
    public void testIsPrimeWithPrime() {
        Assert.assertEquals(true, myMath.isPrime(31));
    }

    /**
     * Tests isPrime() with a non prime argument(18).
     */
    @Test
    public void testIsPrimeWithNonPrime() {
        Assert.assertEquals(false, myMath.isPrime(18));
    }

    /**
     * Tests isPrime() with a border argument(2).
     */
    @Test
    public void testIsPrimeTwo() {
        Assert.assertEquals(true, myMath.isPrime(2));
    }

    /**
     * Tests isPrime() with an argument < 2 (1).
     */
    @Test
    public void testIsPrimeLessThanTwo() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("n should be >= 2");
        myMath.isPrime(1);
    }

}
