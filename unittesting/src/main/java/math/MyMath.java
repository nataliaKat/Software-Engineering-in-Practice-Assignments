package math;

/**
 * MyMath provides some math functionality upon numbers
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


    /**
     * Determines if a number is prime or not.
     * @param n number examined
     * @return true if the n is prime and false if it is not
     * @exception IllegalArgumentException when n < 2
     */
    public boolean isPrime(int n) {
        if (n < 2) throw new IllegalArgumentException("n should be >= 2");
        if (n == 2) return true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
