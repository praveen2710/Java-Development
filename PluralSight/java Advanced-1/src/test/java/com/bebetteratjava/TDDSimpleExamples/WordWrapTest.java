package com.bebetteratjava.TDDSimpleExamples;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by PB033954 on 5/1/2017.
 */
public class WordWrapTest {

    public static final int LINE_LENGTH = 5;

    @Test
    public void lineShouldWrapIfOverLineLength(){
        String result = WordWrap.wrap("The Sleepy", LINE_LENGTH);
        assertEquals("The S\nleepy",result);
    }

    @Test
    public void shortLinesShouldNotWrap(){
        String result = WordWrap.wrap("The", LINE_LENGTH);
        assertEquals("The",result);
    }

    @Test
    public void longerLineShouldWrapTwice(){
        String result = WordWrap.wrap("The Sleepy Brow", LINE_LENGTH);
        assertEquals("The S\nleepy\n Brow",result);
    }


    @Test
    public void evenLongerLineShouldWrapThrice(){
        String result = WordWrap.wrap("The Sleepy Brown Fox", LINE_LENGTH);
        assertEquals("The S\nleepy\n Brow\nn Fox",result);
    }

    @Test
    public void whenLineIsNotMultipleOfLineLength(){
        String result = WordWrap.wrap("The Sleepy Brown Fox.", LINE_LENGTH);
        assertEquals("The S\nleepy\n Brow\nn Fox\n.",result);
    }
}