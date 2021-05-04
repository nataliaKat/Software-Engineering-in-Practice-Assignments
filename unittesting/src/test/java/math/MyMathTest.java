package math;

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

}
