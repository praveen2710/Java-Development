package com.bebetteratjava.classesandinterfaces;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pb033954 on 4/7/2017.
 */
public class SortedPairTest {

    @Test
    public void shouldRetainOrderofOrderdPair(){
        SortedPair<Integer> pair = new SortedPair<>(1,2);
        assertEquals(1,pair.getFirst().intValue());
        assertEquals(2,pair.getSecond().intValue());

    }

    @Test
    public void shouldFlipOrderofMisorderdPair(){
        SortedPair<Integer> pair = new SortedPair<>(7,5);
        assertEquals(5,pair.getFirst().intValue());
        assertEquals(7,pair.getSecond().intValue());

    }
}