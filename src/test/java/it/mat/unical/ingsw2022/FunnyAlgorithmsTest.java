package it.mat.unical.ingsw2022;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FunnyAlgorithmsTest {

    FunnyAlgorithms funnyAlgorithms = null;

    private DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss.SSS");

    @Before
    public void initialize() {
        DateTime startTime = new DateTime();
        System.out.println("START:\t" + fmt.print(startTime));
        if (funnyAlgorithms == null)
            funnyAlgorithms = new FunnyAlgorithms();
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();



    // testing stringToIntConverter
    @Test
    public void stringToIntConverterThrowsExceptionWithRightMessageWhenNumberOutOfLowerBound() {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("The number you want to convert is out of range");
        funnyAlgorithms.stringToIntConverter("-32770");
    }

    @Test
    public void stringToIntConverterThrowsExceptionWithRightMessageWhenNumberOutOfUpperBound() {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("The number you want to convert is out of range");
        funnyAlgorithms.stringToIntConverter("32770");
    }


    @After
    public void printEndingTime() {
        DateTime endTime = new DateTime();
        System.out.println("END:\t" + fmt.print(endTime));
    }


    @Test
    public void stringToIntConverterThrowsExceptionWithRightMessageWhenRationalNumber() {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Invalid string");
        funnyAlgorithms.stringToIntConverter("4.3");
    }

    @Test
    public void stringToIntConverterThrowsExceptionWithRightMessageWhenNumberContainsSpace() {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Invalid string");
        funnyAlgorithms.stringToIntConverter("43 ");
    }

    @Test
    public void stringToIntConverterThrowsExceptionWithRightMessageWhenNumberContainsChar() {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Invalid string");
        funnyAlgorithms.stringToIntConverter("4t3");
    }


    // testing selectionSort
    @Test
    public void selectionSortThrowsExceptionWhenOrderIsNeither0Nor1() {
        int[] array = new int[] {1, 2, 3};
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("L'ordine può essere 0 o 1.");
        funnyAlgorithms.selectionSort(array, 2);
    }

    @Test
    public void selectionSortAscendingThrowsExceptionWhenArrayLengthIsLowerThan2() {
        int[] array = new int[] {};
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("L'array deve contenenre almeno 2 elementi");
        funnyAlgorithms.selectionSort(array, 1);
    }

    @Test
    public void selectionSortDescendingThrowsExceptionWhenArrayLengthIsLowerThan2() {
        int[] array = new int[] {};
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("L'array deve contenenre almeno 2 elementi");
        funnyAlgorithms.selectionSort(array, 0);
    }

    @Test
    public void selectionSortDescendingWorks() {
        int[] array = new int[] {3, 5, 2, 1, 4};
        int[] expected = new int[] {5, 4, 3, 2, 1};
        funnyAlgorithms.selectionSort(array, 0);
        assertArrayEquals(expected, array);
    }

    @Test
    public void selectionSortAscendingWorks() {
        int[] array = new int[] {3, 5, 2, 1, 4};
        int[] expected = new int[] {1, 2, 3, 4, 5};
        funnyAlgorithms.selectionSort(array, 1);
        assertArrayEquals(expected, array);
    }

    // testing binarySeach
    @Test
    public void binarySearchWorksWhenElementIsNotInArray() {
        int[] array = new int[] {3, 5, 2, 1, 4};
        int output = funnyAlgorithms.binarySearch(array, 6);
        assertEquals(-1, output);
    }

}
