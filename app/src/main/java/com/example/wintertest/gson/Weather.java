package com.example.wintertest.gson;

import com.google.gson.annotations.SerializedName;

public class Weather {
    @SerializedName("result")
    public Result result;
    public Result getResult(){
        return result;
    }
    public void setResult(Result result){
        this.result = result;
    }
    public class Result {
        @SerializedName("forecast_keypoint")
        public String forecast_keypoint;
        @SerializedName("alert")
        public Alert alert;
        @SerializedName("hourly")
        public Hourly hourly;
        public Minutely minutely;
        @SerializedName("daily")
        public Daily daily;
        @SerializedName("realtime")
        public Realtime realtime;
        public String getForecast_keypoint(){
            return forecast_keypoint;
        }
        public void setForecast_keypoint(String forecast_keypoint){
            this.forecast_keypoint = forecast_keypoint;
        }
        public Alert getAlert(){
            return alert;
        }
        public void setAlert(Alert alert){
            this.alert = alert;
        }
        public Hourly getHourly(){
            return hourly;
        }
        public void setHourly(Hourly hourly){
            this.hourly = hourly;
        }
        public Daily getDaily(){
            return daily;
        }
        public void setDaily(Daily daily){
            this.daily = daily;
        }
        public Realtime getRealtime(){
            return realtime;
        }
        public void setRealtime(Realtime realtime){
            this.realtime = realtime;
        }
    }
}
