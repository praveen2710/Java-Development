package com.bebetteratjava.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by pb033954 on 3/31/2017.
 */
public class Main {
    public static void main(String args[]){
//        try {
//            accessTypeClass();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        accessTypeInformation();
//        accessTypeMembers();
//          methodAccess();
        createClassInstance();
        createClassInstancev2();
    }

    /**
     * This will use reflection to create instance of object when needed
     * and switch to using object directly for improved performance
     */
    private static void createClassInstancev2() {
        BankAccount acct1 = new BankAccount("12451");
        startWorkv2("com.bebetteratjava.reflections.AccountWorker",acct1);
    }


    private static void startWorkv2(String workerTypeName,Object workerTarget) {
        try {
            Class<?>  workerType = Class.forName(workerTypeName);
            TaskWorker worker = (TaskWorker)workerType.newInstance();
            worker.setTarget(workerTarget);
            worker.doWork();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * This will show how to use reflection to create objects
     */
    private static void createClassInstance() {
        BankAccount acct1 = new BankAccount("12451");
        startWork("com.bebetteratjava.reflections.AccountWorker",acct1);
        System.out.println(acct1.getId());
        System.out.println(acct1.getBalance());
    }

    private static void startWork(String workerTypeName,Object workerTarget) {
        try {
            Class<?>  workerType = Class.forName(workerTypeName);
            Class<?>  targetType = workerTarget.getClass();
            Constructor c = workerType.getConstructor(targetType);
            Object worker = c.newInstance(workerTarget);
            Method setTxType = workerType.getMethod("setTxType",char.class);
            setTxType.invoke(worker,'d');
            Method setAmt = workerType.getMethod("setAmt",int.class);
            setAmt.invoke(worker,130);
            Method doWork = workerType.getMethod("doWork");
            doWork.invoke(worker);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    /**
     * This will show how to access methods using reflection
     */
    private static void methodAccess() {
        BankAccount acct1 = new BankAccount("1234",500);
        callGetId(acct1);
        callDeposit(acct1,50);
        System.out.println(acct1.getBalance());
    }

    private static void callDeposit(Object obj, int amt) {
        Class<?> theClass = obj.getClass();
        System.out.println(theClass.getSimpleName()+"Method Access Deposit");
        try {
            Method m = theClass.getMethod("deposit",int.class);
            m.invoke(obj,amt);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    private static void callGetId(Object obj) {
        Class<?> theClass = obj.getClass();
        System.out.println(theClass.getSimpleName()+"Method Access getId");
        Method m = null;
        try {
            m = theClass.getMethod("getId");
            System.out.println(m.invoke(obj));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    /**
     * members[fields,methods,constructors] etc.. of a class
     */
    private static void accessTypeMembers() {
        HighVolumeAccount hva = new HighVolumeAccount("1568",10000);
        BankAccount ba = new BankAccount("12345");
        fieldInfo(ba);
        fieldInfo(hva);
        methodInfo(ba);
        methodInfo(hva);

    }

    private static void methodInfo(Object obj){
        Class<?> theClass = obj.getClass();
        System.out.println(theClass.getSimpleName()+"Method Info");
        System.out.println("get Methods");
        //this retrieves all fields declared and inherited fields as long as they are public
        Method[] methods = theClass.getMethods();
//        displayMethods(methods);
        displayMethodsExcludeObject(methods);
        System.out.println("Declared Methods");
        Method[] declMethods = theClass.getDeclaredMethods();
        displayMethods(declMethods);

    }

    private static void displayMethodsExcludeObject(Method[] methods) {
        for (Method m:methods)
            if(m.getDeclaringClass()!= Object.class)
                System.out.println(m.getName()+":"+m.getReturnType());
    }

    private static void displayMethods(Method[] methods) {
        for (Method m:methods)
            System.out.println(m.getName()+":"+m.getReturnType());
    }

    private static void fieldInfo(Object obj) {
        Class<?> theClass = obj.getClass();
        System.out.println(theClass.getSimpleName()+"-Field Info");
        //this retrieves all fields declared and inherited fields as long as they are public
        Field[] fields = theClass.getFields();
        System.out.println("Class Fields retrieve's all declared and public fields");
        displayFields(fields);
        System.out.println("Class declared fields");
        //this retrieves all fields declared directly only but will include private fields
        Field[] declaredFields= theClass.getDeclaredFields();
        displayFields(declaredFields);
    }

    private static void displayFields(Field[] fields) {
        for (Field f:fields)
            System.out.println(f.getName()+":"+f.getType());
    }

    /**
     *
     */
    private static void accessTypeInformation() {
        HighVolumeAccount hva = new HighVolumeAccount("1568",10000);
        classInfo(hva);

    }

    /**
     * This method will retrieve the information about class like
     * its super class,interfaces,modifiers.
     * @param obj
     */
    private static void classInfo(Object obj) {
        Class<?> theClass = obj.getClass();
        System.out.println(theClass.getSimpleName());

        Class<?> superClass = theClass.getSuperclass();
        System.out.println(superClass.getSimpleName());

        Class<?>[] interfaces = theClass.getInterfaces();
        for (Class<?> classInterface:interfaces){
            System.out.println(theClass .isInterface());
            System.out.println(classInterface.isInterface());
            System.out.println(classInterface.getSimpleName());
        }

        int modifiers = theClass.getModifiers();

        if((modifiers & Modifier.FINAL)>0)
            System.out.println("bitwise check final");

        if(Modifier.isFinal(modifiers))
            System.out.println("method check final  class");

        if(Modifier.isPrivate(modifiers))
            System.out.println("method check private class");

        if(Modifier.isProtected(modifiers))
            System.out.println("method check protected class");

        if(Modifier.isPublic(modifiers))
            System.out.println("method check public class");
    }

    /**
     * This method will get reference to {@code {@link Class}} type
     * for {@code {@link BankAccount}} using object,String and Type example
     */
    private static void accessTypeClass() throws ClassNotFoundException {
        BankAccount acct1 = new BankAccount("1234");
        BankAccount acct2 = new BankAccount("5678",500);
        Class<?> bankClassReference = acct1.getClass();
        Class<?>  bankClassString = Class.forName("com.bebetteratjava.reflections.BankAccount");
        Class<?>  bankClassTypeLiteral = BankAccount.class;
        showName(bankClassReference);
        showName(bankClassString);
        showName(bankClassTypeLiteral);
    }

    /**
     * This will get name of class
     * @param theClass
     */
    private static void showName(Class<?> theClass) {
        System.out.println(theClass.getSimpleName());
    }
}
