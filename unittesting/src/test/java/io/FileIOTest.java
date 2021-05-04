package io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;

import static org.junit.Assert.*;

/**
 * FileIOTest tests FileIO class
 *
 * @author Natalia Katsiapi
 */
public class FileIOTest {

    FileIO fileIO = new FileIO();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Tests with a file with just int values.
     */
    @Test
    public void testReadFileNormal() {
        String resourceName = "normal";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(resourceName).getFile());
        String filepath = file.getAbsolutePath();
        Assert.assertArrayEquals(new int[]{453, 3425, 123, -467, 34, -2365, 43, 43, 0, -963,
                3334, 324, 56, 4263}, fileIO.readFile(filepath));
        fileIO.readFile(filepath);
    }

    /**
     * Tests with a non-existent file.
     */
    @Test
    public void testReadFileNonExistent() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Input file does not exist");
        fileIO.readFile("nonexistent");
    }

    /**
     * Tests with an empty file.
     */
    @Test
    public void testReadFileEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Given file is empty");
        String resourceName = "empty";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(resourceName).getFile());
        String filepath = file.getAbsolutePath();
        fileIO.readFile(filepath);
    }

    /**
     * Tests with a file with invalid(non-Integer) values
     */
    @Test
    public void testReadFileContainsInvalidEntries() {
        String resourceName = "invalid-entries";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(resourceName).getFile());
        String filepath = file.getAbsolutePath();
        Assert.assertArrayEquals(new int[]{2, 4, 5}, fileIO.readFile(filepath));
        fileIO.readFile(filepath);
    }

}