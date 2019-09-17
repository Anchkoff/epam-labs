package com.company.classes;

public class FlightWorker {
    private Flight flight;
    private AirlineWorker worker;
    private int SalaryBonus;

    public FlightWorker(Flight flight, AirlineWorker worker) {
        this.flight = flight;
        this.worker = worker;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public AirlineWorker getWorker() {
        return worker;
    }

    public void setWorker(AirlineWorker worker) {
        this.worker = worker;
    }

    public int getSalaryBonus() {
        return SalaryBonus;
    }

    public void setSalaryBonus(int salaryBonus) {
        SalaryBonus = salaryBonus;
    }
}
