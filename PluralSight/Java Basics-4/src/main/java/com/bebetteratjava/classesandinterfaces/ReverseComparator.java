package com.bebetteratjava.classesandinterfaces;

import java.util.Comparator;

/**
 * This will take a comparator and return its reverse.
 * It is helpful in scenario where we have multiple comparator's
 * and we need reverse of them. Instead of creating multiple reverse comparator
 * we can create this only one comparator.Here we will be passing type with class name
 * Created by pb033954 on 4/7/2017.
 */
public class ReverseComparator<T> implements Comparator<T> {

    //the comparator for which we need the reversed value
    private final Comparator<T> delegateComparator;

    public ReverseComparator(Comparator<T> delegateComparator) {
        this.delegateComparator = delegateComparator;
    }

    @Override
    public int compare(T left, T right) {
        return -1*delegateComparator.compare(left,right);
    }
}
