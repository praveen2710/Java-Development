package com.bebetteratjava.inheritance.travelAir;

import com.bebetteratjava.classes.Passenger;

import java.util.Iterator;

/**
 * Created by PB033954 on 3/25/2017.
 */
public class FlightIterator implements Iterator<Person>{

    private CrewMember[] crew;
    private Passenger[] roster;
    private int index = 0;

    public FlightIterator(CrewMember[] crew, Passenger[] roster) {
        this.crew = crew;
        this.roster = roster;
    }

    @Override
    public boolean hasNext() {
        return index<(crew.length+roster.length);
    }

    @Override
    public Person next() {
        Person p =(index<crew.length)?crew[index]:roster[index-crew.length];
        index++;
        return p;
    }
}
