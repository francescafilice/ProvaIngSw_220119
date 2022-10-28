package it.mat.unical.ingsw2022;


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


}
