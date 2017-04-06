package com.bebetteratjava.whatandwhy;

/**
 * Created by pb033954 on 4/6/2017.
 */
public class GenericClassBuffer<T> {
    protected T[] buffer;
    private int readCursor = 0;
    private int writeCursor = 0;

    public GenericClassBuffer(int bufferSize) {
        //here we will have to cast array to type T
        this.buffer = (T[]) new Object[bufferSize];
    }

    /**
     * This will add a value to buffer given there is empty space
     * @param value to be saved to buffer
     * @return true if successful
     *         false if buffer is full;
     */
    public boolean offer(T value){
        if(buffer[writeCursor] != null) {
            return false;
        }
        buffer[writeCursor] = value;
        writeCursor = next(writeCursor);
        return true;
    }

    /**
     * This will remove an element from the buffer
     * @return element in buffer
     */
    public T poll(){
        T polledValue = buffer[readCursor];
        if(polledValue !=null){
            buffer[readCursor] = null;
            readCursor = next(readCursor);
        }
        return  polledValue;
    }

    public void clear(){
        int currentIndex = readCursor;
        while (buffer[currentIndex]!= null){
            buffer[currentIndex]=null;
            currentIndex = next(currentIndex);
        }
    }

    public int next(int index){
        return (index+1)%buffer.length;
    }
}
