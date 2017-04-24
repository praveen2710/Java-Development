package com.bebetteratjava.wildcards.bounded;

import com.bebetteratjava.classesandinterfaces.Person;

/**
 * Created by pb033954 on 4/7/2017.
 */
public class Partner extends Person {

    public Partner(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Patner{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }
}
