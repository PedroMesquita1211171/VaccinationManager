package app.Tests.ConverterTest;

import app.Converters.Converter;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterTest {

    @Test
    public void toIntArray() {
        // data
        String s1 = "12345678";
        String s2 = "01234567";
        // expected
        int[] expected1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected2 = {0, 1, 2, 3, 4, 5, 6, 7};
        // transform
        int[] actual1 = Converter.toIntArray(s1);
        int[] actual2 = Converter.toIntArray(s2);
        // test
        assertArrayEquals(expected1, actual1);
        assertArrayEquals(expected2, actual2);
    }

    @Test(expected = NumberFormatException.class)
    public void toIntArray_Exception() {
        // data
        String s = "123456a89";
        // transform
        Converter.toIntArray(s);
    }
}