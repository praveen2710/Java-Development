package com.bebetteratjava.classesandinterfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by pb033954 on 4/7/2017.
 */
public class Main {

    public static void main(String args[]){

        Person donDraper = new Person("Don Draper",38);
        Person evanJim = new Person("Evans Jim",42);
        Person amyHan = new Person("Amy Han",26);

        List<Person> madMen = new ArrayList<>();
        madMen.add(donDraper);
        madMen.add(evanJim);
        madMen.add(amyHan);

        genericTypeExample(madMen);
        genereicTypeInClass(madMen);

    }

    private static void genereicTypeInClass(List<Person> madMen) {
        List<Person> madMenLocal = new ArrayList<>(madMen);
        System.out.println("generic type in class");
        System.out.println(madMenLocal);
        Collections.sort(madMenLocal,new ReverseComparator<Person>(new AgeComparator()));
        System.out.println(madMenLocal);
    }

    private static void genericTypeExample(List<Person> madMen) {
        List<Person> madMenLocal = new ArrayList<>(madMen);
        System.out.println(madMenLocal);
        Collections.sort(madMenLocal,new AgeComparator());
        System.out.println(madMenLocal);
        Collections.reverse(madMenLocal);
        System.out.println(madMenLocal);
    }


}
