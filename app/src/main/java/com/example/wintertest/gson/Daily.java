package com.example.wintertest.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Daily {
    @SerializedName("status")
    public String status;
    @SerializedName("astro")
    public Astro[] astro;
    @SerializedName("precipitation")
    public Precipitation[] precipitation;
    @SerializedName("precipitation_08h_20h")
    public Precipitation_08h_20h[] precipitation_08h_20h;
    @SerializedName("precipitation_20h_32h")
    public Precipitation_20h_32h[] precipitation_20h_32h;
//    @SerializedName("precipitation")
//    public List<Precipitation> precipitationList;
    @SerializedName("temperature")
    public Temperature[] temperature;
//    @SerializedName("temperature_08h_20h")
//    public List<Temperature_08h_20h> temperature_08h_20hList;
//    @SerializedName("temperature_20h_32h")
//    public List<Temperature_20h_32h> temperature_20h_32hList;
    @SerializedName("wind")
    public Wind[] wind;
//    @SerializedName("wind_08h_20h")
//    public List<Wind_08h_20h> wind_08h_20hList;
//    @SerializedName("wind_20h_32h")
//    public List<Wind_20h_32h> wind_20h_32hList;
    @SerializedName("humidity")
    public Humidity[] humidity;
//    @SerializedName("cloudrate")
//    public List<Cloudrate> cloudrateList;
    @SerializedName("pressure")
    public Pressure[] pressure;
    @SerializedName("visibility")
    public Visibility[] visibility;
    @SerializedName("skycon")
    public Skycon[] skycon;
    @SerializedName("skycon_08h_20h")
    public Skycon_08h_20h[] skycon_08h_20h;
    @SerializedName("skycon_20h_32h")
    public Skycon_20h_32h[] skycon_20h_32h;
    @SerializedName("life_index")
    public Life_index life_index;
    public class Astro{
//        @SerializedName("date")
//        public String date;
        @SerializedName("sunrise")
        public Sunrise sunrise;
        @SerializedName("sunset")
        public Sunset sunset;
        public Sunrise getSunrise(){
            return new Sunrise();
        }
        public void setSunrise(Sunrise sunrise){
            this.sunrise = sunrise;
        }
        public Sunset getSunset(){
            return new Sunset();
        }
        public void setSunset(Sunset sunset){
            this.sunset = sunset;
        }
        public class Sunrise{
            @SerializedName("time")
            public String time;
            public String getTime(){
                return time;
            }
            public void setTime(String time){
                this.time = time;
            }
        }
        public class Sunset{
            @SerializedName("time")
            public String time;
            public String getTime(){
                return time;
            }
            public void setTime(String time){
                this.time = time;
            }
        }
    }
    public class Precipitation_08h_20h{
//        @SerializedName("date")
//        public String date;
//        @SerializedName("max")
//        public String max;
//        @SerializedName("min")
//        public String min;
//        @SerializedName("avg")
//        public String avg;
        @SerializedName("probability")
        public double probability;
        public double getProbability(){
            return probability;
        }
        public void setProbability(double probability){
            this.probability = probability;
        }
    }
    public class Precipitation_20h_32h{
//        @SerializedName("date")
//        public String date;
//        @SerializedName("max")
//        public String max;
//        @SerializedName("min")
//        public String min;
//        @SerializedName("avg")
//        public String avg;
        @SerializedName("probability")
        public double probability;
        public double getProbability(){
            return probability;
        }
        public void setProbability(double probability){
            this.probability = probability;
        }
    }
    public class Precipitation{
//        @SerializedName("date")
//        public String date;
        @SerializedName("max")
        public double max;
        @SerializedName("min")
        public double min;
//        @SerializedName("avg")
//        public String avg;
//        @SerializedName("probability")
//        public String probability;
        public double getMax(){
            return max;
        }
        public void setMax(double max){
            this.max = max;
        }
        public double getMin(){
            return min;
        }
        public void setMin(double min){
            this.min = min;
        }
    }
    public class Temperature{
//        @SerializedName("date")
//        public String date;
        @SerializedName("max")
        public double max;
        @SerializedName("min")
        public double min;
//        @SerializedName("avg")
//        public String avg;
        public double getMax(){
            return max;
        }
        public void setMax(double max){
            this.max = max;
        }
        public double getMin(){
            return min;
        }
        public void setMin(double min){
            this.min = min;
        }
    }
//    public class Temperature_08h_20h{
//        @SerializedName("date")
//        public String date;
//        @SerializedName("max")
//        public String max;
//        @SerializedName("min")
//        public String min;
//        @SerializedName("avg")
//        public String avg;
//    }
//    public class Temperature_20h_32h{
//        @SerializedName("date")
//        public String date;
//        @SerializedName("max")
//        public String max;
//        @SerializedName("min")
//        public String min;
//        @SerializedName("avg")
//        public String avg;
//    }
    public class Wind{
//        @SerializedName("date")
//        public String date;
        @SerializedName("max")
        public Max max;
        @SerializedName("min")
        public Min min;
        public Max getMax(){
            return new Max();
        }
        public void setMax(Max max){
            this.max = max;
        }
        public Min getMin(){
            return new Min();
        }
        public void setMin(Min min){
            this.min = min;
        }
        public class Max{
            @SerializedName("speed")
            public double speed;
            @SerializedName("direction")
            public double direction;
            public double getSpeed(){
                return speed;
            }
            public void setSpeed(double speed){
                this.speed = speed;
            }
            public double getDirection(){
                return direction;
            }
            public void setDirection(double direction){
                this.direction = direction;
            }
        }
        public class Min{
            @SerializedName("speed")
            public double speed;
            @SerializedName("direction")
            public double direction;
            public double getSpeed(){
                return speed;
            }
            public void setSpeed(double speed){
                this.speed = speed;
            }
            public double getDirection(){
                return direction;
            }
            public void setDirection(double direction){
                this.direction = direction;
            }
        }
//        public class Avg{
//            @SerializedName("speed")
//            public String speed;
//            @SerializedName("direction")
//            public String direction;
//        }
    }
//    public class Wind_08h_20h{
//        @SerializedName("date")
//        public String date;
//        public class Max{
//            @SerializedName("speed")
//            public String speed;
//            @SerializedName("direction")
//            public String direction;
//        }
//        public class Min{
//            @SerializedName("speed")
//            public String speed;
//            @SerializedName("direction")
//            public String direction;
//        }
//        public class Avg{
//            @SerializedName("speed")
//            public String speed;
//            @SerializedName("direction")
//            public String direction;
//        }
//    }
//    public class Wind_20h_32h{
//        @SerializedName("date")
//        public String date;
//        public class Max{
//            @SerializedName("speed")
//            public String speed;
//            @SerializedName("direction")
//            public String direction;
//        }
//        public class Min{
//            @SerializedName("speed")
//            public String speed;
//            @SerializedName("direction")
//            public String direction;
//        }
//        public class Avg{
//            @SerializedName("speed")
//            public String speed;
//            @SerializedName("direction")
//            public String direction;
//        }
//    }
    public class Humidity{
//        @SerializedName("date")
//        public String date;
        @SerializedName("max")
        public double max;
        @SerializedName("min")
        public double min;
//        @SerializedName("avg")
//        public String avg;
        public double getMax(){
            return max;
        }
        public void setMax(double max){
            this.max = max;
        }
        public double getMin(){
            return min;
        }
        public void setMin(double min){
            this.min = min;
        }
    }
//    public class Cloudrate{
//        @SerializedName("date")
//        public String date;
//        @SerializedName("max")
//        public String max;
//        @SerializedName("min")
//        public String min;
//        @SerializedName("avg")
//        public String avg;
//    }
    public class Pressure{
//        @SerializedName("date")
//        public String date;
        @SerializedName("max")
        public double max;
        @SerializedName("min")
        public double min;
//        @SerializedName("avg")
//        public String avg;
        public double getMax(){
            return max;
        }
        public void setMax(double max){
            this.max = max;
        }
        public double getMin(){
            return min;
        }
        public void setMin(double min){
            this.min = min;
        }
    }
    public class Visibility{
//        @SerializedName("date")
//        public String date;
        @SerializedName("max")
        public double max;
        @SerializedName("min")
        public double min;
//        @SerializedName("avg")
//        public String avg;
        public double getMax(){
            return max;
        }
        public void setMax(double max){
            this.max = max;
        }
        public double getMin(){
            return min;
        }
        public void setMin(double min){
            this.min = min;
        }
    }
//    public class Air_quality{
//        @SerializedName("aqi")
//        public List<Aqi> aqiList;
//        @SerializedName("pm25")
//        public List<Pm25> pm25List;
//        public class Aqi{
//            @SerializedName("date")
//            public String date;
//            public class Max{
//                @SerializedName("chn")
//                public String chn;
//                @SerializedName("usa")
//                public String usa;
//            }
//            public class Min{
//                @SerializedName("chn")
//                public String chn;
//                @SerializedName("usa")
//                public String usa;
//            }
//            public class Avg{
//                @SerializedName("chn")
//                public String chn;
//                @SerializedName("usa")
//                public String usa;
//            }
//        }
//        public class Pm25{
//            @SerializedName("date")
//            public String date;
//            @SerializedName("max")
//            public String max;
//            @SerializedName("min")
//            public String min;
//            @SerializedName("avg")
//            public String avg;
//        }
//    }
    public class Skycon{
//        @SerializedName("date")
//        public String date;
        @SerializedName("value")
        public String value;
        public String getValue(){
            return value;
        }
        public void setValue(String value){
            this.value = value;
        }
    }
    public class Skycon_08h_20h{
//        @SerializedName("date")
//        public String date;
        @SerializedName("value")
        public String value;
        public String getValue(){
            return value;
        }
        public void setValue(String value){
            this.value = value;
        }
    }
    public class Skycon_20h_32h{
//        @SerializedName("date")
//        public String date;
        @SerializedName("value")
        public String value;
        public String getValue(){
            return value;
        }
        public void setValue(String value){
            this.value = value;
        }
    }
    public class Life_index{
        @SerializedName("ultraviolet")
        public Ultraviolet[] ultraviolet;
        @SerializedName("car_washing")
        public CarWashing[] carWashing;
        @SerializedName("dressing")
        public Dressing[] dressing;
        @SerializedName("comfort")
        public Comfort[] comfort;
        @SerializedName("cold_risk")
        public ColdRisk[] coldRisk;
        public ColdRisk[] getColdRisk(){
            return coldRisk;
        }
        public void setColdRisk(ColdRisk[] coldRisk){
            this.coldRisk = coldRisk;
        }
        public Comfort[] getComfort(){
            return comfort;
        }
        public void setComfort(Comfort[] comfort){
            this.comfort = comfort;
        }
        public Dressing[] getDressing(){
            return dressing;
        }
        public void setDressing(Dressing[] dressing){
            this.dressing = dressing;
        }
        public CarWashing[] getCarWashing(){
            return carWashing;
        }
        public void setCarWashing(CarWashing[] carWashing){
            this.carWashing = carWashing;
        }
        public Ultraviolet[] getUltraviolet(){
            return ultraviolet;
        }
        public void setUltraviolet(Ultraviolet[] ultraviolet){
            this.ultraviolet = ultraviolet;
        }
        public class Ultraviolet{
//            @SerializedName("date")
//            public String date;
//            @SerializedName("index")
//            public String index;
            @SerializedName("desc")
            public String desc;
            public String getDesc(){
                return desc;
            }
            public void setDesc(String desc){
                this.desc = desc;
            }
        }
        public class CarWashing{
//            @SerializedName("date")
//            public String date;
//            @SerializedName("index")
//            public String index;
            @SerializedName("desc")
            public String desc;
            public String getDesc(){
                return desc;
            }
            public void setDesc(String desc){
                this.desc = desc;
            }
        }
        public class Dressing{
//            @SerializedName("date")
//            public String date;
//            @SerializedName("index")
//            public String index;
            @SerializedName("desc")
            public String desc;
            public String getDesc(){
                return desc;
            }
            public void setDesc(String desc){
                this.desc = desc;
            }
        }
        public class Comfort{
//            @SerializedName("date")
//            public String date;
//            @SerializedName("index")
//            public String index;
            @SerializedName("desc")
            public String desc;
            public String getDesc(){
                return desc;
            }
            public void setDesc(String desc){
                this.desc = desc;
            }
        }
        public class ColdRisk{
//            @SerializedName("date")
//            public String date;
//            @SerializedName("index")
//            public String index;
            @SerializedName("desc")
            public String desc;
            public String getDesc(){
                return desc;
            }
            public void setDesc(String desc){
                this.desc = desc;
            }
        }
    }
    public Astro[] getAstro(){
        return astro;
    }
    public void setAstro(Astro[] astro){
        this.astro = astro;
    }
    public Precipitation[] getPrecipitation(){
        return precipitation;
    }
    public void setPrecipitation(Precipitation[] precipitation){
        this.precipitation = precipitation;
    }
    public Precipitation_08h_20h[] getPrecipitation_08h_20h(){
        return precipitation_08h_20h;
    }
    public void setPrecipitation_08h_20h(Precipitation_08h_20h[] precipitation_08h_20h){
        this.precipitation_08h_20h = precipitation_08h_20h;
    }
    public Precipitation_20h_32h[] getPrecipitation_20h_32h(){
        return precipitation_20h_32h;
    }
    public void setPrecipitation_20h_32h(Precipitation_20h_32h[] precipitation_20h_32h){
        this.precipitation_20h_32h = precipitation_20h_32h;
    }
    public Temperature[] getTemperature(){
        return temperature;
    }
    public void setTemperature(Temperature[] temperature){
        this.temperature = temperature;
    }
    public Wind[] getWind(){
        return wind;
    }
    public void setWind(Wind[] wind){
        this.wind = wind;
    }
    public Humidity[] getHumidity(){
        return humidity;
    }
    public void setHumidity(Humidity[] humidity){
        this.humidity = humidity;
    }
    public Pressure[] getPressure(){
        return pressure;
    }
    public void setPressure(Pressure[] pressure){
        this.pressure = pressure;
    }
    public Visibility[] getVisibility(){
        return visibility;
    }
    public void setVisibility(Visibility[] visibility){
        this.visibility = visibility;
    }
    public Skycon[] getSkycon(){
        return skycon;
    }
    public void setSkycon(Skycon[] skycon){
        this.skycon = skycon;
    }
    public Skycon_08h_20h[] getSkycon_08h_20h(){
        return skycon_08h_20h;
    }
    public void setSkycon_08h_20h(Skycon_08h_20h[] skycon_08h_20h){
        this.skycon_08h_20h = skycon_08h_20h;
    }
    public Skycon_20h_32h[] getSkycon_20h_32h(){
        return skycon_20h_32h;
    }
    public void setSkycon_20h_32h(Skycon_20h_32h[] skycon_20h_32h){
        this.skycon_20h_32h = skycon_20h_32h;
    }
    public Life_index getLife_index(){
        return life_index;
    }
    public void setLife_index(Life_index life_index){
        this.life_index = life_index;
    }
}
