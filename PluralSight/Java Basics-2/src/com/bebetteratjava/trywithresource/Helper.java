package com.bebetteratjava.trywithresource;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
//replacement of java io packages
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 */
public class Helper {
    static public Reader openReader(String fileName) throws IOException {
        return Files.newBufferedReader(Paths.get(fileName));
    }

    static public Writer openWriter(String fileName) throws IOException {
        return Files.newBufferedWriter(Paths.get(fileName));
    }

}
