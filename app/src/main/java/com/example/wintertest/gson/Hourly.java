package com.example.wintertest.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hourly {
    @SerializedName("description")
    public String description;
    @SerializedName("precipitation")
    public List<Precipitation> precipitationList;
    @SerializedName("temperature")
    public List<Temperature> temperatureList;
    @SerializedName("apparent_temperature")
    public List<Apparent_temperature> apparent_temperatureList;
    @SerializedName("wind")
    public List<Wind> windList;
    @SerializedName("humidity")
    public List<Humidity> humidityList;
    @SerializedName("cloudrate")
    public List<Cloudrate> cloudrateList;
    @SerializedName("skycon")
    public List<Skycon> skyconList;
    @SerializedName("pressure")
    public List<Pressure> pressureList;
    @SerializedName("visibility")
    public List<Visibility> visibilityList;
    public class Precipitation {
        @SerializedName("datetime")
        public String datetime;
        @SerializedName("value")
        public String value;
        @SerializedName("probability")
        public String probability;
    }
    public class Temperature {
        @SerializedName("datetime")
        public String datetime;
        @SerializedName("value")
        public String value;
    }
    public class Apparent_temperature {
        @SerializedName("datetime")
        public String datetime;
        @SerializedName("value")
        public String value;
    }
    public class Wind {
        @SerializedName("datetime")
        public String datetime;
        @SerializedName("speed")
        public String speed;
        @SerializedName("direction")
        public String direction;
    }
    public class Humidity {
        @SerializedName("datetime")
        public String datetime;
        @SerializedName("value")
        public String value;
    }
    public class Cloudrate {
        @SerializedName("datetime")
        public String datetime;
        @SerializedName("value")
        public String value;
    }
    public class Skycon {
        @SerializedName("datetime")
        public String datetime;
        @SerializedName("value")
        public String value;
    }
    public class Pressure {
        @SerializedName("datetime")
        public String datetime;
        @SerializedName("value")
        public String value;
    }
    public class Visibility {
        @SerializedName("datetime")
        public String datetime;
        @SerializedName("value")
        public String value;
    }
    public class Air_quality {
        @SerializedName("aqi")
        public List<Aqi> aqiList;
        @SerializedName("pm25")
        public List<Pm25> pm25List;
        public class Aqi {
            @SerializedName("datetime")
            public String datetime;
            @SerializedName("value")
            public String value;
            @SerializedName("chn")
            public String chn;
            @SerializedName("usa")
            public String usa;
        }
        public class Pm25 {
            @SerializedName("datetime")
            public String datetime;
            @SerializedName("value")
            public String value;
        }
    }
}
