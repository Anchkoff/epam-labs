package com.company.classes;

import java.util.Calendar;

public class Passenger {
    private String firstName;
    private String lastName;
    private Calendar dateOfBirth;
    private String passport;

    public Passenger(String firstName, String lastName, Calendar dateOfBirth, String passport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.passport = passport;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

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
}
