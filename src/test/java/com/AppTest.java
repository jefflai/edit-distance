package com;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AppTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
            { "hello", "hello", false }, {"x", "", true}, {"", "", false},
            {null, null, false}, {"hello", "hellos", true}, {"hello", "bello", true},
            {"hllo", "hello", true}, {"hellooo", "hello", false}, {"heiio", "hello", false},
            {"hel", "hello", false}});
    }
    
    private String stringOne;
    private String stringTwo;
    private boolean expected;
    private String message;
    
    public AppTest(String stringOne, String stringTwo, boolean expected) {
        this.stringOne = stringOne;
        this.stringTwo = stringTwo;
        this.expected = expected;
        message = String.format("stringOne = %s\nstringTwo = %s", stringOne, stringTwo);
    }
    
    @Test
    public void runDynamic() {
        assertEquals(message, expected, Dynamic.hasOneChange(stringOne, stringTwo));
    }
    
    @Test
    public void runIterative() {
        assertEquals(message, expected, Iterative.hasOneChange(stringOne, stringTwo));
    }

}
