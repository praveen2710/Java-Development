package com.bebetteratjava.collectionsandmaps;

import java.util.Comparator;

/**
 * Created by pb033954 on 3/28/2017.
 */
public class MyComparator implements Comparator<MyClass>{

    @Override
    public int compare(MyClass o1, MyClass o2) {
        return o1.getLabel().compareToIgnoreCase(o2.getLabel());
    }
}
