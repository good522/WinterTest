package com.example.wintertest.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Minutely {
    @SerializedName("precipitation_2h")
    public List<String> precipitation_2h;
    @SerializedName("precipitation")
    public List<String> precipitation;
    @SerializedName("probability")
    public String probability;
    @SerializedName("description")
    public String description;
}
