package math;

import io.FileIO;

import java.util.ArrayList;
import java.util.List;

/**
 * A class providing functionality of MyMath upon arrays.
 *
 * @author Natalia Katsiapi
 */
public class ArrayOperations {

    /**
     * Finds the prime numbers of a file.
     * @param fileIo an instance of FileIO class
     * @param filepath the path for the file containing the numbers
     * @param myMath an instance of MyMath class
     * @return an array of only the prime numbers
     */
    public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
        int[] readNumbers = fileIo.readFile(filepath);
        List<Integer> primeNumbers = new ArrayList();
        for (int number : readNumbers) {
            if (myMath.isPrime(number))
                primeNumbers.add(number);
        }

        int[] primeNumbersArray = new int[primeNumbers.size()];
        // Passing int values from list to array
        for (int i = 0; i < primeNumbers.size(); i++) {
            primeNumbersArray[i] = primeNumbers.get(i);
        }
        return  primeNumbersArray;
    }

}
