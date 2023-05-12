package com.example.cruise_shiptask3;

public class Passenger {
    //this class will get the values for all those cabin details and stores these in arrays.
    public int P_GuestCount;
    public String FirstNameCabin;
    public String SurNameCabin;
    public double TotalExpenses;

    public Passenger(int P_GuestCount, String FirstNameCabin, String SurNameCabin, double TotalExpenses){
        this.P_GuestCount = P_GuestCount;
        this.FirstNameCabin = FirstNameCabin;
        this.SurNameCabin = SurNameCabin;
        this.TotalExpenses = TotalExpenses;
    }
}
