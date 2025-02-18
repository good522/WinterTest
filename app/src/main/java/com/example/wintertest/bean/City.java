package com.example.wintertest.bean;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "city")
public class City {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @NonNull
    @ColumnInfo(name = "cityName")
    private String cityName;
    @ColumnInfo(name = "cityCode")
    private int cityCode;
    @ColumnInfo(name = "provinceId")
    private int provinceId;
    public City(@NonNull String cityName, int cityCode, int id, int provinceId)
    {
        this.cityName = cityName;
        this.cityCode = cityCode;
        this.id = id;
        this.provinceId = provinceId;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int Id)
    {
        this.id = id;
    }
    public String getCityName()
    {
        return cityName;
    }
    public void setCityName(@NonNull String cityName)
    {
        this.cityName = cityName;
    }
    public int getCityCode()
    {
        return cityCode;
    }
    public void setCityCode(int cityCode)
    {
        this.cityCode = cityCode;
    }
    public int getProvinceId()
    {
        return provinceId;
    }
    public void setProvinceId(int provinceId)
    {
        this.provinceId = provinceId;
    }
}
