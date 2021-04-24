package math;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * MyMathFactorialParameterizedTest tests normal cases for factorial method of MyMath class
 *
 * @author Natalia Katsiapi
 */
@RunWith(Parameterized.class)
public class MyMathFactorialParameterizedTest {

    @Parameter(value = 0)
    public int number;
    @Parameter(value = 1)
    public int result;

    MyMath myMath = new MyMath();

    /**
     * Generates normal values.
     * @return an array of values and expected results
     */
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{0, 1}, {1, 1}, {2, 2}, {12, 479001600}};
        return Arrays.asList(data);
    }

    /**
     * Tests factorial() for each pair of data.
     */
    @Test
    public void testFactorialNormal() {
        assertEquals(result, myMath.factorial(number));
    }

}
