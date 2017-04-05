package com.bebetteratjava.inheritance.travelAir;

import com.bebetteratjava.classes.Flight;

/**
 * Created by pb033954 on 3/23/2017.
 */
public class CargoFlight extends Flight {
    float maxCargoSpace = 1000.0f;
    float usedCargoSpace;

    public void add1Package(float h,float w,float d){
        double size = h*w*d;
        if(hasCargoSpace(size)){
            usedCargoSpace += size;
        }else
            handleNoSpace();
    }

    private void handleNoSpace() {
        System.out.println("Not enough Space");
    }

    private boolean hasCargoSpace(double size) {
        return usedCargoSpace + size <maxCargoSpace;
    }

    @Override
    public int getSeats(){
        return 12;
    }

    public CargoFlight(){}

    //like this() even super has to be first line in constructor
    public CargoFlight(int flightNumber){
        super(flightNumber);
    }

    //the this here calls the above constructor
    public CargoFlight(int flightNumber,float maxCargoSpace){
        this(flightNumber);
        this.maxCargoSpace = maxCargoSpace;
    }

    //the this here calls the above constructor
    public CargoFlight(float maxCargoSpace){
        this.maxCargoSpace = maxCargoSpace;
    }


}
