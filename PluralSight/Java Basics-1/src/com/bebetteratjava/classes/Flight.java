package com.bebetteratjava.classes;

import com.bebetteratjava.inheritance.travelAir.CrewMember;
import com.bebetteratjava.inheritance.travelAir.FlightIterator;
import com.bebetteratjava.inheritance.travelAir.Person;

import java.util.Iterator;

/**
 * Created by pb033954 on 3/21/2017.
 */
public class Flight implements Comparable<Flight>,Iterable<Person> {

    public boolean debugMode = false;
    private int passengers,seats = 150;
    private Integer flightNumber;
    private Character flightClass;
    private boolean[] isSeatAvailable;
    private int totalCheckedBags;
    private int totalCarryOns=200;
    private int flightTime;

    private static final int MAX_FAA_SEATS = 550;
    private CrewMember[] crew;
    private Passenger[] roster;


    //initialization block  which will be shared among all constructors.
    //If there are multiple initialization blocks they are executed top to bottom.
    {
        isSeatAvailable = new boolean[getSeats()];
        for(int i=0;i < getSeats(); i++)
            isSeatAvailable[i] = true;
    }


    public Flight(){
//        seats = 150;
//        passengers  = 0;
    }

    public Flight(int flightNumber){
        this.flightNumber = flightNumber;
    }

    public Flight(char flightClass){
        this.flightClass = flightClass;
    }

    //This is example of method overloading .A bit different from constructor chaining
    //but similar.Also automatic type conversation still applies here.

    /**
     * Increment number of passengers by 1
     */
    public void add1Passenger(){
        if(hasSeating())
            passengers += 1;
        else
            handleTooMany();
    }

    /**
     * add passenger with bag information
     * @param bags
     */
    public void  add1Passenger(int bags){
        if(hasSeating()){
            add1Passenger();
            totalCheckedBags += bags;
        }
    }

    /**
     * Add passenger and retrieve checked bag from passenger
     * @param p
     */
    public void add1Passenger(Passenger p){
        add1Passenger(p.getCheckedBags());
    }

    public void add1Passenger(Passenger p,int carryOns){
        if(hasSeating() && hasCarryOnSpace(carryOns)){
            add1Passenger(p.getCheckedBags());
            totalCarryOns += carryOns;
        }
    }

    public void add1Passenger(int bags,int carryOns){
        if(hasSeating() && hasCarryOnSpace(carryOns)){
            add1Passenger(bags);
            totalCarryOns +=carryOns;
        }
    }



    private boolean hasCarryOnSpace(int carryOns) {
        return carryOns<totalCarryOns;
    }

    /**
     * Check if seats are available in flight
     * @return true if available false otherwise
     */
    public boolean hasSeating(){
        return passengers<getSeats();
    }

    /**
     * This method takes a list of passengers
     * .Three Ellipse can be used only on last parameter.
     * @param list
     */
    public void addPassengers(Passenger... list){
        if(hasSeating(list.length)){
            passengers += list.length;
            for(Passenger passenger:list){
                totalCheckedBags += passenger.getCheckedBags();
            }
        }else
            handleTooMany();
    }

    public boolean hasSeating(int count){
        return passengers+ count <getSeats();
    }

    /**
     * Handles scenario when there are no more seats left
     */
    private void handleTooMany() {
        System.out.println("Flight is booked");
    }

    @Override
    public String toString(){
        if(debugMode)
            return ("seats:"+seats+" Passengers:"+passengers);

        if(flightNumber != null)
            return "Flight #"+flightNumber;
        else if(flightClass != null)
            return "Flight Class"+flightClass;
        else
            return "Flight identity not set";
    }

    /**
     * Check if there is enough space on both flights to combine them
     * @param f2
     * @return
     */
    public boolean hasRoom(Flight f2){
        int total = this.passengers + f2.passengers;
        return total <= getSeats();
//        if(total <= seats)
//            return true;
//        else
//            return false;
    }

    /**
     * Combine the passengers on both flight
     * @param f2
     * @return new fligh which has all passengers of both flight
     */
    public Flight createNewWithBoth(Flight f2){
        Flight newFlight = new Flight();
        newFlight.setSeats(getSeats());
        newFlight.passengers = this.passengers + f2.passengers;
        return  newFlight;
    }

    @Override
    public boolean equals(Object obj) {

        if(super.equals(0))
            return true;

        if(!(obj instanceof Flight))
            return false;

        Flight other = (Flight) obj;

        return this.flightClass == other.flightClass && this.flightNumber == other.flightNumber;

    }

    public int getPassengers() {return passengers;}

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getSeats() {
        return seats;
    }

    public CrewMember[] getCrew() {return crew;}

    public void setCrew(CrewMember... crew) {this.crew = crew;}

    public Passenger[] getRoster() {return roster;}

    public void setRoster(Passenger... roster) {this.roster = roster;}

    public int getFlightTime() {return flightTime;}

    public void setFlightTime(int flightTime) {this.flightTime = flightTime;}

    /**
     * We set no of seats in flight with validation of FAA regulation
     * @param seats
     */
    private void setSeats(int seats) {
        if(seats<MAX_FAA_SEATS)
            this.seats = seats;
        else
            System.out.println("seat number is above FAA limit");
    }

    @Override
    public int compareTo(Flight f) {
        return flightTime-f.flightTime;
    }

    @Override
    public Iterator<Person> iterator() {
        return new FlightIterator(crew,roster);
    }
}
