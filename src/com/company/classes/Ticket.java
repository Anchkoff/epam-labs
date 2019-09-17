package com.company.classes;

public class Ticket {
    private Flight flight;
    private Passanger passanger;
    private int cost;

    public Ticket(Flight flight, int cost) {
        this.flight = flight;
        this.cost = cost;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passanger getPassanger() {
        return passanger;
    }

    public void setPassanger(Passanger passanger) {
        this.passanger = passanger;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
