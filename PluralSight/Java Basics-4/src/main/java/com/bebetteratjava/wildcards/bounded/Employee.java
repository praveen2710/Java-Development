package com.bebetteratjava.wildcards.bounded;

import com.bebetteratjava.classesandinterfaces.Person;

/**
 * Created by pb033954 on 4/7/2017.
 */
public class Employee extends Person {
    public Employee(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }
}
