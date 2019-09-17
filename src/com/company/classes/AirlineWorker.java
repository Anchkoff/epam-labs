package com.company.classes;

import java.util.Date;

public class AirlineWorker {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String Position;
    private int Salary;

    public AirlineWorker(String firstName, String lastName, Date dateOfBirth, String position, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        Position = position;
        Salary = salary;
    }

    public Date getDateOfBirth() {
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

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }
}
