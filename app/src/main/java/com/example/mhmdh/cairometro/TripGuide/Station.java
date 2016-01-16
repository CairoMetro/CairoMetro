package com.example.mhmdh.cairometro.TripGuide;

/**
 * Created by mhmdh on 1/16/2016.
 */
public class Station {
    public String name;
    public double latitude;
    public double longitude;
    public int index;

    public Station() { }
    public Station(String n, double latitude, double longitude)
    {
        name = n;
        this.latitude = latitude;
        this.longitude = longitude;
        //index=i;
    }

}
