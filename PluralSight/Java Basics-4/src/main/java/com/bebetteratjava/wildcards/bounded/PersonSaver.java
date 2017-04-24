package com.bebetteratjava.wildcards.bounded;

import com.bebetteratjava.classesandinterfaces.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

/**
 * Created by pb033954 on 4/7/2017.
 */
public class PersonSaver {
    private final RandomAccessFile file;

    public PersonSaver(final File file) throws FileNotFoundException {
        this.file = new RandomAccessFile(file, "rw");
    }

    public void save(Person person) throws IOException {

    }

    /**
     * This subroutine will work for any class that extends {@code {@link Person}} class.
     * This is example of upperbound
     * @param persons
     * @throws IOException
     */
    public void saveAll(final List<? extends Person> persons) throws IOException {
        for(Person person:persons)
            save(person);
    }
}
