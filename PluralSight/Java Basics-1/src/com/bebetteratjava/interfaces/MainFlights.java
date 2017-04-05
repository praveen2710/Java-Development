package com.bebetteratjava.interfaces;

import com.bebetteratjava.classes.Passenger;

/**
 * Created by PB033954 on 3/25/2017.
 */
public class MainFlights {
    public static void main(String args[]){

        NestedStaticTypesRewards();



    }

    private static void NestedStaticTypesRewards() {
        Passenger steve = new Passenger();
        steve.setPassengerName("Steve");
        steve.getRewardProgram().setMemberLevel(3);
        steve.getRewardProgram().setMemberDays(100);

        //since RewardsProgram is public it can be accessed on its own
        Passenger.RewardProgram platinum = new Passenger.RewardProgram();
        platinum.setMemberLevel(3);

        if(steve.getRewardProgram().getMemberLevel() == platinum.getMemberLevel()){
            System.out.println("Steve is platinum");
        }
    }
}
