package com.bebetteratjava.whatandwhy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pb033954 on 4/6/2017.
 */
public class CircularBufferTest {

    public CircularBuffer circularBuffer = new CircularBuffer(2);

//    public void setUp() throws Exception {
//        circularBuffer.clear();
//    }
    @Test
    public void shouldOfferPollableResult() {
        assertTrue(circularBuffer.offer(1));
        assertEquals(1,circularBuffer.poll());
        assertNull(circularBuffer.poll());
    }

    @Test
    public void checkIfClearCleansOutBuffer(){

        assertNull(circularBuffer.poll());
        assertTrue(circularBuffer.offer(1));
        assertTrue(circularBuffer.offer(2));
        assertEquals(1,circularBuffer.poll());
        circularBuffer.clear();
        assertNull(circularBuffer.poll());
    }

    @Test
    public void shouldNotOfferWhenBufferIsFull(){
        assertTrue(circularBuffer.offer(1));
        assertTrue(circularBuffer.offer(1));
        assertFalse(circularBuffer.offer(1));
    }

    @Test
    public void largerDataSet(){
        circularBuffer = new CircularBuffer(8);
        assertTrue(circularBuffer.offer(12));
        assertTrue(circularBuffer.offer(2));
        assertTrue(circularBuffer.offer(23));
        assertTrue(circularBuffer.offer(21));
        assertTrue(circularBuffer.offer(32));
        assertTrue(circularBuffer.offer(22));
        assertTrue(circularBuffer.offer(42));
        assertEquals(12,circularBuffer.poll());
        assertEquals(2,circularBuffer.poll());
        assertEquals(23,circularBuffer.poll());
        circularBuffer.clear();
        assertNull(circularBuffer.poll());
    }

}