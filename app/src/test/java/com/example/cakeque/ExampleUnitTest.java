package com.example.cakeque;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private profitcalculator Profitcalculator;

    @Before
    public void setup() {

        Profitcalculator = new profitcalculator();
    }
    @Test
    public void testCalctotal(){

        float result = Profitcalculator.calcTotal(2000.f,60.f);
        assertEquals(3200.f,result,0.001);
    }
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}