package com.example.wintertest.bean;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "province")
public class Province  {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @NonNull
    @ColumnInfo(name = "provinceName")
    private String provinceName;
    @ColumnInfo(name = "provinceCode")
    private int provinceCode;
    public Province(@NonNull String provinceName, int id, int provinceCode){
        this.provinceName = provinceName;
        this.id = id;
        this.provinceCode = provinceCode;
    }
    @NonNull
    public String getProvinceName(){
        return provinceName;
    }
    public void setProvinceName(@NonNull String provinceName){
        this.provinceName = provinceName;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getProvinceCode(){
        return provinceCode;
    }
    public void setProvinceCode(int provinceCode){
        this.provinceCode = provinceCode;
    }
}
