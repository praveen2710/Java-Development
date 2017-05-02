package com.bebetteratjava.TDDSimpleExamples;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by PB033954 on 5/1/2017.
 */
public class LeapYearTest {

    @Test
    public void leapYearsAreDivisibleByFour(){
        assertTrue(LeapYear.isLeapYear(2016));
    }

    @Test
    public void normalYearAreNotDivisibleByFour(){
        assertFalse(LeapYear.isLeapYear(3));
    }
    
    @Test
    public void leapYearsNotDivisibleHundred(){
        assertFalse(LeapYear.isLeapYear(1900));
    }

    @Test
    public void leapYearsDivisibleByFourHundred(){
        assertTrue(LeapYear.isLeapYear(2000));
    }


}