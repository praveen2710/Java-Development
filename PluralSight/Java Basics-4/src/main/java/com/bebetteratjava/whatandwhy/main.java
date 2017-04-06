package com.bebetteratjava.whatandwhy;

/**
 * Created by pb033954 on 4/6/2017.
 */
public class main {
    public  static  void main(String args[]){
//        typeUnsafeExample();
        typeSafeGenericExample();
    }

    private static void typeSafeGenericExample() {
        GenericClassBuffer<String> cb = new GenericClassBuffer<>(4);
        cb.offer("a");
        cb.offer("bc");
        cb.offer("d");
        cb.offer(String.valueOf(1));
        try{
            String value = concatenateStringGeneric(cb);
            System.out.println(value);
        }catch (ClassCastException ce){
            ce.printStackTrace();
        }

    }

    private static String concatenateStringGeneric(GenericClassBuffer<String> buffer) {
        StringBuilder result =new StringBuilder();
        String value;
        while ((value= buffer.poll())!=null){
            result.append(value);
        }
        return result.toString();
    }

    /**
     * This shows how type case exception happens on {@code {@link CircularBuffer}}
     * and one resolution of it using {@code {@link StringCircularBuffer}}
     */
    private static void typeUnsafeExample() {
        CircularBuffer cb = new CircularBuffer(4);
        cb.offer("a");
        cb.offer("bc");
        cb.offer("d");
        cb.offer(1);
        try{
            String value = concatenate(cb);
            System.out.println(value);
        }catch (ClassCastException ce){
            ce.printStackTrace();
        }

        StringCircularBuffer scb = new StringCircularBuffer(4);
        scb.offer("a");
        scb.offer("bc");
        scb.offer("d");
        scb.offer("1");
        try{
            String value = concatenateStringEnforced(scb);
            System.out.println(value);
        }catch (ClassCastException ce){
            ce.printStackTrace();
        }


    }

    private static String concatenateStringEnforced(StringCircularBuffer buffer) {
        StringBuilder result =new StringBuilder();
        String value;
        while ((value= buffer.poll())!=null){
            result.append(value);
        }
        return result.toString();
    }

    private static String concatenate(CircularBuffer buffer){
        StringBuilder result =new StringBuilder();
        String value;
        while ((value= (String) buffer.poll())!=null){
            result.append(value);
        }
        return result.toString();
    }
}
