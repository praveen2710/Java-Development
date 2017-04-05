package com.bebetteratjava.collectionsandmaps;

/**
 * Created by pb033954 on 3/28/2017.
 */
public class MyClass implements Comparable<MyClass>{


    String label,value;

    public MyClass(String label, String value)  {
        this.label = label;
        this.value = value;
    }

    //this affects how collectionsandmaps evaluate
    @Override
    public boolean equals(Object obj) {
        MyClass other = (MyClass) obj;
        return value.equalsIgnoreCase(other.value);
    }

    @Override
    public String toString() {
        return label + "|" + value;
    }


    public String getLabel() {return label;}

    public void setLabel(String label) {this.label = label;}

    public String getValue() {return value;}

    public void setValue(String value) {this.value = value;}

    //this should be consistent with {@code equals} implementation
    @Override
    public int compareTo(MyClass other) {
        return value.compareToIgnoreCase(other.value);
    }
}
