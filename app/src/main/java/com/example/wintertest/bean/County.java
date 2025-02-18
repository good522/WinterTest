package com.example.wintertest.bean;

//import androidx.annotation.NonNull;
//import androidx.room.ColumnInfo;
//import androidx.room.Entity;
//import androidx.room.PrimaryKey;
//
//@Entity(tableName = "county")
//public class County {
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "id")
//    private int Id;
//    @NonNull
//    @ColumnInfo(name = "countyName")
//    private String countyName;
//    @ColumnInfo(name = "countyCode")
//    private int countyCode;
//    @ColumnInfo(name = "cityId")
//    private int cityId;
//    public County(@NonNull String countyName, int countyCode, int id, int cityId)
//    {
//        this.countyName = countyName;
//        this.countyCode = countyCode;
//        this.Id = id;
//        this.cityId = cityId;
//    }
//    public int getId()
//    {
//        return Id;
//    }
//    public void setId(int Id)
//    {
//        this.Id = Id;
//    }
//    public String getCountyName()
//    {
//        return countyName;
//    }
//    public void setCountyName(@NonNull String countyName)
//    {
//        this.countyName = countyName;
//    }
//    public int getCountyCode()
//    {
//        return countyCode;
//    }
//    public void setCountyCode(int countyCode)
//    {
//        this.countyCode = countyCode;
//    }
//    public int getCityId()
//    {
//        return cityId;
//    }
//    public void setCityId(int cityId)
//    {
//        this.cityId = cityId;
//    }
//}
