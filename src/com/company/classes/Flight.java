package com.company.classes;

import java.util.Date;

public class Flight {
    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    private Date departureTime;
    private Date arrivalTime;
    private String gate;
    private Boolean checkIn;
    private AirCraft plane;

    public Flight(String flightNumber, String departureCity, String arrivalCity, Date departureTime, Date arrivalTime, Boolean checkIn, AirCraft plane) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.checkIn = checkIn;
        this.plane = plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public AirCraft getPlane() {
        return plane;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public Boolean getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Boolean checkIn) {
        this.checkIn = checkIn;
    }
}
