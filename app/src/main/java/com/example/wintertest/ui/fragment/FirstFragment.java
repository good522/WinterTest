package com.example.wintertest.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.wintertest.R;
import com.example.wintertest.gson.Alert;
import com.example.wintertest.gson.Daily;
import com.example.wintertest.gson.Location;
import com.example.wintertest.gson.Realtime;
import com.example.wintertest.gson.Weather;
import com.example.wintertest.util.HttpUtil;
import com.example.wintertest.util.Utility;
import com.google.gson.Gson;

import java.io.IOException;
import java.text.DecimalFormat;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class FirstFragment extends Fragment {
    private Button mSeekButton;
    private TextView mkeypointTextView ,mlocationTextView,mrealtimeSpeedTextView, mrealtimePressTextView,
            mrealtimeTempTextView, mrealtimeHumTextView, mrealtimeSkyTextView, mrealtimeVisTextView, mrealtimeUltTextView,
            mrealtimeComfortTextView, mrealtimeDirectionTextView, mrealtimeapparentTextView, mrealtimeRainTextView,
            mrealtimePm25TextView, mrealtimeCoTextView, mrealtimeNo2TextView, mrealtimeO3TextView, mrealtimeSo2TextView,
            mrealtimePm10TextView, mrealtimeAirTextView, mstatusTextView, mtitleTextView,mdescriptionTextView,mrealtimeTextView,
            msunriseTextView, msunsetTextView,  mmaxTempTextView, mminTempTextView, mmaxHumTextView,mdailyTextView,
            mminHumTextView, mmaxRainTextView, mminRainTextView, mmaxVisTextView, mminVisTextView, mmaxPreTextView,
            mminPreTextView, mmaxSpeedTextView, mminSpeedTextView,mdaytimeProbTextView, mdaytimeSkyTextView,mnightProbTextView,
            mnightSkyTextView,multTextView, mclothesTextView, mcarTextView, mcomfortTextView, mcoldTextView, mEtcity;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @NonNull Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        mSeekButton = view.findViewById(R.id.seek_button);
        mEtcity = view.findViewById(R.id.city_editText);
        mrealtimeTextView = view.findViewById(R.id.realtime_View);
        mdailyTextView = view.findViewById(R.id.daily_View);
        mkeypointTextView = view.findViewById(R.id.forecast_keypoint_textView);
        mlocationTextView = view.findViewById(R.id.location_View);
        mrealtimeSpeedTextView = view.findViewById(R.id.realtime_speed_View);
        mrealtimePressTextView = view.findViewById(R.id.realtime_pressure_View);
        mrealtimeTempTextView = view.findViewById(R.id.realtime_temperature_View);
        mrealtimeHumTextView = view.findViewById(R.id.realtime_humidity_View);
        mrealtimeSkyTextView = view.findViewById(R.id.realtime_skycon_View);
        mrealtimeVisTextView = view.findViewById(R.id.realtime_visibility_View);
        mrealtimeUltTextView = view.findViewById(R.id.realtime_ultraviolet_View);
        mrealtimeComfortTextView = view.findViewById(R.id.realtime_comfort_View);
        mrealtimeDirectionTextView = view.findViewById(R.id.realtime_direction_View);
        mrealtimeapparentTextView = view.findViewById(R.id.realtime_apparent_View);
        mrealtimeRainTextView = view.findViewById(R.id.realtime_rain_View);
        mrealtimePm25TextView = view.findViewById(R.id.realtime_pm25_View);
        mrealtimeCoTextView = view.findViewById(R.id.realtime_co_View);
        mrealtimeNo2TextView = view.findViewById(R.id.realtime_no2_View);
        mrealtimeO3TextView = view.findViewById(R.id.realtime_o3_View);
        mrealtimeSo2TextView = view.findViewById(R.id.realtime_so2_View);
        mrealtimePm10TextView = view.findViewById(R.id.realtime_pm10_View);
        mrealtimeAirTextView = view.findViewById(R.id.realtime_air_View);
        mstatusTextView = view.findViewById(R.id.status_View);
        mtitleTextView = view.findViewById(R.id.alert_title_View);
        mdescriptionTextView = view.findViewById(R.id.alert_description_View);
        msunriseTextView = view.findViewById(R.id.daily_sunrise_View);
        msunsetTextView = view.findViewById(R.id.daily_sunset_View);
        mcoldTextView = view.findViewById(R.id.cold_View);
        mmaxTempTextView = view.findViewById(R.id.max_temperature_View);
        mminTempTextView = view.findViewById(R.id.min_temperature_View);
        mmaxHumTextView = view.findViewById(R.id.max_humidity_View);
        mminHumTextView = view.findViewById(R.id.min_humidity_View);
        mmaxRainTextView = view.findViewById(R.id.max_rain_View);
        mminRainTextView = view.findViewById(R.id.min_rain_View);
        mmaxVisTextView = view.findViewById(R.id.max_visibility_View);
        mminVisTextView = view.findViewById(R.id.min_visibility_View);
        mmaxPreTextView = view.findViewById(R.id.max_pressure_View);
        mminPreTextView = view.findViewById(R.id.min_pressure_View);
        mmaxSpeedTextView = view.findViewById(R.id.max_speed_View);
        mminSpeedTextView = view.findViewById(R.id.min_speed_View);
        mdaytimeProbTextView = view.findViewById(R.id.daytime_probability_View);
        mdaytimeSkyTextView = view.findViewById(R.id.daytime_skycon_View);
        mnightProbTextView = view.findViewById(R.id.night_probability_View);
        mnightSkyTextView = view.findViewById(R.id.night_skycon_View);
        multTextView = view.findViewById(R.id.ultraviolet_View);
        mclothesTextView = view.findViewById(R.id.clothes_View);
        mcarTextView = view.findViewById(R.id.car_washing_View);
        mcomfortTextView = view.findViewById(R.id.comfort_View);
        mdailyTextView = view.findViewById(R.id.daily_View);
        initClick();
        requestLocation();
        return view;
    }

    private void initClick() {
        mSeekButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestLocation();
            }
        });
    }

    private void requestLocation() {
        String city = mEtcity.getText().toString().trim();
        mlocationTextView.setText(city);
        if (city.equals("")) {
            Toast.makeText(getActivity(), "请输入城市名", Toast.LENGTH_SHORT).show();
        }
        if (city.equals("南岸区")) {
            double latitude = 29.51;
            double longitude = 106.6444;
            requestWeather(latitude, longitude);
        }
        if (city.equals("上海")) {
            double latitude = 39.2072;
            double longitude = 101.6656;
            requestWeather(latitude, longitude);
        }
        if (city.equals("曲靖")) {
            double latitude = 24.2100;
            double longitude= 103.0344;
            requestWeather(latitude, longitude);
        }if (!city.equals("南岸区") && !city.equals("上海") && !city.equals("曲靖") && !city.equals("" )){
            Toast.makeText(getActivity(), "暂不支持查询该城市", Toast.LENGTH_SHORT).show();
        }
    }
