package com.bebetteratjava.classesandinterfaces;

/**
 * This is example of using type bounds.Here we are using comparable
 * to compare between variables of same instance and not between different instances
 * Created by pb033954 on 4/7/2017.
 */
public class SortedPair<T extends Comparable<T>>{

    private T first;
    private T second;

    public SortedPair(T left, T right) {
        if(left.compareTo(right)<0) {
            this.first = left;
            this.second = right;
        }else{
            this.first = right;
            this.second = left;
        }
    }

    public T getFirst() {return first;}

    public T getSecond() {return second;}

}
