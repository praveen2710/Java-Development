package com.bebetteratjava.wildcards.unbounded;

import com.bebetteratjava.classesandinterfaces.Person;
import sun.swing.BakedArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pb033954 on 4/7/2017.
 */
public class Main {
    public static void main(String args[]){
        List<Object> objects = new ArrayList();
        objects.add(new Object());
        objects.add(new Person("Don draper",89));
        System.out.println(objects);


        List<?> objects2= new ArrayList();
        objects2.add(null);
//        objects2.add(new Object());
//        objects2.add(new Person("Don draper",89));
        System.out.println(objects);
    }
}
