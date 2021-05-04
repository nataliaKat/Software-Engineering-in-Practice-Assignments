package math;

import io.FileIO;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * FileIOTest tests ArrayOperations class.
 *
 * @author Natalia Katsiapi
 */
public class ArrayOperationsTest {

    ArrayOperations arrayOperations = new ArrayOperations();

    /**
     * Test findPrimesInFile() by mocking fileIO and myMath instances.
     */
    @Test
    public void testFindPrimesInFile() {
        FileIO fileIO = mock(FileIO.class);
        MyMath myMath = mock(MyMath.class);

        when(fileIO.readFile("array-operations")).thenReturn(new int[]{23, 12, 2});
        when(myMath.isPrime(23)).thenReturn(true);
        when(myMath.isPrime(12)).thenReturn(false);
        when(myMath.isPrime(2)).thenReturn(false);

        assertArrayEquals(new int[]{23}, arrayOperations.findPrimesInFile(fileIO, "array-operations", myMath));
    }

}
