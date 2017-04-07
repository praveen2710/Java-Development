package com.bebetteratjava.classesandinterfaces;

import java.util.Comparator;

/**
 * Created by pb033954 on 4/7/2017.
 */
public class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        //to reverse order simply multiply return to -1
        return Integer.compare(o1.getAge(),o2.getAge());
    }

}
