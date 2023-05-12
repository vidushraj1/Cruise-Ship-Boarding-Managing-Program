package com.example.cruise_shiptask2;

public class Cabin {
    //this class is used to store each passenger details in an object of arrays formats for each cabin.
    //the passenger details are stored as 2D array.
    public String CruiseCabin;
    public static Passenger[][] P_details = new Passenger[12][3];

    public Cabin(String CruiseCabin, Passenger [][] P_details) {
        this.CruiseCabin = CruiseCabin;
        this.P_details = P_details;
    }
}