package fr.norsys.stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    public void shouldReturn0() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.add(""));
    }
    @Test
    public void shouldReturnSingleNumber() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add("5"));
    }
    @Test
    public void shouldReturnSum() {
        Calculator calculator = new Calculator();
        assertEquals(30, calculator.add("10,20"));
    }
    @Test
    public void shouldSupportUnknownAmountOfNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(15, calculator.add("5,5,5"));
    }
    @Test
    public void shouldSupportNewLinesBetweenNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.add("1\n2,3"));
    }
    @Test
    public void shouldSupportDifferentDelimiters() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.add("//;\n1;2"));
    }
    @Test
    public void shouldThrowException(){
        Calculator calculator = new Calculator();
        assertThrows(RuntimeException.class,() ->calculator.add("-1"));
    }
    @Test
    public void shouldThrowExceptionForMultipleNegatives(){
        Calculator calculator = new Calculator();
       Exception e= assertThrows(RuntimeException.class,() ->calculator.add("-1,-2,-4"));

        assertEquals("[-1, -2, -4]",e.getMessage());

    }
    @Test
    public void shouldSkipBiggersNumbers(){
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add("1001,2"));
    }
    @Test
    public void testdDelimitersOfAnyLength(){
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.add("//[;;;]\n1;;;2;;;3"));
    }}
    /*@Test
    public void testMultipleDelimiters(){
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.add("//[;;;][,,,]\n1;;;2,,,3"));
    }



}*/
