package com.bebetteratjava.trywithresource;

import java.io.IOException;

/**
 *
 */
public class MyAutoCloseable implements AutoCloseable {
    public void saySomething() throws IOException{
        throw new IOException("Throwing one IO Exception to test -In saySomething");
//        System.out.println("Something");
    }
    @Override
    public void close() throws IOException {
        throw new IOException("Throwing one IO Exception to test- In close");
//        System.out.println("close");
    }
}
