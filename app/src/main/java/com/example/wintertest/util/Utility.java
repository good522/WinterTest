package com.example.wintertest.util;

import android.util.Log;

import androidx.annotation.Nullable;

//import com.example.wintertest.bean.County;
import com.example.wintertest.gson.Alert;
import com.example.wintertest.gson.Daily;
import com.example.wintertest.gson.Health;
import com.example.wintertest.gson.Location;
import com.example.wintertest.gson.Realtime;
//import com.example.wintertest.helper.AreaDao;
//import com.example.wintertest.helper.AreaDataBase;
import com.example.wintertest.gson.Weather;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class Utility {
//    public static boolean handleProvinceResponse(String response) {
//        if (!TextUtils.isEmpty(response)) {
//            try {
//                JSONArray allProvinces = new JSONArray(response);
//                for (int i = 0; i < allProvinces.length(); i++) {
//                    JSONObject provinceObject = allProvinces.getJSONObject(i);
//                    AreaDao areaDao = AreaDataBase.getInstance(null).areaDao();
//                    if (areaDao.checkIfProvinceExists(provinceObject.getString("name")) == 0) {
//                            Province province = new Province(provinceObject.getString("name"),
//                                    provinceObject.getInt("id"),
//                                    provinceObject.getInt("province_code"));
//                            areaDao.insertProvince(province);
//                    }
//                }
//                return true;
//            }catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return false;
//    }
//    public static boolean handleCityResponse(String response){
//        if (!TextUtils.isEmpty(response)) {
//            try {
//                JSONArray allCities = new JSONArray(response);
//                for (int i = 0; i < allCities.length(); i++) {
//                    JSONObject cityObject = allCities.getJSONObject(i);
//                    AreaDao areaDao = AreaDataBase.getInstance(null).areaDao();
//                    if (areaDao.checkIfCityExists(cityObject.getString("name")) == 0) {
//                        City city = new City(cityObject.getString("name"),
//                                cityObject.getInt("id"),
//                                cityObject.getInt("city_code"),
//                                cityObject.getInt("province_id"));
//                        areaDao.insertCity(city);
//                    }
//                    return true;
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        return false;
//    }
//    public static boolean handleCountyResponse(String response){
//        if (!TextUtils.isEmpty(response)) {
//            try {
//                JSONArray allCounties = new JSONArray(response);
//                for (int i = 0; i < allCounties.length(); i++) {
//                    JSONObject countyObject = allCounties.getJSONObject(i);
//                    AreaDao areaDao = AreaDataBase.getInstance(null).areaDao();
//                    if (areaDao.checkIfCountyExists(countyObject.getString("name")) == 0) {
//                        County county = new County(countyObject.getString("name"),
//                                countyObject.getInt("id"),
//                                countyObject.getInt("county_code"),
//                                countyObject.getInt("city_id"));
//                    }
//                    return true;
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        return false;
//    }
//    public static String handleWeatherResponse(String responseText) {
//                Gson gson = new Gson();
//                Weather weather = gson.fromJson(responseText, Weather.class);
//                Alert alert = weather.getAlert();
//                Log.d("alert", "预警" + alert);
//                if (alert != null) {
//                    responseAlert(alert);
//                }
//                Realtime realtime = weather.getRealtime();
//                Log.d("realtime", "实况" + realtime);
//                if (realtime != null) {
//                    responseRealtime(realtime);
//                }
//                Daily daily = weather.getDaily();
//                Log.d("daily", "今日" + daily);
//                if (daily != null) {
//                    responseDaily(daily);
//                }
//        return responseText;
//    }
//
//    private static void responseDaily(Daily daily) {
//        Daily.Temperature[] temperature = daily.getTemperature();
//        for (int i = 0; i < temperature.length; i++) {
//            if (temperature[i] != null) {
//                Daily.Temperature temperature1 = temperature[i];
//                if (temperature1 != null) {
//                    temperature1.max = temperature1.getMax();
//                    temperature1.min = temperature1.getMin();
//                } else {
//                    temperature1.setMax(0);
//                    temperature1.setMin(0);
//                }
//            }
//        }
//        Daily.Humidity[] humidity = daily.getHumidity();
//        for (int i = 0; i < humidity.length; i++) {
//            if (humidity[i] != null) {
//                Daily.Humidity humidity1 = humidity[i];
//                if (humidity1 != null) {
//                    humidity1.max = humidity1.getMax();
//                    humidity1.min = humidity1.getMin();
//                } else {
//                    humidity1.setMax(0);
//                    humidity1.setMin(0);
//                }
//            }
//        }
//        Daily.Astro[] astro = daily.getAstro();
//        for (int i = 0; i < astro.length; i++) {
//            if (astro[i] != null) {
//                Daily.Astro astro1 = astro[i];
//                if (astro1 != null) {
//                    astro1.sunrise = astro1.getSunrise();
//                    astro1.sunset = astro1.getSunset();
//                    if (astro1.sunrise != null) {
//                        Daily.Astro.Sunrise sunrise = astro1.sunrise;
//                        sunrise.time = sunrise.getTime();
//                    } else {
//                        astro1.sunrise.setTime("暂无");
//                    }
//                    if (astro1.sunset != null) {
//                        Daily.Astro.Sunset sunset = astro1.sunset;
//                        sunset.time = sunset.getTime();
//                    } else {
//                        astro1.sunset.setTime("暂无");
//                    }
//                }
//            }
//        }
//        Daily.Precipitation_08h_20h[] precipitation_08h_20hList = daily.getPrecipitation_08h_20h();
//        for (int i = 0; i < precipitation_08h_20hList.length; i++) {
//            if (precipitation_08h_20hList[i] != null) {
//                Daily.Precipitation_08h_20h precipitation_08h_20h = precipitation_08h_20hList[i];
//                if (precipitation_08h_20h != null) {
//                    precipitation_08h_20h.probability = precipitation_08h_20h.getProbability();
//                } else {
//                    precipitation_08h_20h.setProbability(0);
//                }
//            }
//        }
//        Daily.Precipitation_20h_32h[] precipitation_20h_32hList = daily.getPrecipitation_20h_32h();
//        for (int i = 0; i < precipitation_20h_32hList.length; i++) {
//            if (precipitation_20h_32hList[i] != null) {
//                Daily.Precipitation_20h_32h precipitation_20h_32h = precipitation_20h_32hList[i];
//                if (precipitation_20h_32h != null) {
//                    precipitation_20h_32h.probability = precipitation_20h_32h.getProbability();
//                } else {
//                    precipitation_20h_32h.setProbability(0);
//                }
//            }
//        }
//        Daily.Precipitation[] precipitation = daily.getPrecipitation();
//        for (int i = 0; i < precipitation.length; i++) {
//            if (precipitation[i] != null) {
//                Daily.Precipitation precipitation1 = precipitation[i];
//                if (precipitation1 != null) {
//                    precipitation1.max = precipitation1.getMax();
//                    precipitation1.min = precipitation1.getMin();
//                } else {
//                    precipitation1.setMax(0);
//                    precipitation1.setMin(0);
//                }
//            }
//        }
//        Daily.Wind[] wind = daily.getWind();
//        for (int i = 0; i < wind.length; i++) {
//            if (wind[i] != null) {
//                Daily.Wind wind1 = wind[i];
//                if (wind1 != null) {
//                    wind1.max = wind1.getMax();
//                    wind1.min = wind1.getMin();
//                }
//                if (wind1.getMax() != null) {
//                    wind1.max.speed = wind1.getMax().getSpeed();
//                    wind1.max.direction = wind1.getMax().getDirection();
//                } else {
//                    wind1.max.setSpeed(0);
//                    wind1.max.setDirection(0);
//                }
//            }
//        }
//        Daily.Pressure[] pressure = daily.getPressure();
//        for (int i = 0; i < pressure.length; i++) {
//            if (pressure[i] != null) {
//                Daily.Pressure pressure1 = pressure[i];
//                if (pressure1 != null) {
//                    pressure1.max = pressure1.getMax();
//                    pressure1.min = pressure1.getMin();
//                } else {
//                    pressure1.setMax(0);
//                    pressure1.setMin(0);
//                }
//            }
//        }
//        Daily.Visibility[] visibility = daily.getVisibility();
//        for (int i = 0; i < visibility.length; i++) {
//            if (visibility[i] != null) {
//                Daily.Visibility visibility1 = visibility[i];
//                if (visibility1 != null) {
//                    visibility1.max = visibility1.getMax();
//                    visibility1.min = visibility1.getMin();
//                } else {
//                    visibility1.setMax(0);
//                    visibility1.setMin(0);
//                }
//            }
//        }
//        Daily.Skycon[] skycon = daily.getSkycon();
//        for (int i = 0; i < skycon.length; i++) {
//            if (skycon[i] != null) {
//                Daily.Skycon skycon1 = skycon[i];
//                if (skycon1 != null) {
//                    skycon1.value = skycon1.getValue();
//                } else {
//                    skycon1.setValue("暂无");
//                }
//            }
//        }
//        Daily.Skycon_08h_20h[] skycon_08h_20h = daily.getSkycon_08h_20h();
//        for (int i = 0; i < skycon_08h_20h.length; i++) {
//            if (skycon_08h_20h[i] != null) {
//                Daily.Skycon_08h_20h skycon_08h_20h1 = skycon_08h_20h[i];
//                if (skycon_08h_20h1 != null) {
//                    skycon_08h_20h1.value = skycon_08h_20h1.getValue();
//                } else {
//                    skycon_08h_20h1.setValue("暂无");
//                }
//            }
//        }
//        Daily.Skycon_20h_32h[] skycon_20h_32h = daily.getSkycon_20h_32h();
//        for (int i = 0; i < skycon_20h_32h.length; i++) {
//            if (skycon_20h_32h[i] != null) {
//                Daily.Skycon_20h_32h skycon_20h_32h1 = skycon_20h_32h[i];
//                if (skycon_20h_32h1 != null) {
//                    skycon_20h_32h1.value = skycon_20h_32h1.getValue();
//                } else {
//                    skycon_20h_32h1.setValue("暂无");
//                }
//            }
//        }
//        Daily.Life_index life_index = daily.getLife_index();
//        if (life_index != null) {
//            life_index.comfort = life_index.getComfort();
//            for (int i = 0; i < life_index.comfort.length; i++) {
//                if (life_index.comfort[i] != null) {
//                    life_index.comfort[i].desc = life_index.comfort[i].getDesc();
//                } else {
//                    life_index.comfort[i].setDesc("暂无");
//                }
//            }
//            life_index.coldRisk = life_index.getColdRisk();
//            for (int i = 0; i < life_index.coldRisk.length; i++) {
//                if (life_index.coldRisk[i] != null) {
//                    life_index.coldRisk[i].desc = life_index.coldRisk[i].getDesc();
//                } else {
//                    life_index.coldRisk[i].setDesc("暂无");
//                }
//            }
//            life_index.dressing = life_index.getDressing();
//            for (int i = 0; i < life_index.dressing.length; i++) {
//                if (life_index.dressing[i] != null) {
//                    life_index.dressing[i].desc = life_index.dressing[i].getDesc();
//                } else {
//                    life_index.dressing[i].setDesc("暂无");
//                }
//            }
//            life_index.ultraviolet = life_index.getUltraviolet();
//            for (int i = 0; i < life_index.ultraviolet.length; i++) {
//                if (life_index.ultraviolet[i] != null) {
//                    life_index.ultraviolet[i].desc = life_index.ultraviolet[i].getDesc();
//                } else {
//                    life_index.ultraviolet[i].setDesc("暂无");
//                }
//            }
//            life_index.carWashing = life_index.getCarWashing();
//            for (int i = 0; i < life_index.carWashing.length; i++) {
//                if (life_index.carWashing[i] != null) {
//                    life_index.carWashing[i].desc = life_index.carWashing[i].getDesc();
//                } else {
//                    life_index.carWashing[i].setDesc("暂无");
//                }
//            }
//        }
//    }
//
//    public static void responseAlert(Alert alert) {
//            Alert.Content[] content = alert.getContent();
//            for (int i = 0; i < content.length; i++) {
//                Alert.Content content1 = content[i];
//                if (content1 != null) {
//                    content1.status = content1.getStatus();
//                    content1.description = content1.getDescription();
//                    content1.title = content1.getTitle();
//                    content1.county = content1.getCounty();
//                    content1.city = content1.getCity();
//                    content1.province = content1.getProvince();
//                    if (content1.status == null) {
//                        content1.setStatus("暂无");
//                    }
//                }
//            }
//    }
//    public static void responseRealtime(Realtime realtime) {
//        Realtime.Life_index life_index = realtime.getLife_index();
//        if (life_index != null) {
//            Realtime.Life_index.Comfort comfort = life_index.getComfort();
//            if (comfort != null) {
//                 comfort.desc = comfort.getComfortDesc();
//            }else {
//                comfort.setComfortDesc("暂无");
//            }
//            Realtime.Life_index.Ultraviolet ultraviolet = life_index.getUltraviolet();
//            if (ultraviolet != null) {
//                ultraviolet.desc = ultraviolet.getUlDesc();
//            }else {
//                ultraviolet.setUlDesc("暂无");
//            }
//        }
//        Realtime.Air_quality air_quality = realtime.getAir_quality();
//        if (air_quality != null) {
//            Realtime.Air_quality.Description description = air_quality.getDescription();
//            if (description != null) {
//                String chn = description.getChn();
//            }else {
//                description.setChn("暂无");
//            }
//            air_quality.co = air_quality.getCo();
//            air_quality.no2 = air_quality.getNo2();
//            air_quality.o3 = air_quality.getO3();
//            air_quality.pm10 = air_quality.getPm10();
//            air_quality.pm25 = air_quality.getPm25();
//            air_quality.so2 = air_quality.getSo2();
//        }else {
//            air_quality.setCo(0);
//            air_quality.setNo2(0);
//            air_quality.setO3(0);
//            air_quality.setPm10(0);
//            air_quality.setPm25(0);
//            air_quality.setSo2(0);
//        }
//        Realtime.Precipitation precipitation = realtime.getPrecipitation();
//        if (precipitation != null) {
//            Realtime.Precipitation.Local local = precipitation.getLocal();
//            if (local != null) {
//                local.intensity = local.getIntensity();
//            }else {
//                local.setIntensity(0);
//            }
//        }
//        Realtime.Wind wind = realtime.getWind();
//        if (wind != null) {
//            wind.direction = wind.getDirection();
//            wind.speed = wind.getSpeed();
//        }else {
//            wind.setDirection("暂无");
//            wind.setSpeed(0);
//        }
//        realtime.humidity = realtime.getHumidity();
//        realtime.pressure = realtime.getPressure();
//        realtime.temperature = realtime.getTemperature();
//        realtime.visibility = realtime.getVisibility();
//        realtime.skycon = realtime.getSkycon();
//        realtime.apparent_temperature = realtime.getApparent_temperature();
//    }

    @Nullable
    public static double[] responseLocation(String responseText) {
        try {
            Gson gson = new Gson();
            Location location = gson.fromJson(responseText, Location.class);
            if (location != null) {
                double[] locationArray = new double[2];
                locationArray[0] = location.getLat();
                locationArray[1] = location.getLon();
                return locationArray;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
//    @Nullable
//    public static String responseHealth(String responseText) {
//        try {
//            Gson gson = new Gson();
//            Health health = gson.fromJson(responseText, Health.class);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }
}
