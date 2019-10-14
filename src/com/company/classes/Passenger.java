package com.company.classes;

import java.util.Calendar;
import java.util.Comparator;
import java.util.StringJoiner;

public class Passenger {
    private String firstName;
    private String lastName;
    private String passport;

    public Passenger(String firstName, String lastName, String passport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
    }

    public Passenger() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public static Comparator<Passenger> PassComparator = new Comparator<Passenger>() {

        @Override
        public int compare(Passenger e1, Passenger e2) {
            return e1.getLastName().compareTo(e2.getLastName());
        }
    };

    public String toString() {
        return this.getLastName() + " " + this.getFirstName() + ", " + this.getPassport();
    }
}
