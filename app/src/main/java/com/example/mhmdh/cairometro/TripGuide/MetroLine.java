package com.example.mhmdh.cairometro.TripGuide;

/**
 * Created by mhmdh on 1/16/2016.
 */
public class MetroLine {

    public Station[] stations;
    public int[] converters;
    public MetroLine(Station[] s, int[] ic)
    {
        stations = s;
        converters = ic;
    }

    public Station getStation(String n)
    {
        for (int i = 0; i < stations.length; i++)
            if (n.equals(MetroSystem.filter(stations[i].name)))
                return stations[i];
        return null;
    }

}
