package com.example.wintertest.gson;

import com.google.gson.annotations.SerializedName;

public class Realtime {
    @SerializedName("status")
    public String status;
    @SerializedName("temperature")
    public double temperature;
    @SerializedName("humidity")
    public double humidity;
    @SerializedName("skycon")
    public String skycon;
    @SerializedName("visibility")
    public double visibility;
    @SerializedName("pressure")
    public double pressure;
    @SerializedName("apparent_temperature")
    public double apparent_temperature;
    @SerializedName("wind")
    public Wind wind;
    @SerializedName("precipitation")
    public Precipitation precipitation;
    @SerializedName("air_quality")
    public Air_quality air_quality;
    @SerializedName("life_index")
    public Life_index life_index;
    public class Wind {
        @SerializedName("speed")
        public double speed;
        @SerializedName("direction")
        public String direction;

        public double getSpeed() {
            return speed;
        }
        public String getDirection() {
            return direction;
        }
        public void setSpeed(double speed) {
            this.speed = speed;
        }
        public void setDirection(String direction) {
            this.direction = direction;
        }
    }
    public class Precipitation {
        @SerializedName("local")
        public Local local;
        public Local getLocal() {
            return local;
        }
        public void setLocal(Local local) {
            this.local = local;
        }
        public class Local {
            @SerializedName("intensity")
            public double intensity;

            public double getIntensity() {
                return intensity;
            }
            public void setIntensity(double intensity) {
                this.intensity = intensity;
            }
        }
     //   public class Nearest {
     //       @SerializedName("distance")
     //       public double distance;
     //      @SerializedName("intensity")
        //      public double intensity;
        // }
     }
    public class Air_quality {
        @SerializedName("description")
        public Description description;
        public Description getDescription() {
            return description;
        }
        public void setDescription(Description description) {
            this.description = description;
        }
        @SerializedName("pm25")
        public double pm25;
        @SerializedName("pm10")
        public double pm10;
        @SerializedName("co")
        public double co;
        @SerializedName("no2")
        public double no2;
        @SerializedName("o3")
        public double o3;
        @SerializedName("so2")
        public double so2;

        public double getPm25() {
            return pm25;
        }
        public double getPm10() {
            return pm10;
        }
        public double getCo() {
            return co;
        }
        public double getNo2() {
            return no2;
        }
        public double getO3() {
            return o3;
        }
        public double getSo2() {
            return so2;
        }
        public void setPm25(double pm25) {
            this.pm25 = pm25;
        }
        public void setPm10(double pm10) {
            this.pm10 = pm10;
        }
        public void setCo(double co) {
            this.co = co;
        }
        public void setNo2(double no2) {
            this.no2 = no2;
        }
        public void setO3(double o3) {
            this.o3 = o3;
        }
        public void setSo2(double so2) {
            this.so2 = so2;
        }

//        public class Aqi {
            //     @SerializedName("chn")
            //    public double chn;
            //    @SerializedName("usa")
            //   public double usa;
            //}

            public class Description {
                @SerializedName("chn")
                public String chn;
//                @SerializedName("usa")
//                public String usa;
                public String getChn() {
                    return chn;
                }
                public void setChn(String chn) {
                    this.chn = chn;
                }
            }
        }
    public class Life_index {
        @SerializedName("ultraviolet")
        public Ultraviolet ultraviolet;
        @SerializedName("comfort")
        public Comfort comfort;
        public Ultraviolet getUltraviolet() {
            return ultraviolet;
        }
        public void setUltraviolet(Ultraviolet ultraviolet) {
            this.ultraviolet = ultraviolet;
        }
        public Comfort getComfort() {
            return comfort;
        }
        public void setComfort(Comfort comfort) {
            this.comfort = comfort;
        }
        public class Ultraviolet {
//            @SerializedName("index")
//            public double index;
            @SerializedName("desc")
            public String desc;
            public String getUlDesc() {
                return desc;
            }
            public void setUlDesc(String desc) {
                this.desc = desc;
            }
        }

        public class Comfort {
//            @SerializedName("index")
//            public double index;
            @SerializedName("desc")
            public String desc;
            public String getComfortDesc() {
                return desc;
            }
            public void setComfortDesc(String desc) {
                this.desc = desc;
            }
        }
    }
    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public double getHumidity() {
        return humidity;
    }
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
    public String getSkycon() {
        return skycon;
    }
    public void setSkycon(String skycon) {
        this.skycon = skycon;
    }
    public double getVisibility() {
        return visibility;
    }
    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }
    public double getPressure() {
        return pressure;
    }
    public void setPressure(double pressure) {
        this.pressure = pressure;
    }
    public double getApparent_temperature() {
        return apparent_temperature;
    }
    public void setApparent_temperature(double apparent_temperature) {
        this.apparent_temperature = apparent_temperature;
    }
    public Wind getWind() {
        return wind;
    }
    public void setWind(Wind wind) {
        this.wind = wind;
    }
    public Precipitation getPrecipitation() {
        return precipitation;
    }
    public void setPrecipitation(Precipitation precipitation) {
        this.precipitation = precipitation;
    }
    public Air_quality getAir_quality() {
        return air_quality;
    }
    public void setAir_quality(Air_quality air_quality) {
        this.air_quality = air_quality;
    }
    public Life_index getLife_index() {
        return life_index;
    }
    public void setLife_index(Life_index life_index) {
        this.life_index = life_index;
    }
}