//        String locationUrl = "http://api.tianditu.gov.cn/geocoder?ds={city}&tk={API_KEY}";
//        String API_KEY = "e3d985d23359df9ad080c1afb998e0a6";
//        String locationUrl1 = locationUrl.replace("{city}", city).replace("{API_KEY}", API_KEY);
//        HttpUtil.sendOkHttpRequest(locationUrl1, new Callback() {
//            @Override
//            public void onFailure(@NonNull Call call, @NonNull IOException e) {
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (getActivity() != null) {
//                            Toast.makeText(getActivity(), "获取地理信息失败", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//            }
//            @Override
//            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//                String responseText = response.body().string();
//                Log.d("FirstFragmentLocation", "onResponse: " +responseText);
//                double[] latLon = Utility.responseLocation(responseText);
//                if (latLon != null && latLon.length == 2) {
//                    requestWeather(latLon[0], latLon[1]);
//                } else {
//                    getActivity().runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            if (getActivity() != null) {
//                                Toast.makeText(getActivity(), "获取经纬度信息失败", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//                }
//            }
//        });
//    }

    private void requestWeather(double latitude, double longitude) {
        String weatherUrl = "https://api.caiyunapp.com/v2.6/mys3DOoRqU0tLWvu/" + longitude + "," + latitude + "/weather?dailysteps=1&hourlysteps=24";
        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), "获取天气信息失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String responseText = response.body().string();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        handleWeatherResponse(responseText);
                        Log.d("FirstFragmentWeather", "onResponse: " + responseText);
                    }
                    public String handleWeatherResponse(String responseText) {
                        Gson gson = new Gson();
                        Weather weather = gson.fromJson(responseText, Weather.class);
                        Weather.Result result = weather.getResult();
                        if (result != null){
                        mkeypointTextView.setText(result.getForecast_keypoint());
                            Alert alert = result.getAlert();
                            Log.d("alert", "预警" + alert);
                            if (alert != null) {
                                responseAlert(alert);
                            }else {
                                mstatusTextView.setText("暂无");

                            }
                            Realtime realtime = result.getRealtime();
                            Log.d("realtime", "实况" + realtime);
                            if (realtime != null) {
                                responseRealtime(realtime);
                            }else {
                                mrealtimeTextView.setText("暂无");
                            }
                            Daily daily = result.getDaily();
                            Log.d("daily", "今日" + daily);
                            if (daily != null) {
                                responseDaily(daily);
                            }else {
                                mdailyTextView.setText("暂无");
                            }
                        }
                        return responseText;

                    }

                    private void responseDaily(Daily daily) {
                        Daily.Temperature[] temperature = daily.getTemperature();
                        for (int i = 0; i < temperature.length; i++) {
                            if (temperature[i] != null) {
                                Daily.Temperature temperature1 = temperature[i];
                                if (temperature1 != null) {
                                    mmaxTempTextView.setText(String.valueOf(temperature1.getMax()));
                                    mminTempTextView.setText(String.valueOf(temperature1.getMin()));
                                } else {
                                    mmaxTempTextView.setText("暂无");
                                    mminTempTextView.setText("暂无");
                                }
                            }
                        }
                        Daily.Humidity[] humidity = daily.getHumidity();
                        for (int i = 0; i < humidity.length; i++) {
                            if (humidity[i] != null) {
                                Daily.Humidity humidity1 = humidity[i];
                                if (humidity1 != null) {
                                    DecimalFormat df = new DecimalFormat("#.00");
                                    mmaxHumTextView.setText(String.valueOf(df.format(humidity1.getMax())));
                                    mminHumTextView.setText(String.valueOf(df.format(humidity1.getMin())));
                                } else {
                                    mmaxHumTextView.setText("暂无");
                                    mminHumTextView.setText("暂无");
                                }
                            }
                        }
                        Daily.Astro[] astro = daily.getAstro();
                        for (int i = 0; i < astro.length; i++) {
                            if (astro[i] != null) {
                                Daily.Astro astro1 = astro[i];
                                if (astro1 != null) {
                                    astro1.sunrise = astro1.getSunrise();
                                    astro1.sunset = astro1.getSunset();
                                    if (astro1.sunrise != null) {
                                        Daily.Astro.Sunrise sunrise = astro1.sunrise;
                                        msunriseTextView.setText(sunrise.getTime());
                                    } else {
                                        msunriseTextView.setText("暂无");
                                    }
                                    if (astro1.sunset != null) {
                                        Daily.Astro.Sunset sunset = astro1.sunset;
                                        msunsetTextView.setText(sunset.getTime());
                                    } else {
                                        msunsetTextView.setText("暂无");
                                    }
                                }
                            }
                        }
                        Daily.Precipitation_08h_20h[] precipitation_08h_20hList = daily.getPrecipitation_08h_20h();
                        for (int i = 0; i < precipitation_08h_20hList.length; i++) {
                            if (precipitation_08h_20hList[i] != null) {
                                Daily.Precipitation_08h_20h precipitation_08h_20h = precipitation_08h_20hList[i];
                                if (precipitation_08h_20h != null) {
                                    mdaytimeProbTextView.setText(String.valueOf(precipitation_08h_20h.getProbability()));
                                } else {
                                    mdaytimeProbTextView.setText("暂无");
                                }
                            }
                        }
                        Daily.Precipitation_20h_32h[] precipitation_20h_32hList = daily.getPrecipitation_20h_32h();
                        for (int i = 0; i < precipitation_20h_32hList.length; i++) {
                            if (precipitation_20h_32hList[i] != null) {
                                Daily.Precipitation_20h_32h precipitation_20h_32h = precipitation_20h_32hList[i];
                                if (precipitation_20h_32h != null) {
                                    mnightProbTextView.setText(String.valueOf(precipitation_20h_32h.getProbability()));
                                } else {
                                    mnightProbTextView.setText("暂无");
                                }
                            }
                        }
                        Daily.Precipitation[] precipitation = daily.getPrecipitation();
                        for (int i = 0; i < precipitation.length; i++) {
                            if (precipitation[i] != null) {
                                Daily.Precipitation precipitation1 = precipitation[i];
                                if (precipitation1 != null) {
                                    mmaxRainTextView.setText(String.valueOf(precipitation1.getMax()));
                                    mminRainTextView.setText(String.valueOf(precipitation1.getMin()));
                                } else {
                                    mmaxRainTextView.setText("暂无");
                                    mminRainTextView.setText("暂无");
                                }
                            }
                        }
                        Daily.Wind[] wind = daily.getWind();
                        for (int i = 0; i < wind.length; i++) {
                            if (wind[i] != null) {
                                Daily.Wind wind1 = wind[i];
                                if (wind1 != null) {
                                    wind1.max = wind1.getMax();
                                    wind1.min = wind1.getMin();
                                }
                                if (wind1.getMax() != null) {
                                    mmaxSpeedTextView.setText(String.valueOf(wind1.max.getSpeed()));
                                    mminSpeedTextView.setText(String.valueOf(wind1.min.getSpeed()));
                                } else {
                                    mmaxSpeedTextView.setText("暂无");
                                    mminSpeedTextView.setText("暂无");
                                }
                            }
                        }
                        Daily.Pressure[] pressure = daily.getPressure();
                        for (int i = 0; i < pressure.length; i++) {
                            if (pressure[i] != null) {
                                Daily.Pressure pressure1 = pressure[i];
                                if (pressure1 != null) {
                                    mminPreTextView.setText(String.valueOf(pressure1.getMax()));
                                    mminPreTextView.setText(String.valueOf(pressure1.getMin()));
                                } else {
                                    mmaxPreTextView.setText("暂无");
                                    mminPreTextView.setText("暂无");
                                }
                            }
                        }
                        Daily.Visibility[] visibility = daily.getVisibility();
                        for (int i = 0; i < visibility.length; i++) {
                            if (visibility[i] != null) {
                                Daily.Visibility visibility1 = visibility[i];
                                if (visibility1 != null) {
                                    mmaxVisTextView.setText(String.valueOf(visibility1.getMax()));
                                    mminVisTextView.setText(String.valueOf(visibility1.getMin()));
                                } else {
                                    mmaxVisTextView.setText("暂无");
                                    mminVisTextView.setText("暂无");
                                }
                            }
                        }
                        Daily.Skycon[] skycon = daily.getSkycon();
                        for (int i = 0; i < skycon.length; i++) {
                            if (skycon[i] != null) {
                                Daily.Skycon skycon1 = skycon[i];
                                if (skycon1 != null) {
                                    skycon1.value = skycon1.getValue();
                                } else {
                                    skycon1.setValue("暂无");
                                }
                            }
                        }
                        Daily.Skycon_08h_20h[] skycon_08h_20h = daily.getSkycon_08h_20h();
                        for (int i = 0; i < skycon_08h_20h.length; i++) {
                            if (skycon_08h_20h[i] != null) {
                                Daily.Skycon_08h_20h skycon_08h_20h1 = skycon_08h_20h[i];
                                if (skycon_08h_20h1 != null) {
                                    mdaytimeSkyTextView.setText(String.valueOf(skycon_08h_20h1.getValue()));
                                } else {
                                    mdaytimeSkyTextView.setText("暂无");
                                }
                            }
                        }
                        Daily.Skycon_20h_32h[] skycon_20h_32h = daily.getSkycon_20h_32h();
                        for (int i = 0; i < skycon_20h_32h.length; i++) {
                            if (skycon_20h_32h[i] != null) {
                                Daily.Skycon_20h_32h skycon_20h_32h1 = skycon_20h_32h[i];
                                if (skycon_20h_32h1 != null) {
                                    mnightSkyTextView.setText(String.valueOf(skycon_20h_32h1.getValue()));
                                } else {
                                    mnightSkyTextView.setText("暂无");
                                }
                            }
                        }
                        Daily.Life_index life_index = daily.getLife_index();
                        if (life_index != null) {
                            if (life_index.comfort != null) {
                                life_index.comfort = life_index.getComfort();
                                for (int i = 0; i < life_index.comfort.length; i++) {
                                    if (life_index.comfort[i] != null) {
                                        mcomfortTextView.setText(String.valueOf(life_index.comfort[i].getDesc()));
                                    } else {
                                        mcomfortTextView.setText("暂无");
                                    }
                                }
                            } else {
                                mcomfortTextView.setText("暂无");
                            }
                            if (life_index.coldRisk != null) {
                                life_index.coldRisk = life_index.getColdRisk();
                                for (int i = 0; i < life_index.coldRisk.length; i++) {
                                    if (life_index.coldRisk[i] != null) {
                                        mcoldTextView.setText(String.valueOf(life_index.coldRisk[i].getDesc()));
                                    } else {
                                        mcoldTextView.setText("暂无");
                                    }
                                }
                            } else {
                                mcoldTextView.setText("暂无");
                            }
                            if (life_index.dressing != null) {
                                life_index.dressing = life_index.getDressing();
                                for (int i = 0; i < life_index.dressing.length; i++) {
                                    if (life_index.dressing[i] != null) {
                                        mclothesTextView.setText(String.valueOf(life_index.dressing[i].getDesc()));
                                    } else {
                                        mclothesTextView.setText("暂无");
                                    }
                                }
                            } else {
                                mclothesTextView.setText("暂无");
                            }
                            if (life_index.ultraviolet != null) {
                                life_index.ultraviolet = life_index.getUltraviolet();
                                for (int i = 0; i < life_index.ultraviolet.length; i++) {
                                    if (life_index.ultraviolet[i] != null) {
                                        multTextView.setText(String.valueOf(life_index.ultraviolet[i].getDesc()));
                                    } else {
                                        multTextView.setText("暂无");
                                    }
                                }
                            } else {
                                multTextView.setText("暂无");
                            }
                            if (life_index.carWashing != null) {
                                life_index.carWashing = life_index.getCarWashing();
                                for (int i = 0; i < life_index.carWashing.length; i++) {
                                    if (life_index.carWashing[i] != null) {
                                        mcarTextView.setText(String.valueOf(life_index.carWashing[i].getDesc()));
                                    } else {
                                        mcarTextView.setText("暂无");
                                    }
                                }
                            }else {
                                mcarTextView.setText("暂无");
                            }
                        }
                    }

                    public void responseAlert(Alert alert) {
                        Alert.Content[] content = alert.getContent();
                        for (int i = 0; i < content.length; i++) {
                            Alert.Content content1 = content[i];
                            if (content1 != null) {
                                mstatusTextView.setText(alert.getContent()[0].getStatus());
                                mtitleTextView.setText(alert.getContent()[0].getTitle());
                                mdescriptionTextView.setText(alert.getContent()[0].getDescription());
                                if (content1.status == null) {
                                    mstatusTextView.setText("暂无");
                                }
                            }
                        }
                    }
                    public void responseRealtime(Realtime realtime) {
                        Realtime.Life_index life_index = realtime.getLife_index();
                        if (life_index != null) {
                            Realtime.Life_index.Comfort comfort = life_index.getComfort();
                            if (comfort != null) {
                                mrealtimeComfortTextView.setText(life_index.getComfort().getComfortDesc());
                            }else {
                                mrealtimeComfortTextView.setText("暂无");
                            }
                            Realtime.Life_index.Ultraviolet ultraviolet = life_index.getUltraviolet();
                            if (ultraviolet != null) {
                                mrealtimeUltTextView.setText(life_index.getUltraviolet().getUlDesc());
                            }else {
                                mrealtimeUltTextView.setText("暂无");
                            }
                        }
                        Realtime.Air_quality air_quality = realtime.getAir_quality();
                        if (air_quality != null) {
                            Realtime.Air_quality.Description description = air_quality.getDescription();
                            if (description != null) {
                                mrealtimeAirTextView.setText(description.getChn());
                            }else {
                                mrealtimeAirTextView.setText("暂无");
                            }
                            DecimalFormat df = new DecimalFormat("#.00");
                            mrealtimeCoTextView.setText(String.valueOf(df.format(air_quality.getCo())));
                            mrealtimeNo2TextView.setText(String.valueOf(df.format(air_quality.getNo2())));
                            mrealtimeO3TextView.setText(String.valueOf(df.format(air_quality.getO3())));
                            mrealtimePm25TextView.setText(String.valueOf(df.format(air_quality.getPm25())));
                            mrealtimePm10TextView.setText(String.valueOf(df.format(air_quality.getPm10())));
                            mrealtimeSo2TextView.setText(String.valueOf(df.format(air_quality.getSo2())));
                        }else {
                            mrealtimeCoTextView.setText("暂无");
                            mrealtimeNo2TextView.setText("暂无");
                            mrealtimeO3TextView.setText("暂无");
                            mrealtimePm25TextView.setText("暂无");
                            mrealtimePm10TextView.setText("暂无");
                            mrealtimeSo2TextView.setText("暂无");
                        }
                        Realtime.Precipitation precipitation = realtime.getPrecipitation();
                        if (precipitation != null) {
                            Realtime.Precipitation.Local local = precipitation.getLocal();
                            if (local != null) {
                                mrealtimeRainTextView.setText(String.valueOf(local.getIntensity()));
                            }else {
                                mrealtimeRainTextView.setText("暂无");
                            }
                        }
                        Realtime.Wind wind = realtime.getWind();
                        if (wind != null) {
                            mrealtimeSpeedTextView.setText(String.valueOf(wind.getSpeed()));
                            mrealtimeDirectionTextView.setText(wind.getDirection());
                        }else {
                            mrealtimeSpeedTextView.setText("暂无");
                            mrealtimeDirectionTextView.setText("暂无");
                        }
                        mrealtimeHumTextView.setText(String.valueOf(realtime.getHumidity()));
                        mrealtimePressTextView.setText(String.valueOf(realtime.getPressure()));
                        mrealtimeTempTextView.setText(String.valueOf(realtime.getTemperature()));
                        mrealtimeVisTextView.setText(String.valueOf(realtime.getVisibility()));
                        mrealtimeapparentTextView.setText(String.valueOf(realtime.getApparent_temperature()));
                        mrealtimeSkyTextView.setText(realtime.getSkycon());
                    }
                });
            }
        });
    }
}