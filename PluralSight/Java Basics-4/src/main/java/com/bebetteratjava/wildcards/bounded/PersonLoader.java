package com.bebetteratjava.wildcards.bounded;

import com.bebetteratjava.classesandinterfaces.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.List;

/**
 * Created by pb033954 on 4/7/2017.
 */
public class PersonLoader {
    private final RandomAccessFile file;

    public PersonLoader(final File file) throws FileNotFoundException{
        this.file = new RandomAccessFile(file,"rw");
    }

    public Person load() throws ClassNotFoundException{
        return null;
    }

    /**
     * Here the list can anything that is of person type or its a parent of person.
     * This is example of lower bound wildcards
     * @param people
     * @throws ClassNotFoundException
     */
    public void loadAll(final List<? super Person> people) throws ClassNotFoundException {
        Person person;
        while ((person=load()) != null){
            people.add(person);
        }
    }
}
