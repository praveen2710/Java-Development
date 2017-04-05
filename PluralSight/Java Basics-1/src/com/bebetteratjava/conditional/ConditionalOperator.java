package com.bebetteratjava.conditional;

/**
 * Created by pb033954 on 3/21/2017.
 */
public class ConditionalOperator {

    public static void main (String args[]){
        nestedIfElse();
        dividedByZero();
    }

    /**
     * Float can handle divide by zero but int cannot.
     * This method shows how to do it effectively.
     */
    private static void dividedByZero() {
        int students = 150;
        int rooms = 0;

        //&& stops after first part of evaluation fails . & does not stop after first part fails
        if (rooms > 0.0f && students / rooms > 30)
            System.out.println("Int Crowded &&!!");
        else
            System.out.println("Int Not Crowded &&!!");

        try {
            //this wont work since it does not stop evaluation after first condition fails
            if (rooms > 0.0f & students / rooms > 30)
                System.out.println("int Crowded & !!");
            else
                System.out.println("Int Not Crowded &!!");
        }catch(ArithmeticException ae){
            ae.printStackTrace();
        }

        System.out.println("** End Method**");
    }

    public static void nestedIfElse() {
        float students = 0.0f;
        float noOfRooms = 4.0f;

        /*This will not work since even though the indentation show that the else
        * is connected to outer if it actually now is related to inner if statement.
        * To correct this see the next part.*/
        if (students > 0.0f)
            if (noOfRooms > 0.0f)
                System.out.println(students / noOfRooms);
        else
            System.out.println("No Students");

        /*We need to wrap the if in a block statements to avoid confusion on which else
        * the if belongs to*/
        if (students > 0.0f) {
            if (noOfRooms > 0.0f)
                System.out.println(students / noOfRooms);
        } else
            System.out.println("No Students Correct version");

        //floats and doubles can handle divide by zero
        noOfRooms = 0.0f;
        students = 150.0f;
        if (students > 0.0f & students / noOfRooms > 30)
            System.out.println("Crowded!!");
    }
}
