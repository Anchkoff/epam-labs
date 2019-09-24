package com.company.classes;

public class Ticket {
    private Flight flight;
    private Passenger passenger;
    private int cost;

    public Ticket(Flight flight, int cost) {
        this.flight = flight;
        this.cost = cost;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
