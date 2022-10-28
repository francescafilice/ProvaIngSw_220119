package it.mat.unical.ingsw2022;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FunnyAlgorithmsTest {

    FunnyAlgorithms funnyAlgorithms = null;

    @Before
    public void initialize() {
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
    public void selectionSortDescendingWorks() {
        int[] array = new int[] {5, 2, 4, 3, 1};
        int[] expected = new int[] {5, 4, 3, 2, 1};
        funnyAlgorithms.selectionSort(array, 0);
        assertArrayEquals(expected, array);
    }

    @Test
    public void selectionSortAscendingWorks() {
        int[] array = new int[] {5, 2, 4, 3, 1};
        int[] expected = new int[] {1, 2, 3, 4, 5};
        funnyAlgorithms.selectionSort(array, 1);
        assertArrayEquals(expected, array);
    }

}
