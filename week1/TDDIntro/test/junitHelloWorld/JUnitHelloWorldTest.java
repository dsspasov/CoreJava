package junitHelloWorld;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class JUnitHelloWorldTest {
    JUnitHelloWorld test = new JUnitHelloWorld();
    
    @Test
    public void testGetNumberOfDigits() {
        assertEquals(5, test.getNumberOfDigits(12345));
        assertEquals(6, test.getNumberOfDigits(123456));
        assertEquals(7, test.getNumberOfDigits(1234567));
        assertEquals(1, test.getNumberOfDigits(0));

    }

}
