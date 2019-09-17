package com.company.classes;

public class AirCraft {
    private String model;
    private int maxDistance;
    private int numOfSeats;

    public AirCraft(String model, int maxDistance, int numOfSeats) {
        this.model = model;
        this.maxDistance = maxDistance;
        this.numOfSeats = numOfSeats;
    }

    public String getModel() {
        return model;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }
}
