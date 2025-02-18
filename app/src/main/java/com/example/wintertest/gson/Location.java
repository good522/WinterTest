package com.example.wintertest.gson;

import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("level")
    public String level;
    @SerializedName("lat")
    public double lat;
    @SerializedName("lon")
    public double lon;
    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
