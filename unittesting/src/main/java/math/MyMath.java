package math;

/**
 * MyMath provides a method to calculate the factorial of a number
 * in order to familiarize with Unit Testing.
 *
 * @author Natalia Katsiapi
 */
public class MyMath {

    /**
     * Calculates the factorial of a positive number less than 12.
     * @param n the number of which the factorial will be calculated
     * @return the factorial
     * @exception IllegalArgumentException when n < 0 or n > 12
     */
    public int factorial (int n) {
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException("n should be >= 0 and < 12");
        }
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}
