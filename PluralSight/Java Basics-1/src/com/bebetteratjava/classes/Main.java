package com.bebetteratjava.classes;

/**
 * Created by pb033954 on 3/21/2017.
 */
public class Main {
    public static void main(String args[]){

//        passBYReferenceEffects();
        combineFlight();
//        mathCal();
//        FillFlight();
//        addManyPassengers();
//        flightComparison();
    }

    private static void flightComparison() {
        Flight f1 = new Flight(456);
        Flight f2 = new Flight(456);

        if(f1 == f2)
            System.out.println("f1 == f2");

        if(f1.equals(f2))
            System.out.println("f1 equals f2");

        Flight f3 = f2;

        if(f2 == f3)
            System.out.println("f2 == f3");

        if(f2.equals(f3))
            System.out.println("f2 equals f3");


    }

    private static void addManyPassengers() {
        Flight f1 = new Flight('B');
        Passenger john = new Passenger(0,1);
        Passenger susan = new Passenger(0,2);


        Passenger johnny = new Passenger(0,2);
        Passenger susie = new Passenger(0,2);
        Passenger bart = new Passenger(0,2);

        //Either way can be used if we use parameter with ... at end
        f1.addPassengers(john,susan);
        f1.addPassengers(new Passenger[]{johnny,susie,bart});
    }

    private static void FillFlight() {
        Flight f1 = new Flight(444);
        Passenger p1 = new Passenger(0,1);
        Passenger p2 = new Passenger(0,2);

        System.out.println("p1 checked bags "+p1.getCheckedBags());
        f1.add1Passenger();
        f1.add1Passenger(p2);
        f1.add1Passenger(p1);

        short threeBags = 3;
        //type conversation happens here from short to int
        f1.add1Passenger(threeBags,2);
        System.out.print(f1.toString());


    }

    private static void mathCal() {

        MathEquation[] equations = new MathEquation[4];
        equations[0] =  new MathEquation('d',100.0d,0.0d);
        equations[1] =  new MathEquation('a',25.0d,92.0d);
        equations[2] =  new MathEquation('s',225.0d,17.0d);
        equations[3] =  new MathEquation('m',11.0d,3.0d);

        for(MathEquation eachResult:equations){
            eachResult.execute();
            System.out.print("Result=");
            System.out.println(eachResult.getResult());
        }

        double leftDouble = 9.0d;
        double rightDouble = 4.0d;

        MathEquation equationOverload = new MathEquation('d');
        equationOverload.execute(leftDouble,rightDouble);
        System.out.println("Result = "+ equationOverload.getResult());

        int leftInt = 9;
        int rightInt = 4;

        equationOverload.execute(leftInt,rightInt);
        System.out.println("Result = "+ equationOverload.getResult());

        //widening conversion happens and two double parameters is used
        equationOverload.execute((double)leftInt,rightInt);
        System.out.println("Result = "+ equationOverload.getResult());


    }

//Obsolete with usage of constructor
//    private static MathEquation create(double leftVal,double rightVal,char opCode){
//        MathEquation equation = new MathEquation();
//        equation.setLeftVal(leftVal);
//        equation.setRightVal(rightVal);
//        equation.setOpCode(opCode);
//        return equation;
//    }

    private static void combineFlight() {
        Flight lax1 = new Flight();
        Flight lax2 = new Flight();

        lax1.add1Passenger();
        lax1.add1Passenger();
        lax1.add1Passenger();
        lax1.debugMode = true;

        lax2.add1Passenger();
        lax2.add1Passenger();
        lax2.debugMode = true;

        Flight lax3 = null;

        if(lax1.hasRoom(lax2)){
            lax3 = lax1.createNewWithBoth(lax2);
        }

        System.out.println(lax1.toString());
        System.out.println(lax2.toString());
        if(null!=lax3)
            lax3.debugMode = true;
            System.out.println(lax3.toString());
    }

    /**
     * This method shows how equal to works different for
     * objects than how it works for primitive data type
     */
    private static void passBYReferenceEffects() {

        int valA = 10;
        int valB = 21;

        Flight f1 = new Flight();
        f1.add1Passenger();
        f1.add1Passenger();
        System.out.println("flight1 intial:"+f1.toString());

        valA +=1;
        valA +=1;
        System.out.println("ValA intial:"+valA);

        Flight f2 = new Flight();
        f2.add1Passenger();
        System.out.println("flight2 intial:" +f2.toString());

        valB+= 1;
        System.out.println("ValB intial:"+valB);


        f2 = f1;
        valB = valA;
        System.out.println("f2 is now equal f1 f2: "+f2.toString());
        System.out.println("ValB is equal to valA "+valB);

        f1.add1Passenger();
        valA += 1;
        System.out.println("added passenger to f1 : "+f1.toString());
        System.out.println("added passenger to f1 f2: "+f2.toString());
        System.out.println("added 1 to Val A :"+valA);
        System.out.println("added 1 to Val A ValB:"+valB);
    }
}
