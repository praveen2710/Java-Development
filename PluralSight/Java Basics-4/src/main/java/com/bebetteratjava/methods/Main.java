package com.bebetteratjava.methods;

import com.bebetteratjava.classesandinterfaces.AgeComparator;
import com.bebetteratjava.classesandinterfaces.Person;

import java.util.ArrayList;
import java.util.Comparator;
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

        final Person youngestCastMember = minmizerFirstStab(madMen);
        final Person youngestCastMemberGeneric = minimizerGeneric(madMen);

    }

    private static Person minmizerFirstStab(List<Person> madMen) {
        final Person youngestCastMember = (Person) min(madMen,new AgeComparator());
        System.out.println(youngestCastMember);
        try {
            final Person youngestCastMember2 = (Person) min(madMen, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o1, o2);
                }
            });
        }catch (ClassCastException ce){
            ce.printStackTrace();
        }
        return youngestCastMember;
    }

    /**
     * simple first implement of min element.It works but has its downside it is not type safe
     * and will fail at run time not at compile time
     * @param values
     * @param comparator
     * @return
     */
    private static Object min(List values,Comparator comparator){
        if(values.isEmpty()){
            throw new IllegalArgumentException("List is empty");
        }

        Object lowestElement = values.get(0);

        for(int i=0;i<values.size();i++){
            final  Object element = values.get(i);
            if(comparator.compare(element,lowestElement) < 0){
                lowestElement = element;
            }
        }

        return lowestElement;
    }

    private static Person minimizerGeneric(List<Person> madMen) {
        //here both the paramter need to be same
        final Person youngestCastMember = minGeneric(madMen,new AgeComparator());

//        final Person youngestCastMember2 = (Person) minGeneric(madMen, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o1, o2);
//            }
//        });

        List<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        System.out.println(minGeneric(numbers,Integer::compare));
        return  youngestCastMember;
    }
    /**
     * THis is example of having type safe generic methods
     * @param values
     * @param comparator
     * @param <T>
     * @return
     */
    private static <T> T minGeneric(List<T> values, Comparator<T> comparator){
        if(values.isEmpty()){
            throw new IllegalArgumentException("List is empty");
        }

        T lowestElement = values.get(0);

        for(int i=0;i<values.size();i++){
            final  T element = values.get(i);
            if(comparator.compare(element,lowestElement) < 0){
                lowestElement = element;
            }
        }

        return lowestElement;

    }

}
