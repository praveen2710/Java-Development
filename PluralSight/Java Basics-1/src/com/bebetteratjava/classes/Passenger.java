package com.bebetteratjava.classes;

import com.bebetteratjava.inheritance.travelAir.Person;

/**
 * Created by pb033954 on 3/21/2017.
 */
public class Passenger extends Person {

    public int getFreeBags() {
        return freeBags;
    }

    private int freeBags ;

    //TODO sort passengers based on level and duration of program it
    public static class RewardProgram{

        private int memberLevel; // 3 has highest priority
        private int memberDays;

        public int getMemberLevel() {return memberLevel;}

        public void setMemberLevel(int level) {this.memberLevel = level;}

        public int getMemberDays() {return memberDays;}

        public void setMemberDays(int days) {this.memberDays = days;}
    }

    private RewardProgram rewardProgram = new RewardProgram();

    private int checkedBags;
    private double perBagFee;

    public  Passenger(){}

    public Passenger(int freeBags){
        this(freeBags>1? 25.0d:50.0d);
        this.freeBags = freeBags;
    }

    /**
     * THis is example of constructor chaining.The only caveat is
     * it should be first thing to be done
     * @param freeBags
     * @param checkedBags
     */
    public Passenger(int freeBags,int checkedBags){
        this(freeBags);
        this.checkedBags = checkedBags;
    }

    /**
     * This kind of constructor cant be called from outside the class used in
     * one of the constructors
     * @param perBagFee
     */
    private Passenger(double perBagFee){
        this.perBagFee = perBagFee;
    }


    public int getCheckedBags() {
        return checkedBags;
    }

    public void setPassengerName(String name){
        super.setName(name);
    }

    public RewardProgram getRewardProgram() {return rewardProgram;}

}
