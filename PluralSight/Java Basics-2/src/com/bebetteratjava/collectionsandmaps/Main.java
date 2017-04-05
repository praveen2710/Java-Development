package com.bebetteratjava.collectionsandmaps;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.SortedMap;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by pb033954 on 3/28/2017.
 */
public class Main {
    public static void main(String args[]){
//        genericCollections();
//        comparisionInCollections();
//        java8Features();
//          switchingArrayandCollections();
//          sortingInCollections();
//        mapsExample();
        sortedMaps();
    }

    private static void sortedMaps() {
        SortedMap<String ,String > map = new TreeMap<>();
        map.put("2222","ghi");
        map.put("3333","abc");
        map.put("1111","def");
        map.put("6666","xyz");
        map.put("4444","mno");
        map.put("5555","pqr");
        //this map sorts based on key
        map.forEach((k,v)-> System.out.println(k +"|" + v));

        //this does not include the key passed in
        System.out.println("HeadMap");
        SortedMap<String ,String > hMap =  map.headMap("3333");
        hMap.forEach((k,v)-> System.out.println(k +"|" + v));

        //this does include key passed in
        System.out.println("tailMap");
        SortedMap<String ,String > tMap =  map.tailMap("3333");
        tMap.forEach((k,v)-> System.out.println(k +"|" + v));

        //this includes the start key but not the end key
        System.out.println("subMap");
        SortedMap<String ,String > sMap =  map.subMap("3333","5555");
        sMap.forEach((k,v)-> System.out.println(k +"|" + v));
    }

    private static void mapsExample() {

        Map<String,String> map = new HashMap<>();
        map.put("2222","ghi");
        map.put("3333","abc");
        map.put("1111","def");

        String s1 = map.get("3333");
        String s2 = map.get("9999");
        String s3 = map.getOrDefault("9999","Not Found");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        map.forEach((k,v)-> System.out.println(k +"|" + v));
        map.replaceAll((k,v)-> v.toUpperCase());
        System.out.println("All Values in upper case");
        map.forEach((k,v)-> System.out.println(k +"|" + v));
    }

    /**
     * This method shows how to use {@code {@link java.util.Comparator}}
     * and {@code {@link Comparable}} for lists that use sorting
     */
    private static void sortingInCollections() {
        TreeSet<MyClass> tree1 = new TreeSet<>();
        MyClass m1 = new MyClass("2222","ghi");
        MyClass m2 = new MyClass("3333","abc");
        MyClass m3 = new MyClass("1111","def");

        tree1.add(m1);
        tree1.add(m2);
        tree1.add(m3);

        //the result here is sorted based on comparable implementation of {@code MyClass}
        tree1.forEach(m-> System.out.println(m.getLabel()));

        TreeSet<MyClass> treeC = new TreeSet<>(new MyComparator());

        treeC.add(m1);
        treeC.add(m2);
        treeC.add(m3);
        treeC.forEach(m-> System.out.println(m.getLabel()));
    }

    private static void switchingArrayandCollections() {
        ArrayList<MyClass> list = new ArrayList<>();

        MyClass m1 = new MyClass("v1","abc");
        MyClass m2 = new MyClass("v2","xyz");
        MyClass m3 = new MyClass("v3","abc");

        list.add(m1);
        list.add(m2);
        list.add(m3);

        Object[] array1 = list.toArray();
        MyClass[] array2 = list.toArray(new MyClass[0]);
        MyClass[] array3 = new MyClass[3];
        MyClass[] array4 =  list.toArray(array3);

        if(array3==array4)
            System.out.println("array 3&4 point to same object");

        Collection<MyClass> newList = Arrays.asList(array4);

        newList.forEach(m-> System.out.println(m.getLabel()));
    }

    /**
     * Usage of forEach & removeIf
     */
    private static void java8Features() {
        ArrayList<MyClass> list = new ArrayList<>();

        MyClass m1 = new MyClass("v1","abc");
        MyClass m2 = new MyClass("v2","xyz");
        MyClass m3 = new MyClass("v3","abc");

        list.add(m1);
        list.add(m2);
        list.add(m3);

        list.forEach(m-> System.out.println(m.getLabel()));

        list.removeIf(m->m.getValue().equals("abc"));
        System.out.println("After Remove");
        list.forEach(m-> System.out.println(m.getLabel()));
    }

    /**
     *How overriding equals changes how remove works in collectionsandmaps
     */
    private static void comparisionInCollections() {

        ArrayList<MyClass> list = new ArrayList<>();

        MyClass m1 = new MyClass("v1","abc");
        MyClass m2 = new MyClass("v2","abc");
        MyClass m3 = new MyClass("v3","abc");

        list.add(m1);
        list.add(m2);
        list.add(m3);

        //this does not remove object m3 but anyting that matches equals value of m3 i.e "abc":(m1)
        //If this is not overwritten it default's to object reference and remove m3
        list.remove(m3);

        for(MyClass m:list)
            System.out.println(m.getLabel());

    }

    /**
     *
     */
    private static void genericCollections() {
        //we dont have to declare  return type after new
        ArrayList <String> list1 = new ArrayList<>();
        list1.add("Foo");
        list1.add("bar");

        System.out.println("Elements:"+list1.size());

        StringJoiner sj= new StringJoiner(",","{","}");
        sj.setEmptyValue("Empty List");
        for(String o:list1)
            sj.add(o);

        System.out.println(sj);

        LinkedList<String> list2 = new LinkedList<>();
        list2.add("Baz");
        list2.add("Boo");

        //usage of addAll
        list1.addAll(list2);

        for(String o:list1)
            System.out.println(o);

    }
}
